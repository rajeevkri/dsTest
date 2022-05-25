package com.ds.tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nodes = new ArrayList<>();
        inOrderBST(root, nodes);
        return nodes.get(k-1);
    }
    private void inOrderBST(TreeNode root, List<Integer> nodes) {
        if(root.left!= null) {
            inOrderBST(root.left, nodes);
        }
        nodes.add(root.val);
        if(root.right!= null) {
            inOrderBST(root.right, nodes);
        }
    }
}
