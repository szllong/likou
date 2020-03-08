package oj.likou;


import com.sun.org.apache.regexp.internal.RE;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestPalindromNum {

    @Test
    public void test() {
        TestCase.assertTrue(isPalindrome(1001));
        TestCase.assertTrue(isPalindrome(121));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String string1 = String.valueOf(x);
        String string2 = (new StringBuilder(string1)).reverse().toString();
        return string1.equals(string2);
    }

    @Test
    public void testPalindromeNum() {
        TestCase.assertTrue(isPalindromeNum(1001));
        TestCase.assertTrue(isPalindromeNum(121));
    }

    public boolean isPalindromeNum(int x) {
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        int length = String.valueOf(x).length();
        int halfLen = length / 2;
        int preHalf = 0;
        int postHalf = 0;
        while (halfLen > 0) {
            postHalf = postHalf * 10 + x % 10;
            x = x / 10;
            halfLen--;
        }
        if (length % 2 == 0) {
            preHalf = x;
        } else {
            preHalf = x / 10;
        }

        return preHalf == postHalf;
    }
}
