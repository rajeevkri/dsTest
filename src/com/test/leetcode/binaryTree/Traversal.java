package com.test.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversal {
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> arr = new ArrayList<>();
		Stack<TreeNode> st = new Stack<>();
		st.push(root);
		while(!st.isEmpty()) {
			TreeNode pop = st.peek();
			if (pop.left != null) {
                st.push(pop.left);
                continue;
            }
			st.pop();
            arr.add(pop.val);
            if (pop.right != null) {
                st.push(pop.right);
            }
		}
		return arr;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		System.out.println(inorderTraversal(root));
	}
}
