package oj.likou;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;

public class TestSubstringwithConcatenationofAllWords {
    @Test
    public void test() {
        TestCase.assertEquals(new ArrayList<>(Collections.singletonList(8)), findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));

        TestCase.assertEquals(new ArrayList<>(Arrays.asList(0, 9)), findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        TestCase.assertEquals(new ArrayList<>(), findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
        TestCase.assertEquals(new ArrayList<>(), findSubstring("a", new String[]{}));
    }


    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return new ArrayList<>();
        }
        Map<String, Integer> wordsMap = new HashMap<>();
        Map<String, Integer> stringMap = new HashMap<>();
        initWordsMap(wordsMap, words);
        int wordLength = words[0].length();
        int wordCount = words.length;
        int wordTotalLength = wordLength * wordCount;
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i <= s.length() - wordTotalLength; i++) {
            initStringMap(s.substring(i, i + wordTotalLength), stringMap, wordLength);
            if (mapEqual(wordsMap, stringMap)) {
                resultList.add(i);
            }
        }
        return resultList;
    }

    private boolean mapEqual(Map<String, Integer> wordsMap, Map<String, Integer> stringMap) {
        if (wordsMap.size() != stringMap.size()) {
            return false;
        }
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            if (!entry.getValue().equals(stringMap.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    private void initStringMap(String substring, Map<String, Integer> stringMap, int wordLength) {
        stringMap.clear();
        for (int i = 0; i < substring.length(); i += wordLength) {
            String word = substring.substring(i, i + wordLength);
            stringMap.compute(word, (key, value) -> {
                if (null == value) {
                    return 1;
                } else {
                    return value + 1;
                }
            });
        }
    }

    private void initWordsMap(Map<String, Integer> wordsMap, String[] words) {
        for (String word : words) {
            wordsMap.compute(word, (key, value) -> {
                if (null == value) {
                    return 1;
                } else {
                    return value + 1;
                }
            });
        }
    }
}
