package com.test.dp;

import java.util.ArrayList;

public class MinimumStepsToReachEndOfArray {

	public static int getMinSteps(int[] input) {
		int n = input.length;
		int[] T = new int[n];
		for(int i = 1; i<n; i++) {
			T[i] = -1;
		}
		for(int i =1; i< n; i++ ) {
			for(int j=0; j<i; j++) {
				if(i <= j+ input[j] && T[j] != -1) {
					if(T[i] != -1)
						T[i] = Math.min(T[i], 1 + T[j]);
					else
						T[i] = 1+ T[j];
 				}
			}
		}
		return T[n-1];
	}
	public static int jump(ArrayList<Integer> A) {
		int n = A.size();
		int[] T = new int[n];
		for(int i = 1; i<n; i++) {
			T[i] = -1;
		}
		for(int i =1; i< n; i++ ) {
			for(int j=0; j<i; j++) {
				if(i <= j+ A.get(j) && T[j] != -1) {
					if(T[i] != -1)
						T[i] = Math.min(T[i], 1 + T[j]);
					else
						T[i] = 1+ T[j];
 				}
			}
		}
		return T[n-1];
    }
	
	public static void main(String[] args) {
		int[] input = {2,3,1,1,2,4,2,0,1,1};
		System.out.println(getMinSteps(input));
		int[] input1 = {0, 46, 46, 0, 2, 47, 1, 24, 45, 0, 0, 24, 18, 29, 27, 11, 0, 0, 40, 12, 4, 0, 0, 0, 49, 42, 13, 5, 12, 45, 10, 0, 29, 11, 22, 15, 17, 41, 34, 23, 11, 35, 0, 18, 47, 0, 38, 37, 3, 37, 0, 43, 50, 0, 25, 12, 0, 38, 28, 37, 5, 4, 12, 23, 31, 9, 26, 19, 11, 21, 0, 0, 40, 18, 44, 0, 0, 0, 0, 30, 26, 37, 0, 26, 39, 10, 1, 0, 0, 3, 50, 46, 1, 38, 38, 7, 6, 38, 27, 7, 25, 30, 0, 0, 36, 37, 6, 39, 40, 32, 41, 12, 3, 44, 44, 39, 2, 26, 40, 36, 35, 21, 14, 41, 48, 50, 21, 0, 0, 23, 49, 21, 11, 27, 40, 47, 49};
		System.out.println(getMinSteps(input1));
	}
}
