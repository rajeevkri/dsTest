package com.test.dp;

import java.util.Arrays;

public class Operations {

	/**
	 * Problem Statement:
	 *
	 * Given an array of n positive integers. Write a program to find the sum of
	 * maximum sum subsequence of the given array such that the integers in the
	 * subsequence are in increasing order.
	 *
	 *
	 * Reference:
	 * http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-
	 * increasing-subsequence/
	 */
	public int maximumSumIncreasingSubsequence(int arr[]) {
		int length = arr.length;
		int[] temp = Arrays.copyOf(arr, length);

		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {// this means it is increasing
					temp[i] = Math.max(temp[i], temp[j] + arr[i]);
				}
			}
		}

		int max = temp[0];
		for (int i = 1; i < temp.length; i++) {
			if (temp[i] > max) {
				max = temp[i];
			}
		}
		return max;
	}

	// http://www.geeksforgeeks.org/amazons-asked-interview-questions/
	void display(Operations t) {
		System.out.println("test");
	}

	void display(String s) {
		System.out.println("s");

	}

	public static void main(String[] args) {
		// new Operations().display(null);
	}

	/*
	 * Function to return max sum such that no two elements are adjacent
	 */
	int findMaxSum(int arr[], int n) {
		int incl = arr[0];
		int excl = 0;
		int temp;
		for (int i = 1; i < n; i++) {
			temp = Math.max(incl, excl);
			incl = excl + arr[i];
			excl = temp;
		}
		return Math.max(incl, excl);
	}

	int maxValue(int[][] field) {
		int r = field.length;
		int c = field[0].length;
		int[][] maxValues = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (i == 0 && j == 0) {
					maxValues[i][j] = field[i][j];
				} else if (i == 0) {
					maxValues[i][j] = maxValues[i][j - 1] + field[i][j];
				} else if (j == 0) {
					maxValues[i][j] = maxValues[i - 1][j] + field[i][j];
				} else {
					maxValues[i][j] = Math.max(maxValues[i][j - 1], maxValues[i - 1][j]) + field[i][j];
				}
			}
		}
		return maxValues[r - 1][c - 1];
	}

	/**
	 * Solves 0/1 knapsack in bottom up dynamic programming using bottom up
	 * approach
	 * 
	 * @param wt
	 *            array of given weights
	 * @param val
	 *            array of value corresponding to weight
	 * @param w
	 *            total weight
	 * @return Max value you can get via adding weight values such that sum of
	 *         weight is equal to given weight
	 * 
	 */
	public int knapsack(int val[], int wt[], int w) {
		int T[][] = new int[val.length + 1][w + 1];
		for (int i = 0; i <= val.length; i++) {
			for (int j = 0; j <= w; j++) {
				if (i == 0 || j == 0) {
					T[i][j] = 0;
					continue;
				}
				if (j - wt[i - 1] >= 0) {
					T[i][j] = Math.max(T[i - 1][j], val[i - 1] + T[i - 1][j - wt[i - 1]]);
				} else {
					T[i][j] = T[i - 1][j];
				}
			}
		}
		return T[val.length][w];
	}

	public int longestIncreasingSubSequence(int[] arr) {
		int n = arr.length;
		int T[] = new int[n];
		//Array using which we can backtrack to find actual array which has given us max length
		int finalSequ[] = new int[n];
		for (int i = 0; i < n; i++) {
			T[i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					int k = T[j] + 1;
					if (k > T[i]) {
						T[i] = k;
						//set value from which index this value is being updated
						finalSequ[i] = j;
					}
				}
			}
		}
		int max = T[0];
		for (int i = 1; i < n; i++) {
			if (T[i] > max) {
				max = T[i];
			}
		}

		return max;
	}

}
