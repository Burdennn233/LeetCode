package com.burdennn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 257. Binary Tree Paths {@url https://leetcode.com/problems/binary-tree-paths/}
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 *
 */


public class No257 {
    public static void main(String[] args) {
        TreeNode leaf = new TreeNode(5);
        TreeNode left = new TreeNode(2, null, leaf);
        TreeNode right = new TreeNode(3, null, null);
        TreeNode root = new TreeNode(1, left, right);
        System.out.println(new Solution257().binaryTreePaths(root));
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        if (root.left == null && root.right == null) {
            return Collections.singletonList(String.valueOf(root.val));
        }

        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);

        List<String> res = new ArrayList<>();
        if (!left.isEmpty()) {
            res.addAll(left.stream().map(s -> root.val + "->" + s).collect(Collectors.toList()));
        }
        if (!right.isEmpty()) {
            res.addAll(right.stream().map(s -> root.val + "->" + s).collect(Collectors.toList()));
        }

        return res;
    }
}