package com.test.hackerrank.stack;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBracket {
	static String isBalanced(String s) {
		// Complete this function
		char[] arr = s.toCharArray();
		Stack<Character> st = new Stack<>();
		int n = s.length();
		boolean isBalanced = false;
		for (int i = 0; i < n; i++) {
			if (arr[i] == '(' || arr[i] == '{' || arr[i] == '[') {
				st.push(arr[i]);
			} else if (!st.isEmpty() && isMatching(arr[i], st.peek())) {
				st.pop();
			} else {
				isBalanced = false;
				st.push(arr[i]);
				break;
			}
		}
		if (st.isEmpty()) {
			isBalanced = true;
		}
		return isBalanced ? "YES" : "NO";
	}

	private static boolean isMatching(char c, Character peek) {
		if (c == ')' && peek == '(')
			return true;
		if (c == ']' && peek == '[')
			return true;
		if (c == '}' && peek == '{')
			return true;
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String s = in.next();
			String result = isBalanced(s);
			System.out.println(result);
		}
		in.close();
	}
}
