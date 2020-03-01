package oj.likou;


import junit.framework.TestCase;
import org.junit.Test;

public class TestPalindromNum {

    @Test
    public void test() {
        TestCase.assertTrue(isPalindrome(1001));
        TestCase.assertTrue(isPalindrome(121));
    }

    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        String string1 = String.valueOf(x);
        String string2 = (new StringBuilder(string1)).reverse().toString();
        return string1.equals(string2);
    }
}
