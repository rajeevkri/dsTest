package com.test.hackerrank;

/**
 * 
 * Prime or Not?
easy Algorithms Prime Numbers Math Logic Core CS
Use Question
Testcases: 26 (2 Sample)
Complete the isPrime function in the editor below. It has one parameter: a long integer, n. The function must return an integer denoting the following:
If n is prime, return the integer 1.
If n is not prime, return an integer denoting the smallest factor of n that is greater than one.
Input Format
Locked stub code in the editor reads a single long integer, n, from stdin and passes it to the function.
Constraints
2 ≤ n ≤ 1012
Output Format
The function must return an integer denoting the following:
If n is prime, return the integer 1.
If n is not prime, return an integer denoting the smallest factor of n that is greater than one.
This is printed to stdout by locked stub code in the editor.
Sample Input 0
2
Sample Output 0
1
Explanation 0
As 2 is a prime number, the function returns 1 denoting that it’s prime.
Sample Input 1
4
Sample Output 1
2
Explanation 1
As 4 is not a prime number, the function returns 2 denoting the smallest factor of 4.
 *
 */
public class PrimeOrNot {
	static int isPrime(long n) {
	    if (n <= 2) return 1;
	    else if (n > 2 && n % 2 == 0) return 2;
	    for (int i = 2; i <= n/2; i++) {
	        if (n % i == 0) return i;
	    }
	    return 1;
	}   
}
