package com.burdennn;

import org.junit.Before;
import org.junit.Test;

public class TreeNodeUtilTest {

    private TreeNode root;

    @Before
    public void init() {
        TreeNode l3ll = new TreeNode(4);
        TreeNode l3lr = new TreeNode(5);
        TreeNode l3rl = new TreeNode(6);
        TreeNode l3rr = new TreeNode(7);
        TreeNode l2l = new TreeNode(2, l3ll, l3lr);
        TreeNode l2r = new TreeNode(3, l3rl, l3rr);
        root = new TreeNode(1, l2l, l2r);
    }

    @Test
    public void traverse() {
        TreeNodeUtil.preOrderTraverse(root);
        System.out.println();
        TreeNodeUtil.inOrderTraverse(root);
        System.out.println();
        TreeNodeUtil.midOrderTraverse(root);
    }
}
