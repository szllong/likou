/*
 * Copyright (c) cooper  2020.
 */

package oj.likou;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CountAndSayTest {

    @Test
    public void test() {
        TestCase.assertEquals("312211", countAndSay(6));
    }

    public String countAndSay(int n) {
        List<String> says = new ArrayList<>();
        says.add("1");
        says.add("11");
        says.add("21");
        says.add("1211");
        says.add("111221");
        if (n <= 5) {
            return says.get(n - 1);
        }

        return getSay(says.get(4), n - 5);
    }

    private String getSay(String say, int n) {
        if (n == 0) {
            return say;
        }

        int sameCharNum = 0;
        char valueChar;
        StringBuilder nextSay = new StringBuilder();
        for (int i = 0; i < say.length(); i++) {
            int j = i + 1;
            valueChar = say.charAt(i);
            if (j < say.length() && say.charAt(i) == say.charAt(j)) {
                sameCharNum++;
            } else {
                nextSay.append(String.valueOf(sameCharNum + 1)).append(valueChar);
                sameCharNum = 0;
            }
        }

        return getSay(nextSay.toString(), n - 1);
    }
}
