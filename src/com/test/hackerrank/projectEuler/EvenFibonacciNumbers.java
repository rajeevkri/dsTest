package com.test.hackerrank.projectEuler;

import java.util.Scanner;

public class EvenFibonacciNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		long[] arr = new long[t];
		for (int a0 = 0; a0 < t; a0++) {
			long n = in.nextLong();
			arr[a0] = n;
		}

		in.close();
		for (int i = 0; i < t; i++) {
			long n = arr[i];
			
		}
	}
}
