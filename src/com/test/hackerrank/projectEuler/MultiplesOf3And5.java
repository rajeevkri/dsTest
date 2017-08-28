package com.test.hackerrank.projectEuler;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * Project Euler #1: Multiples of 3 and 5
 * 
 * @author rajeevsingh
 *
 */
public class MultiplesOf3And5 {
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
        in.close();
        if(max <3) {
        		for(int i =0 ; i<t;i++) {
        			System.out.println(0);
        		}
        }
        
        boolean[] mul = getArray(max);
        for(int j =0 ; j<t;j++) {
        		int a = arr[j];
            int sum = 0;
            for (int i = 0; i < a; i++) {
                if (mul[i])
                    sum += i;
            }
            System.out.println(sum);
		}
    }

	private static boolean[] getArray(int a) {
		boolean prime [] = new boolean[a + 1];
		int x = 3, y=5;
		while(x<=a) {
			prime[x] = true;
			x = x + 3;
		}
		while(y<=a) {
			prime[y] = true;
			y = y + 5;
		}
		return prime;
	}
}
