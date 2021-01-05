package challenges;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.net.*;
import com.google.gson.Gson;
/**
 Goal: Find the most important words for each song description. Importance of a word is denoted by its tf-idf score.
 Input: file with app IDs

 Notes:
 Example IDs didnt work. I did find a working id on apple.com. ID=284910350
 API Output:
 Upon calling this API, the output has the following response format:
 {
 "resultCount": 1
 "results":[
 {
 "trackId":284910350,
 "releaseNotes": "A few things we're thankful for...",
 "currency": "USD",
 "description": "Yelp has over 199 million reviews of business worldwide."
 }
 ]
 }

 Assumptions:
 => The input is all valid apps and the resultCount is always 1 since each app is unique.
 => The desriptions are all in english.
 => Using Gson for json parsing is ok.

 what is term frequency? tf(term, doc) = n/N => n is number of times term occurs in doc, N is total number of words in doc.
 what is IDF ? idf(term, Docs) = log(N/n) => N is total number of documents. n is number of documents that contain term.
 tf-idf = tf * idf.

 Design:
 -> Read file by line and add the IDs to a list. The IDs are assumed to be unique and formatted as per the description given.
 -> Iterate over the list and for each ID, do a GET on the ID and get result.
 -> For each GET, get the JSON object and get the value of "description" key in the "results" array value.
 -> Have a App object model where each doc has the following attributes:
 - id
 - tf map
 - tf-idf map
 -> For each document, parse the description to get the words. For each word in the document, first create a frequency map and calculate TF-Map using frequencyMap.
 -> Maintain a running set of list of total words.
 -> Calculate IDF for each word in the list of total words by iterating over the list of documents and update IDF-Map.
 -> Using the calculated IDF-Map, populate the ranked tf-idf map for each App object model.
 -> Finally create list of result objects with id and its tf-idf map.

 */
public class AppRanker {

    //TF-IDF values populated in tfIdfMap.
    Map<Integer, Map<String, Double>> tfIdfMap = null;

    //Contains all the words.
    Set<String> principalWordSet = null;

    //Records idf for all words.
    Map<String, Double> idfMap = null;

    /**
     Read file object to generate TF-IDF map output for the appId entries in file.
     */
    public Map<Integer, Map<String, Double>> getTFIDFMap (final File file) throws TFIDFException
    {
        int limit = 10;
        idfMap = new HashMap<>();
        tfIdfMap = new HashMap<>();
        principalWordSet = new HashSet<>();

        /* Iterate over each ID and construct AppModel with appId and tfMap. */
        List<AppModel> appModels = generateAppModels(file);

        /* generate idf for all words. */
        populateIdfMap(appModels);

        /* calculate tf-idf for limit. */
        for(AppModel app : appModels) {
            populateAppTFIDF(app, limit);
        }

        /* populate result. */
        for(AppModel app : appModels) {
            tfIdfMap.put(app.getAppId(), app.getTFIDFMap());
        }

        return tfIdfMap;
    }

