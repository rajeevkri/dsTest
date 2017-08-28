package com.test.hackerrank.projectEuler;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Project Euler #10: Summation of primes
 * 
 * @author rajeevsingh
 *
 */
public class SummationOfPrime {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int arr[] = new int[t];
        int max = 0;
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            arr[a0] = n;
            if(max < n){
                max = n;
            }
        }
        boolean[] prime = getArray(max);
        for(int j =0;j<t;j++) {
            int a = arr[j];
            int sum = 0;
            for (int i = 0; i <= a; i++) {
                if (prime[i])
                    sum += i;
            }
            System.out.println(sum);
        }
        
    }
    
    public static boolean[] getArray(int a) {
		boolean prime [] = new boolean[a + 1];
	    Arrays.fill(prime, true);
	    prime[0] = prime[1] = false;
	    
	    for (int i = 2; i <= a; i++) {
	        if (!prime[i])
	            continue;
	            
	        for (long j = 1L * i * i; j <= (long) a; j += i)
	            prime[(int) j] = false;
	    }
	    
	    
	    return prime;
	}
}
