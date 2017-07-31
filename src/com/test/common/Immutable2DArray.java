package com.test.common;

/**
 * 
 * Design a Immutable 2d array where fetching sum from any set of index to other
 * set of index
 * 
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle
 * defined by its upper left corner (row1, col1) and lower right corner (row2,
 * col2). is of complexity O(1)
 * 
 * @author Rajeev
 *
 */
public class Immutable2DArray {

	int[][] T;

	public Immutable2DArray(int[][] matrix) {
		int rows = matrix.length;
		int columns = matrix[0].length;

		T = new int[rows + 1][columns + 1];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				T[i + 1][j + 1] = T[i][j + 1] + T[i + 1][j] + matrix[i][j] - T[i][j];
			}
		}
	}

	public int sumQuery(int row1, int col1, int row2, int col2) {
		row1++;
		col1++;
		row2++;
		col2++;
		int sum = T[row2][col2] - T[row1][col1 - 1] - T[row1 - 1][col1] + T[row1 - 1][col1 - 1];
		return sum;
	}

	public static void main(String args[]) {
		int[][] input = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };

		int[][] input1 = { { 2, 0, -3, 4 }, { 6, 3, 2, -1 }, { 5, 4, 7, 3 }, { 2, -6, 8, 1 } };
		Immutable2DArray isr1 = new Immutable2DArray(input);
		System.out.println(isr1.sumQuery(1, 1, 2, 2));
		Immutable2DArray isr = new Immutable2DArray(input1);
		System.out.println(isr.sumQuery(1, 1, 2, 2));
		System.out.println(isr.sumQuery(1, 1, 2, 3));
		System.out.println(isr.sumQuery(2, 2, 3, 3));
	}


}
