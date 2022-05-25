package com.ds.tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderBinarySearch {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        inOrderBST(root, nodes);
        TreeNode head = new TreeNode();
        TreeNode temp = head;
        for(Integer i: nodes) {
            TreeNode t = new TreeNode();
            t.val = i;
            temp.right = t;
            temp = temp.right;
        }
        return head.right;
    }

    private void inOrderBST(TreeNode root, List<Integer> nodes) {
        if(root.left!= null) {
            inOrderBST(root.left, nodes);
        }
        nodes.add(root.val);
        if(root.right!= null) {
            inOrderBST(root.right, nodes);
        }
//        nodes.add(root.val);
    }

    public static void main(String[] args) {
        IncreasingOrderBinarySearch increasingOrderBinarySearch = new IncreasingOrderBinarySearch();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        TreeNode res = increasingOrderBinarySearch.increasingBST(root);
        while (res != null) {
            System.out.println(res.val);
            res = res.right;
        }
    }
}
