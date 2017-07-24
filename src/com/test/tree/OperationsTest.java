package com.test.tree;

import org.junit.Test;

public class OperationsTest {
	TreeOperations operations = new TreeOperations();

	@Test
	public void testLevelOrderTraversal() {
		Node root = Node.createTestTree();
		operations.levelOrderTraversal(root);
	}

	@Test
	public void testMaxDepth() {
		Node root = Node.createTestTree();
		System.out.println(operations.maxdepth(root));
	}
}
