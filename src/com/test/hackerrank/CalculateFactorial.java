package com.test.hackerrank;


/**
 * Calculate Factorial
 * 
 * easy Implementation Dynamic Programming Algorithms Core CS
Use Question
Testcases: 13 (3 Sample)
Complete the function factorial in your editor. It has 1 parameter:
An integer, n.
It must return the factorial of n.
Input Format The locked stub code in your editor reads the following input from stdin and passes it to your function:
The first line contains a single integer N.
Constraints
1 ≤ N ≤ 15
Output Format Your function must return the factorial of n. This is printed to stdout by the locked stub code in your editor.
Sample Input 1
2
Sample Output 1
2
Sample Input 2
3
Sample Output 2
6
Sample Input 3
4
Sample Output 3
24
Explanation 3
Factorial of 4 is 1_2_3*4 = 24.
 *
 */
public class CalculateFactorial {

	static long factorial(int n) {
	    long res = 1;
	    if (n <= 0) return 0;
	    while (n != 0) {
	        res *= (long)n;
	        n--;
	    }
	    return res;
	}   
}
