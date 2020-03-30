/*
 * Copyright (c) 2010-2020.
 *  Date:20-3-30 下午11:44
 * Author:cooper
 */

package oj.likou;

import org.junit.Test;

public class TestConstructBinaryTreefromPreorderandInorderTraversal {

    @Test
    public void test() {
        TreeNode node = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(node);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || null == inorder || preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        TreeNode rootNode = new TreeNode(preorder[0]);
        rootNode.left = getLeftTree(preorder, inorder);
        rootNode.right = getRightTree(preorder, inorder);
        return rootNode;
    }

    private TreeNode getRightTree(int[] preorder, int[] inorder) {
        if (null == preorder || preorder.length == 1){
            return null;
        }

        int rootIndexInInorder = getRootIndexInInorder(preorder[0], inorder);

        int[] rightPreorder = new int[preorder.length - rootIndexInInorder - 1];
        fillRightPreOrder(rightPreorder, preorder);

        int[] rightInorder = new int[preorder.length - rootIndexInInorder - 1];
        fillRightInOrder(rightInorder, inorder);
        return buildTree(rightPreorder, rightInorder);
    }

    private void fillRightInOrder(int[] rightInorder, int[] inorder) {
        for (int i = rightInorder.length - 1, j = inorder.length - 1; i >= 0; i--, j--) {
            rightInorder[i] = inorder[j];
        }
    }

    private void fillRightPreOrder(int[] rightPreorder, int[] preorder) {
        for (int i = rightPreorder.length - 1, j = preorder.length - 1; i >= 0; i--, j--) {
            rightPreorder[i] = preorder[j];
        }
    }

    private TreeNode getLeftTree(int[] preorder, int[] inorder) {
        if (null == preorder || preorder.length == 1){
            return null;
        }

        int rootIndexInInorder = getRootIndexInInorder(preorder[0], inorder);

        int[] leftPreorder = new int[rootIndexInInorder];
        fillLeftPreorder(leftPreorder, preorder);

        int leftInorder[] = new int[rootIndexInInorder];
        fillLeftInorder(leftInorder, inorder);
        return buildTree(leftPreorder, leftInorder);
    }

    private void fillLeftInorder(int[] leftInorder, int[] inorder) {
        System.arraycopy(inorder, 0, leftInorder, 0, leftInorder.length);
    }

    private void fillLeftPreorder(int[] leftPreorder, int[] preorder) {
        System.arraycopy(preorder, 1, leftPreorder, 0, leftPreorder.length);
    }

    private int getRootIndexInInorder(int rootVal, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                return i;
            }
        }
        return -1;
    }
}
