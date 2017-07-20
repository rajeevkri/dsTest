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
	
	
}
