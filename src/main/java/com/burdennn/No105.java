package com.burdennn;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal {@url https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/}
 *
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
 * and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 */


public class No105 {
    public static void main(String[] args) {
        TreeNode root = new Solution105().buildTree(new int[]{3,9,20,15,7}, new int[] {9,3,15,20,7});
        TreeNodeUtil.preOrderTraverse(root);
    }
}

class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inmap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int rootOfInOrder = inmap.get(root.val);

        root.left = buildTree(preorder, preStart + 1, preStart + rootOfInOrder - inStart, inorder, inStart, rootOfInOrder - 1, inmap);
        root.right = buildTree(preorder, preStart + rootOfInOrder - inStart + 1, preEnd, inorder, rootOfInOrder + 1, inEnd, inmap);

        return root;
    }


}
