package com.ds.tree;

public class MaximumDepth {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        if(lDepth > rDepth) {
            return lDepth+1;
        } else {
            return rDepth+1;
        }

    }
}
