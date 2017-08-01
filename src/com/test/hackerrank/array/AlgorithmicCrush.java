package com.test.hackerrank.array;

import java.util.Scanner;

public class AlgorithmicCrush {

	/*
	 * Instead of storing the actual values in the array, you store the
	 * difference between the current element and the previous element. So you
	 * add sum to a[p] showing that a[p] is greater than its previous element by
	 * sum. You subtract sum from a[q+1] to show that a[q+1] is less than a[q]
	 * by sum (since a[q] was the last element that was added to sum). By the
	 * end of all this, you have an array that shows the difference between
	 * every successive element. By adding all the positive differences, you get
	 * the value of the maximum element
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long[] diffArr = new long[(int) (n + 1)];
		long m = in.nextLong();
		for (int i = 0; i < m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int k = in.nextInt();
			diffArr[a - 1] += k;
			if (b < n + 1)
				diffArr[b] -= k;
		}
		long max = diffArr[0];
		long currentSum = diffArr[0];
		for (long i = 1; i < n; i++) {
			currentSum = currentSum + diffArr[(int) i];
			if (currentSum > max) {
				max = currentSum;
			}
		}
		System.out.println(max);
	}
}
