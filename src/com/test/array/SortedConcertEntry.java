package com.test.array;

import java.util.Scanner;

/**
 * 
 * Rotated Photos
subject Codingcasino 50 points
DESCRIPTION
A photo session was conducted in Dreamville town and photographs of all the people were taken for the government database. However, because of a fault in the camera, all images got rotated by 90 degrees anti clockwise.

Your job, as the government officer, is to rotate all images by 90 degree clockwise so that they can be properly saved.

As a Dreamville tradition, all photographs that were clicked were square photographs of N x N pixels.

Input:
Line 1 contains an integer N
This is followed by N lines where each line contains N integers denoting the pixel values of the image

Output:
N lines where each line contains N  integers denoting the pixel values of the rotated image

Constraints:

1 <= N <= 200
0 <= pixel value <= 255

Test Case #1:
Input:
3
3 4 7
7 3 0
9 2 4

Output:
9 7 3
2 3 4
4 0 7
EXECUTION TIME LIMIT
Default.
 * 
 * @author srajeev
 *
 */
public class SortedConcertEntry {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();// Total number of people

		int[] input1 = new int[n]; // First row
		int[] input2 = new int[n]; // Second row
		for (int i = 0; i < n; i++) {
			input1[i] = in.nextInt();
		}
		for (int i = 0; i < n; i++) {
			input2[i] = in.nextInt();
		}
		in.close();

		boolean isEnterPossible = checkEnterPossible(input1, input2, n);
		System.out.println(isEnterPossible ? "YES" : "NO");
	}

	private static boolean checkEnterPossible(int[] input1, int[] input2, int length) {
		for (int i = 0; i < length - 1; i++) {
			if (input1[i] <= input1[i + 1] && input2[i] <= input2[i + 1]) {
				continue;
			} else if (input1[i] <= input2[i + 1] && input2[i] <= input1[i + 1]) {
				int temp = input1[i];
				input1[i] = input2[i];
				input2[i] = temp;
			} else {
				return false;
			}
		}
		return true;
	}
}
