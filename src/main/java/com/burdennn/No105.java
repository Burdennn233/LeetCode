//package com.burdennn;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 105. Construct Binary Tree from Preorder and Inorder Traversal {@url https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/}
// *
// * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
// * and inorder is the inorder traversal of the same tree, construct and return the binary tree.
// *
// */
//
//
//public class No105 {
//    public static void main(String[] args) {
//
//    }
//}
//
//class Solution105 {
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        Map<Integer, Integer> inMap = new HashMap<>();
//        for (int i = 0; i < inorder.length; i++) {
//            inMap.put(inorder[i], i);
//        }
//        return buildTree(preorder, 0, inorder, 0, inorder.length - 1, inMap);
//    }
//
//    public TreeNode buildTree(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inmap) {
//        if () {
//            return null;
//        }
//
//        TreeNode root = new TreeNode(preorder[preStart]);
//
//        int rootOfInOrder = inmap.get(root.val);
//
//        root.left = buildTree(preorder, preStart + 1, inorder, rootOfInOrder, inEnd, inmap);
//        root.right = buildTree(preorder, )
//    }
//
//
//}
