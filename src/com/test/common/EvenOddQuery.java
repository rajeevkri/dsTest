package com.test.common;

import java.util.Scanner;

public class EvenOddQuery {
	/*
	 * Input Format
		---The first line contains an integer N.
		---The next line contains N space separated single-digit integers (whole numbers between 0 and 9). The third line contains a positive integer Q, denoting the number of queries to follow.
		---Each of the subsequent Q lines contains two positive integers x and y separated by a single space.
		---Output Format
		---For each query, print the  “Even”  if the value returned is even, otherwise print "Odd " without quotes.
---Sample Input #00
---3
---3 2 7
---2
---1 2
---2 3   
---Sample Output #00
---Odd
---Even   
---Explanation #00
---find(1,2) = 3^2 = 9, which is odd.

---find(2,3) = 2^7 = 128, which is even.  
	 */
	
	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        int[] A = new int[N];
        String[] strs = in.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(strs[i]);
        }
        for (int i = Integer.parseInt(in.nextLine()); i > 0; i--) {
            strs = in.nextLine().split(" ");
            int m = Integer.parseInt(strs[0])-1;
            int n = Integer.parseInt(strs[1])-1;
            int base = A[m];
            int power = (m == n) ? 1 : A[m+1];
            if (power == 0 || (base & 1) == 1) sb.append("Odd\n");
            else sb.append("Even\n");
        }
        System.out.print(sb);
    }
}
