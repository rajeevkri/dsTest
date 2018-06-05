package com.test.hackerrank.tree;

public class Traversals {

	void preOrder(Node root) {
		if (root == null) {
	        return;
	    }
	    System.out.print(root.data + " ");
	    preOrder(root.left);
	    preOrder(root.right);
	}
	
	void postOrder(Node root) {
		if (root == null) {
	        return;
	    }
		postOrder(root.left);
		postOrder(root.right);
	    System.out.print(root.data + " ");
	}
	
	void inOrder(Node root) {
		if (root == null) {
	        return;
	    }
		postOrder(root.left);
	    System.out.print(root.data + " ");
		postOrder(root.right);
	}
}
