package com.test.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class TreeOperations {
	public void levelOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.print(node.data + " ");
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
	}

	public Node insertNodeBST(Node root, int data) {
		Node node = new Node(data);
		if (root == null) {
			return node;
		}
		Node currentNode = root, parent = null;
		while (currentNode != null) {
			parent = currentNode;
			if (currentNode.data <= data) {
				currentNode = currentNode.right;
			} else {
				currentNode = currentNode.left;
			}
		}
		if (parent.data <= data) {
			parent.right = node;
		} else {
			parent.left = node;
		}

		return root;
	}

	static long teamFormation(int[] score, int team, int m) {
		int size = score.length;
		int i = 1;
		int sum = 0;
		ArrayList<Integer> intList = new ArrayList<>();
		for (int index = 0; index < size; index++) {
			intList.add(score[index]);
		}
		while (i <= team) {
			if (m > size) {
				int fromIndex = 0;
				int toIndex = m;
				int largestElementIndFromStart = findLargestElementIndInArray(intList, fromIndex, toIndex);
				fromIndex = size - m - 1;
				toIndex = size - 1;
				int largestElementIndFromEnd = findLargestElementIndInArray(intList, fromIndex, toIndex);
				int largestElementFromStart = intList.get(largestElementIndFromStart);
				int largestElementFromEnd = intList.get(largestElementIndFromEnd);
				int ElementToChoose = largestElementFromStart > largestElementFromEnd ? largestElementFromStart
						: largestElementFromEnd;
				int indexToChoose = largestElementFromStart > largestElementFromEnd ? largestElementIndFromStart
						: largestElementIndFromEnd;
				Integer remove = intList.remove(indexToChoose);
				sum = sum + remove;
			} else {
				int fromIndex = 0;
				int toIndex = intList.size() - 1;
				int largestElementIndFromStart = findLargestElementIndInArray(intList, fromIndex, toIndex);
				Integer remove = intList.remove(largestElementIndFromStart);
				sum = sum + remove;
			}

		}
		return sum;
	}

	private static int findLargestElementIndInArray(ArrayList<Integer> arr, int fromIndex, int toIndex) {
		int large = arr.get(fromIndex);

		int index = fromIndex;
		for (int i = fromIndex; i < toIndex; i++) {
			if (large < arr.get(i)) {
				large = arr.get(i);
				index = i;
			}

		}
		return index;
	}

	public static int countNumberOfBinaryTreeByGivenPreOrderLength(int n) {
		if (n == 0) {
			return 0;
		}
		int T[] = new int[n + 1];
		T[0] = 1;
		T[1] = 1;

		for (int i = 2; i <= n; i++) {
			int sum = 0;
			for (int k = i; k < i; k++) {
				sum += T[k] * T[i - k + 1];
			}
			T[i] = sum;
		}
		return T[n];
	}

	// private static final int MAX = 100000;
	static void printpairs(int arr[], int sum) {
		// Declares and initializes the whole array as false
		// boolean[] binmap = new boolean[MAX];
		Map<Integer, Boolean> bMap = new HashMap<>();

		for (int i = 0; i < arr.length; ++i) {
			int temp = sum - arr[i];

			// checking for condition
			if (temp >= 0 && (bMap.get(temp) != null && bMap.get(temp))) {
				System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", " + temp + ")");
			}
			bMap.put(arr[i], true);
		}
	}

	public static void main(String[] args) {
		// int A[] = { 1, 6, 10, 8, 4, 45, 2, 14};
		int A[] = { 6, 6, 3, 9, 3, 5, 1 };
		int n = 12;
		System.out.println(numberOfPairs(A, n));
		;
	}

	void spiralPrintingUsingTwoStack(Node root) {
		if (root == null)
			return;
		Stack<Node> stack1 = new Stack<>();
		Stack<Character> stack3 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();

		stack1.push(root);
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				root = stack1.pop();
				System.out.println(root.data + " ");
				if (root.left != null) {
					stack2.push(root.left);
				}
				if (root.right != null) {
					stack2.push(root.right);
				}
			}
			while (!stack2.isEmpty()) {
				root = stack1.pop();
				System.out.println(root.data + " ");
				if (root.left != null) {
					stack1.push(root.left);
				}
				if (root.right != null) {
					stack1.push(root.right);
				}
			}
		}
	}

	int getCountNumberOfBinaryWithoutConsecutive1s(int n) {
		int a[] = new int[n];
		int b[] = new int[n];
		a[0] = 1;
		b[0] = 1;

		for (int i = 1; i < n; i++) {
			a[i] = a[i - 1] + b[i - 1];
			b[i] = a[i - 1];
		}
		return a[n - 1] + b[n - 1];
	}

	static boolean isMatchingPair(char character1, char character2) {
		if (character1 == '(' && character2 == ')')
			return true;
		else if (character1 == '{' && character2 == '}')
			return true;
		else if (character1 == '[' && character2 == ']')
			return true;
		else
			return false;
	}

	static boolean areParenthesisBalanced(char exp[]) {
		Stack<Character> st = new Stack<>();

		for (int i = 0; i < exp.length; i++) {

			if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[')
				st.push(exp[i]);

			if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']') {

				if (st.isEmpty()) {
					return false;
				}

				else if (!isMatchingPair(st.pop(), exp[i])) {
					return false;
				}
			}

		}

		if (st.isEmpty())
			return true; /* balanced */
		else { /* not balanced */
			return false;
		}
	}

	static int numberOfPairs(int[] a, long k) {

		Map<Long, Boolean> bMap = new HashMap<>();
		int count = 0;
		for (int i = 0; i < a.length; ++i) {
			long curr = (long) a[i];
			long temp = k - (long) a[i];
			if (temp >= 0 && (bMap.get(temp) != null && bMap.get(temp)) && (temp == curr || bMap.get(curr) == null)) {
				count++;
			}
			bMap.put((long) a[i], true);
		}
		return count;
	}

	/**
	 * Code to find node in BST
	 * 
	 * @param root
	 * @param val
	 * @return
	 */
	public static int isPresent(Node root, int val) {

		boolean found = search(root, val);
		if (found)
			return 1;
		else
			return 0;
	}

	static boolean search(Node r, int val) {
		boolean found = false;
		while ((r != null) && !found) {
			int rval = r.data;
			if (val < rval)
				r = r.left;
			else if (val > rval)
				r = r.right;
			else {
				found = true;
				break;
			}
			found = search(r, val);
		}
		return found;
	}

	/**
	 * increment any duplicate number to make all array element unique such that sum in minimum
	 * @param arr
	 * @return
	 */
	static int getMinimumUniqueSum(int[] arr) {
		int sum = 0;
		List<Integer> duplicateElements = new ArrayList<Integer>();
		Map<Integer, Boolean> uniqueElementsMap = new HashMap<Integer, Boolean>();
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			int k = arr[i];
			Boolean exists = uniqueElementsMap.get(k);
			if (exists == null) {
				uniqueElementsMap.put(k, Boolean.TRUE);
				sum = sum + k;
			} else {
				duplicateElements.add(k);
			}
		}

		for (Integer i : duplicateElements) {
			int k = i;
			while (uniqueElementsMap.get(++k) != null) {
				continue;
			}
			uniqueElementsMap.put(k, Boolean.TRUE);
			sum = sum + k;
		}

		return sum;

	}
	
	int maxdepth(Node node) {
		if(node==null) return 0;
		return 1+Math.max(maxdepth(node.left),maxdepth(node.right));
	}
}
