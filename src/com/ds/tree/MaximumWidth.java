package com.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidth {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxWidth = 1;
        while (!q.isEmpty()) {
            int count = q.size();
            maxWidth = Math.max(maxWidth, count);
            for(int i=1; i<=count; i++) {
                TreeNode poll = q.poll();
                if(poll.left!= null) {
                    q.add(poll.left);
                }
                if(poll.right != null) {
                    q.add(poll.right);
                }

            }
        }
        return maxWidth;
    }

    public int widthOfBinaryTreeLeetCode(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxWidth = 1;
        while (!q.isEmpty()) {
            int count = q.size();

            boolean isAllNull = true;
            for(int i=1; i<=count; i++) {
                TreeNode poll = q.poll();
                if(poll.left!= null) {
                    isAllNull = false;
                }
                if(poll.right != null) {
                    isAllNull = false;
                }
                q.add(poll.right);
                q.add(poll.left);
            }
            if(isAllNull) break;
            maxWidth = Math.max(maxWidth, count);
        }
        return maxWidth;
    }
}
