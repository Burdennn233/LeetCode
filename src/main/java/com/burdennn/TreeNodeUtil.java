package com.burdennn;

public final class TreeNodeUtil {

    public static void preOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + ", ");
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    public static void inOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraverse(root.left);
        inOrderTraverse(root.right);
        System.out.print(root.val + ", ");
    }

    public static void midOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        midOrderTraverse(root.left);
        System.out.print(root.val + ", ");
        midOrderTraverse(root.right);
    }

    private TreeNodeUtil() {
    }
}
