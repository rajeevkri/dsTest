package com.test.hackerrank.array;

import java.util.Scanner;

public class LeftRotation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int r = in.nextInt();
		int [] inputArr = new int[n];
		int [] arr = new int[r];
		for(int j=0; j<r;j++) {
			arr[j] = in.nextInt();
		}
		for(int i=0; i<n-r; i++) {
			inputArr[i] = in.nextInt();
			System.out.print(inputArr[i] + " ");
		}
		for(int i=n-r; i<n; i++) {
			inputArr[i] = arr[i -n +r];
			System.out.print(inputArr[i] + " ");
		}
		
	}
}
