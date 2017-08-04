package com.test.dp;

import java.util.Scanner;

public class SherlockAndCost {
	// Explanation
	// We have to build array A such that each element in array A lies in
	// between 1 and Bi. In order to maximize the cost, its enough to choose
	// either 1 or Bi for Ai(proof is left to the readers).So for every index i
	// we have two choices either 1 or Bi. Try all possibilities .
	// Overlapping subproblems are seen which can be memoized for better
	// complexity.
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		for (int i = 0; i < T; i++) {
			int n = in.nextInt();
			int[] b = new int[n];
			for (int j = 0; j < n; j++) {
				b[j] = in.nextInt();
			}

			long arr[][] = new long[2][n];
			for (int j = 1; j < n; j++) {
				arr[0][j] = Math.max(arr[0][j - 1] + Math.abs(b[j] - b[j - 1]), arr[1][j - 1] + Math.abs(b[j] - 1));
				arr[1][j] = Math.max(arr[0][j - 1] + Math.abs(b[j - 1] - 1), arr[1][j - 1] + Math.abs(1 - 1));
			}
			System.out.println(Math.max(arr[0][n - 1], arr[1][n - 1]));
		}
	}
}
