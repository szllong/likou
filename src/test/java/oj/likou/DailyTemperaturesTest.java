/*
 * Copyright (c) 2010-2020.
 *  Date:20-4-20 下午11:05
 * Author:cooper
 */

package oj.likou;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

public class DailyTemperaturesTest {

    @Test
    public void test() {
        TestCase.assertTrue(Arrays.equals(new int[]{1, 1, 4, 2, 1, 1, 0, 0}, dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    public int[] dailyTemperatures(int[] T) {
        if (null == T || 0 == T.length){
            return new int[]{0};
        }

        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]){
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }
}
