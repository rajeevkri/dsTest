package com.ds.tree;

import java.util.*;

public class AllElements {


    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        if(root1 != null || root2 != null) {
            Stack<Integer> st1 = new Stack<>();
            Stack<Integer> st2 = new Stack<>();

        }
        return list;
    }

    public List<Integer> getAllElements1(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root1 !=null)
            q.add(root1);
        if(root2 != null)
            q.add(root2);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            list.add(node.val);
            TreeNode left = node.left;
            if(left != null) {
                q.add(left);
            }
            TreeNode right = node.right;
            if(right != null) {
                q.add(right);
            }
        }
        Collections.sort(list);
        return list;
    }
}
