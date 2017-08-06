package com.test.hackerrank.common;

import java.util.Scanner;

/**
 * Problem: Finding the number of perfect squares between two integer range.
 * 
 * Input: first integer and last integer -> int startInteger, int endInteger
 * 
 * Output: total number of perfect squares including this number -> int count
 * 
 * 
 * 
 * The worst approach would be to loop over each element and check whether it is
 * an integer.
 * 
 * The best approach would be to determine the floor of root of first integer
 * and ceil of root of last integer.
 * 
 * 
 * 
 * So lets take an example of 10, 100.
 * 
 * The expected answer would be: 7
 * 
 * 
 * 
 * So first compute the floor of the square root of 10 that would be 3.
 * 
 * And then compute the ceil of the square root of 100 that would be 10.
 * 
 * 10 - 3 = 7 will be the output. It will be O(1) .
 *
 */
public class TotalNumberPerfectSquare {
	/*
	 * Please Enter Your Lower Limit
		10
		Please Enter Your Upper Limit
		100
		Total Number of Perfect square are:7
		
		Please Enter Your Lower Limit
		2
		Please Enter Your Upper Limit
		12
		Total Number of Perfect square are:2
		
		Please Enter Your Lower Limit
		45
		Please Enter Your Upper Limit
		500
		Total Number of Perfect square are:16
	 */
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please Enter Your Lower Limit");
		int low = in.nextInt();
		System.out.println("Please Enter Your Upper Limit");
		int high = in.nextInt();
		in.close();

		int smallestNumber = (int) Math.ceil(Math.sqrt(low));
		int highestNumber = (int) Math.floor(Math.sqrt(high));

		System.out.println("Total Number of Perfect square are:" + (highestNumber - smallestNumber + 1));
	}
}
