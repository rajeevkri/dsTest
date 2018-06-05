package com.test.hackerrank.array;

import java.util.Scanner;

public class Solution {
	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long []arr = new long[(int)n];
        for(int i = 0 ;i<n;i++) {
            arr[i] = in.nextLong();
        }
        long q = in.nextLong();
        for(int i =1;i<=q; i++) {
            long l = in.nextLong()-1;
            long r= in.nextLong()-1;
            
            long x= in.nextLong();
            Count c = new Solution().new Count();
            binarySearch(arr, l, r, x, c);
            System.out.println(c.count);
        }
    }
	class Count {
		int count =0;
	}
	static void binarySearch(long arr[], long l, long r, long x, Count c)
    {
        if (r>=l)
        {
            int mid = (int) (l + (r - l)/2);
 
            if (arr[mid] == x)
            		c.count++;
 
            if (arr[mid] > x)
               binarySearch(arr, l, mid-1, x, c);
 
            binarySearch(arr, mid+1, r, x, c);
        }
 
        return;
    }
}
