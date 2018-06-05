package com.test.hackerrank.tree;

public class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
	}

	public static Node createTestTree() {
		Node root = new Node(3);
		root.left = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		root.right = new Node(2);
		root.right.left = new Node(6);
		return root;
	}

	public static Node createTestBST() {
		Node root = new Node(4);
		root.left = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right = new Node(7);
		return root;
	}
}
