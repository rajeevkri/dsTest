package com.test.hackerrank.tree;

import java.util.ArrayList;
import java.util.Scanner;

public class TreeOperations {

	static Node lca(Node root, int v1, int v2) {

		if (root.data < v1 && root.data < v2) {
			return lca(root.right, v1, v2);
		} else if (root.data > v1 && root.data > v2) {
			return lca(root.left, v1, v2);
		} else {
			return root;
		}
	}

	Node lca(Node root, Node v1, Node v2) {
		if (root == null) {
			return root;
		}
		if (root == v1 || root == v2) {
			return root;
		}
		Node left = lca(root.left, v1, v2);
		Node right = lca(root.right, v1, v2);
		if (left != null && right != null) {
			return root;
		}
		if (left == null && right == null) {
			return null;
		}
		return left != null ? left : right;
	}

	// Insert Into BST
	public static Node insert(Node root, int data) {
		Node newNode = new Node(data);
		if (root == null) {
			root = newNode;
		}
		Node currentNode = root, parentNode = null;
		while (currentNode != null) {
			parentNode = currentNode;
			if (data == currentNode.data) {
				break;
			} else if (data <= currentNode.data) {
				currentNode = currentNode.left;
			} else {
				currentNode = currentNode.right;
			}
		}
		if (currentNode == null) {
			if (data <= parentNode.data) {
				parentNode.left = newNode;
			} else {
				parentNode.right = newNode;
			}

		}
		return root;
	}

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		pathSumRe(A, B, res, path);
		return res;
	}

	public void pathSumRe(TreeNode root, int sum, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path) {

		if (root == null)
			return;

		path.add(root.val);

		if (root.left == null && root.right == null && root.val == sum) {

			ArrayList<Integer> tmp = new ArrayList<Integer>(path);
			res.add(tmp);
		}

		pathSumRe(root.left, sum - root.val, res, path);
		pathSumRe(root.right, sum - root.val, res, path);
		path.remove(path.size() - 1);
	}

	public boolean isLeafNode(TreeNode node) {
		if (node.left == null && node.right == null) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// Scanner scan = new Scanner(System.in);
		// int t = scan.nextInt();
		// Node root = null;
		// while (t-- > 0) {
		// int data = scan.nextInt();
		// root = insert(root, data);
		// }
		// scan.close();
		// preOrder(root);
		Node root = Node.createTestTree();
		preOrder(root);
		System.out.println();
		System.out.println(heightOfBinaryTree(root));
	}

	public static void preOrder(Node root) {

		if (root == null)
			return;

		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);

	}

	public static boolean sameTreeRecusive(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if ((root1 != null && root2 == null) || (root1 == null && root2 != null)) {
			return false;
		}

		return (root1.data == root2.data) && sameTreeRecusive(root1.left, root2.left)
				&& sameTreeRecusive(root1.right, root2.right);
	}

	public static int sizeBinaryTree(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + sizeBinaryTree(root.left) + sizeBinaryTree(root.right);
	}

	public static int heightOfBinaryTree(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right));
	}
}
