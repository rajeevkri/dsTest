package com.test.hackerrank.array;

import java.util.Scanner;

public class AlgorithmicCrush {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long[] diffArr = new long[(int) (n + 1)];
		long m = in.nextLong();
		for (int i = 0; i < m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int k = in.nextInt();
			diffArr[a-1] +=k;
			if(b<n+1) diffArr[b] -=k;
		}
		long max = diffArr[0];
		long currentSum = diffArr[0];
		for (long i = 1; i < n; i++) {
			currentSum = currentSum + diffArr[(int) i];
			if (currentSum > max) {
				max = currentSum;
			}
		}
		System.out.println( max);
	}
}
