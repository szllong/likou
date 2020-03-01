package oj.likou;

import junit.framework.TestCase;
import org.junit.Test;

public class TestImplementstrStr {

    @Test
    public void test(){
        TestCase.assertEquals(2, strStr("hello", "ll"));
        TestCase.assertEquals(-1, strStr("aaaaa", "ba"));
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
