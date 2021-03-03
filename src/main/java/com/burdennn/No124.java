package com.burdennn;

import sun.reflect.generics.tree.Tree;

/**
 * 124. Binary Tree Maximum Path Sum {@url https://leetcode.com/problems/binary-tree-maximum-path-sum/}
 *
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any path.
 *
 */


public class No124 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(9);
        TreeNode right1 = new TreeNode(15);
        TreeNode right2 = new TreeNode(7);
        TreeNode right = new TreeNode(20, right1, right2);
        TreeNode root = new TreeNode(-10, left, right);
        System.out.println(new Solution124().maxPathSum(root));
    }
}

class Solution124 {
    private int num = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumDiv(root);
        return num;
    }


    public int maxPathSumDiv(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, maxPathSumDiv(root.left));
        int right = Math.max(0, maxPathSumDiv(root.right));


        num = Math.max(num, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
