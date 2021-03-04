package com.burdennn;

/**
 * 99. Recover Binary Search Tree {@url https://leetcode.com/problems/recover-binary-search-tree/}
 *
 * You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
 *
 * Follow up: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 *
 */


public class No99 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(4, new TreeNode(2), null));
        new Solution90().recoverTree(root);
        TreeNodeUtil.midOrderTraverse(root);
    }
}

class Solution90 {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        traverse(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);

        if (first == null && root.val < preNode.val) {
            first = preNode;
        }

        if (first != null && root.val < preNode.val) {
            second = root;
        }

        preNode = root;

        traverse(root.right);
    }
}
