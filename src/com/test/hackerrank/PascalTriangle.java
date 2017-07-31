package com.test.hackerrank;

/**
 * Pascal’s Triangle
Recursion Algorithms Easy Core CS
Use Question
Testcases: 6 (1 Sample)
Pascal’s Triangle
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
1 5 10 10 5 1
1 6 15 20 15 6 1
…
The rth column of nth row of the Pascal’s Triangle is n! / ( r! x (n - r)! ). Note that the value of n starts from 0 and nth row has (n + 1)entries, i.e., 0 ≤ r ≤ n.
Complete the function pascalTriangle, that has one parameter- an integer k. The function should print first k rows of Pascal’s Triangle, and the entries of a row must be printed separated by space.
Input Format The input consists of single integer, k.
Constraints
2 ≤ k ≤25
Output Format
Print first k rows of the Pascal’s Triangle (n = 0 to k - 1).
Sample Input
4
Sample Output
1
1 1
1 2 1
1 3 3 1
Explanation
The first row is n = 0 and r = 0.
The second row is n = 1 and r = 0 to 1.
The third row is n = 2 and r = 0 to 2.
The fourth row is n = 3 and r = 0 to 3.

 *
 */
public class PascalTriangle {
	static void pascalTriangle(int k) {
	    for (int i = 0; i < k; i++) {
	        for (int j = 0; j <= i; j++) {
	            System.out.print(pascal(i, j) + " ");
	        }
	        System.out.println();
	    }

	}
	static int pascal(int i, int j) {
	    if (j == 0) return 1;
	    if (i == j) return 1;
	    return pascal(i-1, j-1) + pascal(i-1, j);
	}   
}
