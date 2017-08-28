package com.test.hackerrank.projectEuler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LargestPrimeFactor {

	public static int largestPrimeFactor(long number) {
		int i;

		for (i = 3; i <= number; i = i +2) {
			if (number % i == 0) {
				number /= i;
				i = i -2;
			}
		}

		return i;
	}

	public static void main(String[] args) {
		Map<Long, Integer> m = new HashMap<>();
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		long arr[] = new long[t];
		for (int a0 = 0; a0 < t; a0++) {
			long n = in.nextLong();
			arr[a0] = n;
		}
		in.close();
		for (int i = 0; i < t; i++) {
			long a = arr[i];
			if(a == 2) {
                System.out.println(a);
                continue;
            }

			if (m.get(a) != null) {
				System.out.println(m.get(a));
			} else {
				long x = a;
				while (x % 2 == 0) {
					x = x / 2;
					if (m.get(x) != null)
						System.out.println(m.get(x));
					continue;
				}
				int v = largestPrimeFactor(x);
				System.out.println(v);
				m.put(a, v);
				m.put(x, v);
			}
		}

	}
	
	
}
