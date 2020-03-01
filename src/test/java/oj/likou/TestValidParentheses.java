package oj.likou;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;

public class TestValidParentheses {

    @Test
    public void testValidParentheses() {
        TestCase.assertTrue(isValid("()[]{}"));
        TestCase.assertTrue(isValid("()"));
        TestCase.assertFalse(isValid("(]"));
        TestCase.assertFalse(isValid("){"));
        TestCase.assertFalse(isValid("([)]"));
        TestCase.assertFalse(isValid("({[]}"));
        TestCase.assertTrue(isValid("{[]}"));
    }

    public boolean isValid(String s) {

        if (null == s || s.length() % 2 == 1){
            return false;
        }

        if (s.isEmpty()){
            return true;
        }

        Map<String, String> stringMap = new HashMap<>();
        stringMap.put(")", "(");
        stringMap.put("}", "{");
        stringMap.put("]", "[");

        if (stringMap.containsKey(s.substring(0, 1))){
            return false;
        }

        Stack<String> stacks = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String iString = s.substring(i, i + 1);

            if (stringMap.containsValue(iString)) {
                stacks.push(iString);
            } else if (stringMap.get(iString).equals(stacks.peek())) {
                stacks.pop();
            } else {
                return false;
            }
        }
        return stacks.isEmpty();
    }


}
