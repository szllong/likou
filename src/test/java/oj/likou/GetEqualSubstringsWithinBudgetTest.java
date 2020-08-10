/*
 * Copyright (c) 2010-2020.
 *  Date:20-4-21 下午11:48
 * Author:cooper
 */

package oj.likou;

import junit.framework.TestCase;
import org.junit.Test;

public class GetEqualSubstringsWithinBudgetTest {
    @Test
    public void test() {
        TestCase.assertEquals(3, equalSubstring("abcd", "bcdf", 3));
        TestCase.assertEquals(1, equalSubstring("abcd", "cdef", 3));
        TestCase.assertEquals(1, equalSubstring("abcd", "acde", 0));
    }

    public int equalSubstring(String s, String t, int maxCost) {
        if (null == s || null == t || 0 == s.length() || s.length() != t.length()) {
            return 0;
        }

        int start = 0;
        int end = 0;
        int maxLen = 0;
        int currentCost = 0;
        while (end < s.length()) {
            if (Math.abs(s.charAt(end) - t.charAt(end)) + currentCost <= maxCost) {
                currentCost += Math.abs(s.charAt(end) - t.charAt(end));
                end++;
            } else {
                currentCost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }

            if (end - start > maxLen) {
                maxLen = end - start;
            }
        }
        return maxLen;
    }
}
