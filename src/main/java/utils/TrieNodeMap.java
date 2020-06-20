package utils;

import java.util.HashMap;

public class TrieNodeMap {
    HashMap<Character, TrieNodeMap> valsMap = new HashMap<>();
    boolean end;

    public HashMap<Character, TrieNodeMap> getValsMap() {
        return valsMap;
    }

    public void setValsMap(HashMap<Character, TrieNodeMap> valsMap) {
        this.valsMap = valsMap;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}
