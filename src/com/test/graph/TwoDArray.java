package com.test.graph;

public class TwoDArray {

	public static void main(String[] args) {
		String[][] salutation = { { "Mr. ", "Mrs. ", "Ms. " }, { "Kumar" } };
		
		System.out.println(salutation[0][0] + salutation[1][0]);
		
		System.out.println(salutation[0][1] + salutation[1][0]);
		
		System.out.println(salutation[0][2] + salutation[1][0]);
		
		boolean[][] board = new boolean[3][4];
		System.out.println(board.length);
		
		System.out.println(board[2].length);
	}

}
