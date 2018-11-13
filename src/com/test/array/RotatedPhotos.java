package com.test.array;

import java.util.Scanner;

/**
 * 
 * 
 * Rotated Photos subject Codingcasino 50 points DESCRIPTION A photo session was
 * conducted in Dreamville town and photographs of all the people were taken for
 * the government database. However, because of a fault in the camera, all
 * images got rotated by 90 degrees anti clockwise.
 * 
 * Your job, as the government officer, is to rotate all images by 90 degree
 * clockwise so that they can be properly saved.
 * 
 * As a Dreamville tradition, all photographs that were clicked were square
 * photographs of N x N pixels.
 * 
 * Input: Line 1 contains an integer N This is followed by N lines where each
 * line contains N integers denoting the pixel values of the image
 * 
 * Output: N lines where each line contains N integers denoting the pixel values
 * of the rotated image
 * 
 * Constraints:
 * 
 * 1 <= N <= 200 0 <= pixel value <= 255
 * 
 * Test Case #1: Input: 3 3 4 7 7 3 0 9 2 4
 * 
 * Output: 9 7 3 2 3 4 4 0 7 EXECUTION TIME LIMIT Default.
 * 
 * 
 * @author srajeev
 *
 */
public class RotatedPhotos {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();// Size of square

		int[][] photoPixels = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				photoPixels[i][j] = in.nextInt();
			}
		}
		in.close();
		rotateClockwise(n, photoPixels);
		printPhoto(photoPixels, n);
	}

	static void rotateClockwise(int N, int photoPixels[][]) {
		for (int x = 0; x < N / 2; x++) {
			for (int y = x; y < N - x - 1; y++) {
				int temp = photoPixels[N - 1 - y][x];
				photoPixels[N - 1 - y][x] = photoPixels[N - 1 - x][N - 1 - y];
				photoPixels[N - 1 - x][N - 1 - y] = photoPixels[N - 1 - x][N - 1 - y];
				photoPixels[N - 1 - x][N - 1 - y] = photoPixels[y][N - 1 - x];
				photoPixels[y][N - 1 - x] = photoPixels[x][y];
				photoPixels[x][y] = temp;
			}
		}
	}

	static void printPhoto(int photoPixels[][], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(photoPixels[i][j]);
				if (j != n ) {
					System.out.print(" ");
				}

			}
			System.out.println();
		}
	}

}
