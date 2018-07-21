package com.test.hackerrank.tree;

public class BST {
	boolean checkBST(Node root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(Node root, int minValue, int maxValue) {
		if(root == null) {
			return true;
		}
		
		if(root.data <= minValue || root.data> maxValue) {
			return false;
		}
		
		return isBST(root.left, minValue, root.data) && isBST(root.right, root.data, maxValue);
	}
}