    /**
     Read file object and process each ID to generate the AppModel with appId and tfMap.
     */
    private List<AppModel> generateAppModels (final File file) throws TFIDFException
    {
        List<AppModel> appModels = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String inputAppIdLine = br.readLine();

            while (inputAppIdLine != null) {
                AppModel appModel = processDocMetadataForInput(inputAppIdLine);
                appModels.add(appModel);
                inputAppIdLine = br.readLine();
            }

            return appModels;
        }
        catch (Exception e) {
            throw new TFIDFException(e.getMessage());
        }
    }

    /**
     Populate Idf map.
     idf(term, Docs) = log(N/n) => N is total number of documents. n is number of documents that contain term.
     */
    private void populateIdfMap (final List<AppModel> appModels)
    {
        Map<String, Integer> wordsToDocMap = new HashMap<>();
        /* Count how many docs each word is in. */
        for (String word : this.principalWordSet) {
            for(AppModel app : appModels) {
                if(app.getTFMap().containsKey(word)) {
                    wordsToDocMap.put(word, wordsToDocMap.getOrDefault(word, 0) + 1);
                }
            }
        }

        /* Using wordsToDocMap calculate the idf values. */
        for (String word : this.principalWordSet) {
            double idfVal = ((double) appModels.size()) / wordsToDocMap.get(word);
            this.idfMap.put(word, 1 + Math.log(idfVal));
        }
    }

    private void populateAppTFIDF (AppModel app, final int limit)
    {
        Map<String, Double> tfIdfMap = new HashMap<>();
        Map<String, Double> tfMap = app.getTFMap();

        //calculate TFIDF for the app.
        for(String key : tfMap.keySet()) {
            tfIdfMap.put(key, tfMap.get(key) * this.idfMap.get(key));
        }

        //sort tfIdfMap by value and limit the data.
        Map<String, Double> sortedTfIdfMap = tfIdfMap.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(limit)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o1, o2) -> o1, LinkedHashMap::new));

        app.setTFIDFMap(sortedTfIdfMap);
    }

    /**
     Get metadata for an App and create a corresponding AppModel.
     */
    private AppModel processDocMetadataForInput (final String appId) throws TFIDFException
    {
        AppModel app = new AppModel();
        HTTUtils httpUtils = new HTTUtils();
        Gson gson = new Gson();
        String resultForId = null;

        try {
            resultForId = httpUtils.getOnId(appId);
        }
        catch (IOException e) {
            throw new TFIDFException(e.getMessage());
        }

        ResultMetaData metadata = gson.fromJson(resultForId, ResultMetaData.class);
        if (metadata != null && metadata.getResultCount() != null && metadata.getResultCount() > 0) {
            //Get app metadata.
            AppMetaData appMetaData = metadata.getAppMetaDataList().get(0);

            //Get description for the App.
            String description = appMetaData.getDescription();

            //Get TF Map for the App.
            if (description != null) {
                Map<String, Double> tfMap = getTFMap(description);
                app.setTFMap(tfMap);
            }

            app.setAppId(Integer.valueOf(appId));
        }

        return app;
    }

    /*
    Calculates Term-Frequency for a document description.
    tf(term, doc) = n/N => n is number of times term occurs in doc, N is total number of words in doc.
    */
    private Map<String, Double> getTFMap (final String description)
    {
        //Get word list from description.
        String[] wordListFromDescription = description.split("\\W+");

        //Get count map.
        Map<String, Integer> countMap = getCountMap(wordListFromDescription);

        //Generate TF map.
        return generateTFMap(countMap, wordListFromDescription.length);
    }

    private Map<String, Double> generateTFMap (Map<String, Integer> countMap, final Integer totalSize)
    {
        Map<String, Double> result = new HashMap<>();
        for(String key : countMap.keySet()) {
            result.put(key, ((double)countMap.get(key)) / totalSize);
        }

        return result;
    }

    private Map<String, Integer> getCountMap (final String[] words)
    {
        Map<String, Integer> result = new HashMap<>();
        for(String word : words) {
            //update frequency.
            result.put(word, result.getOrDefault(word, 0) + 1);

            //store word.
            this.principalWordSet.add(word);
        }
        return result;
    }



    /**
     AppModel created to hold various attributes for the App.
     Normally this would be a entity object in DB where the ID would be auto-generated.
     */
    class AppModel
    {
        Integer appId = null;
        Map<String, Double> tfMap = null;
        Map<String, Double> tfIdfMap = null;

        AppModel ()
        {
            tfMap = new HashMap<>();
            tfIdfMap = new HashMap<>();
        }

        public void setAppId (int id) {
            this.appId = id;
        }

        public Integer getAppId () {
            return this.appId;
        }

        public void setTFMap (Map<String, Double> map) {
            this.tfMap = map;
        }

        public Map<String, Double> getTFMap () {
            return this.tfMap;
        }

        public void setTFIDFMap (Map<String, Double> map) {
            this.tfIdfMap = map;
        }

        public Map<String, Double> getTFIDFMap () {
            return this.tfIdfMap;
        }
    }

    /**
     Metadata for response from API.
     */
    class ResultMetaData {
        Integer resultCount;
        List<AppMetaData> results;

        public Integer getResultCount ()
        {
            return this.resultCount;
        }

        public List<AppMetaData> getAppMetaDataList ()
        {
            return this.results;
        }
    }

    /**
     Metadata for each app in the API response.
     */
    class AppMetaData {
        Integer trackId;
        String description;

        public String getDescription ()
        {
            return this.description;
        }

        public Integer getTrackId ()
        {
            return this.trackId;
        }
    }

    /**
     Util class for HTTP calls.
     */
    class HTTUtils {
        public String getOnId (final String id) throws IOException
        {
            try {
                String urlString = "https://itunes.apple.com/lookup?id=" + id;
                URL url = new URL(urlString);
                URLConnection urlConnection = url.openConnection();
                InputStream is = urlConnection.getInputStream();

                Scanner s = new Scanner(is).useDelimiter("\\A");
                String result = s.hasNext() ? s.next() : "";
                return result;
            } catch (IOException e) {
                throw e;
            }
        }
    }


    public class TFIDFException extends Exception {
        public TFIDFException (final String errorMessage) {
            super(errorMessage);
        }
    }

    public static void main(String args[] ) throws Exception
    {
        /**
         Please note: Even though hackerrank is giving the input in a string,
         I will not be using this since the requirements state the input is from a file which is sent.
         */

        /**
         Please note: I tried to check if hackerrank can make any simple GET calls and on "Run", i keep on getting:
         "java.net.UnknownHostException: itunes.apple.com"
         Its possible be that hackkerrank has issue with making GET calls which is normally possible outside.
         I tested the below code in an IDE and it works just fine.
         */
        try {
            String urlString = "https://itunes.apple.com/lookup?id=284910350";
            URL url = new URL(urlString);
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();

            Scanner s = new Scanner(is).useDelimiter("\\A");
            String result = s.hasNext() ? s.next() : "";
            System.out.println(result);

            AppRanker appRanker = new AppRanker();
            appRanker.getTFIDFMap(new File("src/main/resources/appIdInput.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
