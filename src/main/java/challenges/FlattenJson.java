package challenges;

import java.util.HashMap;
import java.util.Map;

public class FlattenJson {
     public Map<String, String> getFlattenedJson(Map<String, Object> inputMap) {
        Map<String, String> resultMap = new HashMap<String, String>();
        if (inputMap == null || inputMap.size() == 0) {
            return resultMap;
        }

        for (Map.Entry<String, Object> entry : inputMap.entrySet()) {
            if (entry.getValue() instanceof String) {
                resultMap.put(entry.getKey(), (String) entry.getValue());
            } else {
                flattenJsonRecursive(inputMap, resultMap, entry.getKey(), entry.getValue());
            }
        }
        return resultMap;
    }

    private void flattenJsonRecursive(Map<String, Object> inputMap, Map<String, String> resultMap, String key, Object value) {
        if (value instanceof String) {
            resultMap.put(key, (String) value);
            return;
        } else {
            for (Map.Entry<String, Object> entry : inputMap.entrySet()) {
                flattenJsonRecursive(inputMap, resultMap, key + "." + entry.getKey(), entry.getValue());
            }
        }
    }
}
