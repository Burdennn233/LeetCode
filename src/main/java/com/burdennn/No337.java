package com.burdennn;

/**
 * 337. House Robber III {@url https://leetcode.com/problems/house-robber-iii/}
 * <p>
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * <p>
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3,null,3,null,1]
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 * <p>
 * Input: [3,4,5,1,3,null,1]
 * <p>
 * 3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * <p>
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 */


public class No337 {
    public static void main(String[] args) {
        TreeNode leaf1 = new TreeNode(1);
        TreeNode leaf2 = new TreeNode(3);
        TreeNode leaf3 = new TreeNode(1);
        TreeNode left = new TreeNode(4, leaf1, leaf2);
        TreeNode right = new TreeNode(5, null, leaf3);
        TreeNode root = new TreeNode(3, left, right);
        System.out.println(new Solution337().rob(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution337 {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int tmp = root.val;
        if (root.left != null) {
            tmp += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            tmp += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(tmp , rob(root.left) + rob(root.right));
    }
}
