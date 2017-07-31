package com.test.hackerrank;

/**
 * Reduce the Fraction
easy Algorithms Brute Force Data Structures Core CS
Use Question
Testcases: 6 (1 Sample)
You are given a fraction in the form X/Y where X and Y are two integers. Your task is to reduce it to its lowest Irreducible state: X’/Y’.
For example, 4/6 should be reduced to 2/3, 20/10 should be reduced to 2/1,  160/28 should be reduced to 40/7 - and so on.
Complete the ReduceFraction function in your editor. It has 1 parameter:
A string array fractions.  
It must return a string array, where ith element is result for the ith test case.
Input Format
The locked stub code in your editor reads the following input from stdin and passes it to your function:
The first line contains an integer n
Next n lines contains a string in each line containing a fraction provided in the form X/Y, where ith line denotes ith test case.
Constraints
1 ≤ X, Y ≤ 2000
1 ≤ N ≤ 500
Output Format
Your function must return a string array, where ith denotes result for the ith test case. This is printed to stdout by the locked stub code in your editor.
Sample Input
10
825/1161
1092/1041
315/840
1104/1119
724/404
692/176
208/286
65/362
126/151
270/318
Sample Output
275/387
364/347
3/8
368/373
181/101
173/44
8/11
65/362
126/151
45/53
 *
 */
public class ReduceTheFraction {

	static String[] ReduceFraction(String[] fractions) {
	    String[] res = new String[fractions.length];
	    for (int i = 0; i < fractions.length; i++) {
	        String[] nums = fractions[i].split("/");
	        int[] n = new int[2];
	        n[0] = Integer.parseInt(nums[0]);
	        n[1] = Integer.parseInt(nums[1]);
	        StringBuilder sb = new StringBuilder();
	        sb.append(n[0]/(GCD(n[0], n[1]))+"/"+n[1]/(GCD(n[0], n[1])));
	        res[i] = sb.toString();
	    }
	    return res;
	}
	static int GCD(int n1, int n2) {
	    if (n2 == 0) return n1;
	    return GCD(n2, n1%n2);
	}   
}
