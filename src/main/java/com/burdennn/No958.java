package com.burdennn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 958. Check Completeness of a Binary Tree {@url https://leetcode.com/problems/check-completeness-of-a-binary-tree/}
 * <p>
 * Given a binary tree, determine if it is a complete binary tree.
 * <p>
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [1,2,3,4,5,6]
 * Output: true
 * Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: [1,2,3,4,5,null,7]
 * Output: false
 * Explanation: The node with value 7 isn't as far left as possible.
 */


public class No958 {
    public static void main(String[] args) {
        TreeNode leaf1 = new TreeNode(4);
        TreeNode leaf2 = new TreeNode(5);
        TreeNode leaf3 = new TreeNode(7);
        TreeNode subC1 = new TreeNode(2, leaf1, leaf2);
        TreeNode subC2 = new TreeNode(3, null, leaf3);
        TreeNode root = new TreeNode(1, subC1, subC2);
        System.out.println(new Solution958().isCompleteTree(root));
    }
}

class Solution958 {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);
        while (bfs.peek() != null) {
            TreeNode node = bfs.poll();
            bfs.offer(node.left);
            bfs.offer(node.right);
        }
        while (!bfs.isEmpty() && bfs.peek() == null) {
            bfs.poll();
        }
        return bfs.isEmpty();
    }
}