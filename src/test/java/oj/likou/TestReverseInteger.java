/*
 * Copyright (c) 2010-2020.
 *  Date:20-3-7 下午11:10
 * Author:cooper
 */

package oj.likou;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestReverseInteger {

    @Test
    public void test() {
        TestCase.assertEquals(-321, reverse(-123));
        TestCase.assertEquals(123, reverse(321));
        TestCase.assertEquals(21, reverse(120));
    }

    int reverse(int x) {
        int reverse = 0;
        int newRev = 0;
        while (x != 0) {
            newRev = newRev * 10 + x % 10;
            if ((newRev - x % 10) / 10 != reverse) {
                return 0;
            } else {
                reverse = newRev;
            }
            x = x / 10;
        }

        return reverse;
    }
}
