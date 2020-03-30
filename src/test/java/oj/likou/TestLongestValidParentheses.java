/*
 * Copyright (c) 2010-2020.
 *  Date:20-3-25 下午10:53
 * Author:cooper
 */

package oj.likou;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;

public class TestLongestValidParentheses {

    @Test
    public void test() {
        TestCase.assertEquals(2, longestValidParentheses("()"));
        TestCase.assertEquals(2, longestValidParentheses("(()"));
        TestCase.assertEquals(2, longestValidParentheses("()(()"));
        TestCase.assertEquals(4, longestValidParentheses(")()())"));
        TestCase.assertEquals(6, longestValidParentheses(")(()())"));
        TestCase.assertEquals(6, longestValidParentheses(")(()())"));
        TestCase.assertEquals(590, longestValidParentheses("()()()(()))()()())))((()()()(()()))(()()()((()()))())(((())()())(()(()(()(())(((()())()))(()))()))))()())(()))))()()(())()()((())()()))))((()))))(()()((()(()(()())((())()()()()))()()()(())()()())((((()(())())))(((()(((()((((())())(()()()()(((((()))()(()(())))(((()()()()(()(((())(()(()()(()(()(())()))))))()))()())((()((((()(())(()()()(((((()())()))))())))((((()()()(()(())(((())(((()()((()((()(((()(()))(((())(((()((((()(())(((()((()(()())))))(()(()()(())))))()(()()((()))()))())())((())))()(())((((()((()))))()())()))((()(()())()())()()((()))())(()(()(())((((((()()((((())))())(((()()())))()(((()(()()((((())))))()()((((()(()()())(()(())()()()((()(()((((())))((((((())(()())()))))(()(()))()))))))(()()((()()()())(())))(((()))(()()()(()))((())()()()())()()(((())(()(())()()(()())((()()(((((())(()((((()(()()()(()))(()((((())()())()())())))())(((()(()((())()()((((()()()()))))))())())()(((((()())()(()()()()()(((())((((((()))(())()(()())(()(()())(()(())))())))(()()(()((((()()(())(()))()))(()))(()())())()))))))()()(())))))()))()(()())))((())(()()))()((()))()(())()()((((())()))((()(()))()(((()())()(()()((()())((((())()))))()(())())())())(((()(()())))((()))))()())))))(()((())))()())((()))()()))(())())()))()()((()(((())()()()((()()(()(())(()))())())(((()())(()())(()((()()()())()(()(((((((()()(((()(((((((())(()))))())()))))))))()(()(()((((())(()()(((()))()(())(((((((((()(()())())()(((()((()(((()(()()(()))(())))))))((("));
    }

    public int longestValidParentheses(String s){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else {
                    maxLength = Math.max(i - stack.peek(), maxLength);
                }
            }
        }
        return maxLength;
    }

    public int longestValidParentheses2(String s) {
        if (stringEmpty(s)) {
            return 0;
        }
        int maxLength = 0;
        int stringLengty = s.length();
        for (int i = 0; i < stringLengty; i++) {
            if (s.charAt(i) == ')'){
                continue;
            }
            for (int j = i + 2; j <= stringLengty; j += 2) {
                if (validParenthese(s.substring(i, j))) {
                    maxLength = Math.max(maxLength, j - i);
                }
            }
            if (stringLengty - i < maxLength){
                break;
            }
        }
        return maxLength;
    }

    private boolean validParenthese(String substring) {
        Stack<Character> stack = new Stack<>();
        for (Character c : substring.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean stringEmpty(String s) {
        return null == s || 0 == s.length();
    }

}
