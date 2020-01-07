package challenges;

public class HighScoringWord {
    public static String high(String s) {
        s = s.toLowerCase();
        int highScore = 0;
        String result = "";
        String[] splits = s.split(" ");
        for (String str : splits) {
            int score = getScore(str);
            if (score > highScore) {
                result = str;
                highScore = score;
            }
        }
        return result;
    }

    public static Integer getScore(String string) {
        int score = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            score = score + (c - 'a' + 1);
        }
        return score;
    }

    public static void main(String[] args) {
        high("dmrkbtfhiefqc zjjoiwi oc v gqal kthmsfnlr d d ovywb mxtw rvt pwh fkbn");
    }

}
