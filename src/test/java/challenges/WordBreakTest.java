package challenges;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WordBreakTest {

    @Test
    public void wordBreak() {
        String s = "leetcode";
        List<String> stringList = new ArrayList<String>();
        stringList.add("leet");
        stringList.add("code");
        WordBreak wordBreak = new WordBreak();
        assertTrue(wordBreak.wordBreak(s, stringList));
    }
}
