/*
 * Copyright (c) 2010-2020.
 *  Date:20-5-6 下午11:22
 * Author:cooper
 */

package oj.likou;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceWordTest {
    @Test
    public void test() {
        TestCase.assertEquals("the cat was rat by the bat", replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
    }

    public String replaceWords(List<String> roots, String sentence) {
        TrieNode trie = new TrieNode();
        for (String root : roots) {
            TrieNode cur = trie;
            for (char letter : root.toCharArray()) {
                if (!cur.children.containsKey(letter)) {
                    cur.children.put(letter, new TrieNode());
                }
                cur = cur.children.get(letter);
            }
            cur.word = root;
        }

        StringBuilder ans = new StringBuilder();

        for (String word : sentence.split("\\s+")) {
            if (ans.length() > 0)
                ans.append(" ");

            TrieNode cur = trie;
            for (char letter : word.toCharArray()) {
                if (!cur.children.containsKey(letter) || !cur.word.isEmpty())
                    break;
                cur = cur.children.get(letter);
            }
            ans.append(!cur.word.isEmpty() ? cur.word : word);
        }
        return ans.toString();
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = "";
    }

}


