package oj.likou;

import com.sun.deploy.util.StringUtils;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestLongestSubStringWithoutRepeatingCharacters {

    @Test
    public void test() {
        TestCase.assertEquals(5, lengthOfLongestSubstring("abcabcde"));
        TestCase.assertEquals(5, lengthOfLongestSubstring2("abcabcde"));
        TestCase.assertEquals(1, lengthOfLongestSubstring2("aaa"));
        TestCase.assertEquals(2, lengthOfLongestSubstring2("abbbbc"));
        TestCase.assertEquals(0, lengthOfLongestSubstring2(""));
        TestCase.assertEquals(0, lengthOfLongestSubstring2(null));
    }

    public int lengthOfLongestSubstring(String s) {
        if (null == s || 0 == s.length()) {
            return 0;
        }

        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (null == s || s.isEmpty()){
            return 0;
        }
        int l = 0, r = 0, maxLength = 0;
        char[] arr = new char[256];

        while (l < s.length() && r < s.length()) {
            if (arr[s.charAt(r)] == 0) {
                maxLength = Math.max(maxLength, r - l + 1);
                arr[s.charAt(r)]++;
                r++;
            } else {
                arr[s.charAt(l)]--;
                l++;
            }
        }
        return maxLength;
    }
}
