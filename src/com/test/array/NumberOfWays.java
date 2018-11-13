package com.test.array;
/**
 * Number of way delete one element from array and make it sorted in ascending order
 *
 * @author srajeev
 *
 */
public class NumberOfWays {
	static int numberOfWays(int[] array) {
		int ways = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i - 1] > array[i]) {
				if (ways != 0)
					return 0;
				if (i == 1 || array[i - 2] <= array[i])
					++ways;
				if (i == array.length - 1 || array[i - 1] <= array[i + 1])
					++ways;
				if (ways == 0)
					return 0;
			}
		}
		return (ways == 0) ? array.length : ways;
	}
	
	public static void main(String[] args) {
		int[][] arrays = new int[][]{
			  { 1,2,3,4 },
			  { 1,3,2,4 },
			  { 1,2,4,3 },
			  { 1,3,4,2 },
			  { 2,4,1,3 },
			  { 2,4,1,3 }
			};

		for (int[] a : arrays)
		    System.out.println(a + " &rarr; " + numberOfWays(a) + "<br>");
		
		int [] A = {3, 4, 5, 4};
		System.out.println(numberOfWays(A));
		
	}

}
