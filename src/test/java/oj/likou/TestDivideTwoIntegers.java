/*
 * Copyright (c) 2010-2020.
 *  Date:20-3-17 下午11:29
 * Author:cooper
 */

package oj.likou;

import junit.framework.TestCase;
import org.junit.Test;

public class TestDivideTwoIntegers {

    @Test
    public void testDivide() {
        TestCase.assertEquals(3, divide(10, 3));
        TestCase.assertEquals(1, divide(3, 3));
        TestCase.assertEquals(0, divide(0, 3));
        TestCase.assertEquals(0, divide(1, 2));
        TestCase.assertEquals(2147483647, divide(-2147483648, -1));
        TestCase.assertEquals(2147483647, divide(2147483647, 1));


        TestCase.assertEquals(-1073741824, divide(-2147483648, 2));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        if (dividend == Integer.MAX_VALUE && divisor == 1) return Integer.MAX_VALUE;
        if (dividend == Integer.MAX_VALUE && divisor == -1) return -Integer.MAX_VALUE;
        int absDisvisor = -Math.abs(divisor);
        int absDividend = -Math.abs(dividend);
        int i = 0;
        int addNum = 0;
        while (addNum >= absDividend) {
            if (absDividend - absDisvisor <= addNum) {
                addNum += absDisvisor;
                i++;
            } else {
                break;
            }
        }

        if ((absDisvisor == divisor && absDividend == dividend) || (absDisvisor != divisor && absDividend != dividend)) {
            return i;
        } else {
            return -i;
        }
    }
}
