/*
 * Copyright (c) 2010-2020.
 *  Date:20-5-26 下午11:42
 * Author:cooper
 */

package oj.likou;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class FindElementsInAContaminatedBinaryTreeTest {
    @Test
    public void test() {
    }

    class FindElements {
        public FindElements(TreeNode root) {
            buildTree(root, 0);
        }

        Set<Integer> hasValue = new HashSet<>();
        private void buildTree(TreeNode root, int rootVal) {
            root.val = rootVal;
            hasValue.add(rootVal);
            if (root.left != null) {
                buildTree(root.left, 2 * rootVal + 1);
            }
            if (root.right != null) {
                buildTree(root.right, 2 * rootVal + 2);
            }
        }

        public boolean find(int target) {
            return hasValue.contains(target);
        }

    }
}
