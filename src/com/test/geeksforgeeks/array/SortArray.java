package com.test.geeksforgeeks.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * Write a program to sort an array of 0's,1's and 2's in ascending order.
 * 
 * Input: The first line contains an integer 'T' denoting the total number of
 * test cases. In each test cases, First line is number of elements in array 'N'
 * and second its values.
 * 
 * Output: Print the sorted array of 0's, 1's and 2's.
 * 
 * Constraints:
 * 
 * 1 <= T <= 100 1 <= N <= 105 0 <= arr[i] <= 2
 * 
 * Example:
 * 
 * Input :
 * 
 * 2 
 * 5 
 * 0 2 1 2 0 
 * 3 
 * 0 1 0
 * 
 * 
 * Output:
 * 
 * 0 0 1 2 2 
 * 0 0 1
 * 
 * @author srajeev
 *
 */
public class SortArray {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		for (int i = 0; i < total; i++) {
			int length = scan.nextInt();
			int arr[] = new int[length];
			for (int j = 0; j < length; j++) {
				arr[j] = scan.nextInt();
			}
			System.out.println(Arrays.toString(sortArrayWith012(arr)));
		}
	}

	static int[] sortArrayWith012(int[] arr) {
		int zeroCount = 0, oneCount = 0, twoCount = 0;
		for (int i : arr) {
			if (i == 0) {
				zeroCount++;
			}
			if (i == 1) {
				oneCount++;
			}
			if (i == 2) {
				twoCount++;
			}
		}
		int n = arr.length;
		int i;
		for (i = 0; i < zeroCount; i++) {
			arr[i] = 0;
		}
		for (; i < zeroCount + oneCount; i++) {
			arr[i] = 1;
		}
		for (; i < zeroCount + oneCount + twoCount; i++) {
			arr[i] = 2;
		}
		return arr;
	}
}
