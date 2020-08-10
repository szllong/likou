/*
 * Copyright (c) 2010-2020.
 *  Date:20-3-31 下午11:07
 * Author:cooper
 */

package oj.likou;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestConstructBinaryTreefromPreorderandInorderTraversal2 {

    @Test
    public void test() {
    }


    private Map<Integer, Integer> inorderValueVsIndex = new HashMap<>();
    private int[] preorder;
    private int rootIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || null == inorder || preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }

        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            inorderValueVsIndex.put(inorder[i], i);
        }

        return buildHelper(0, inorder.length);
    }

    private TreeNode buildHelper(int left, int right) {
        if (left == right) {
            return null;
        }
        int rootValue = this.preorder[rootIndex];
        rootIndex += 1;
        TreeNode root = new TreeNode(rootValue);
        root.left = buildHelper(left, inorderValueVsIndex.get(rootValue));
        root.right = buildHelper(inorderValueVsIndex.get(rootValue) + 1, right);
        return root;
    }
}
