package com.test.greedy;

import java.util.Arrays;

/**
 * n is total number of people and p contains how many people each umbrella covers 
 * 
 * @author rajeev
 *
 */
public class UmbrellaCount {

	static int getUmbrellas(int n, int[] p) {
		if (p == null) {
			return -1;
		}
		int k = p.length;
		Arrays.sort(p);
		int sum = 0;
		int total = n;
		int [] r = new int[k];
		boolean first = true;
		for (int i = k - 1; i >= 0;) {
			if(total == 0) {
				break;
			}
			if (total < p[i]) {
				i--;
			} else {
				sum++;
				total = total - p[i];
				if(first) {
					r[i] = -1;
					first = false;
				}
			}
		}
		if(sum >0 && total ==0) {
			return sum;
		}
        if(sum > 0 && total != 0) {
            return getUmbrellas(n, p, r);
        }

		return -1;
	}
	static int getUmbrellas(int n, int[] p ,int [] r) {
		int sum = 0;
		int total = n;
		int k = p.length;
		boolean first = true;
		for (int i = k - 1; i >= 0;) {
			if(r[i] == -1 && first) {
				i--;
				continue;
			}
			if(total == 0) {
				break;
			}
			if (total < p[i]) {
				i--;
			} else {
				sum++;
				total = total - p[i];
				if(first) {
					r[i] = -1;
					first = false;
				}
			}
		}
		if(sum >0 && total ==0) {
			return sum;
		}
		if(sum > 0 && total != 0) {
            return -1;
        }

		return -1;
	}
	public static void main(String[] args) {
		int [] arr = {4,2,7,9,3};
		System.out.println(getUmbrellas(8, arr));
	}
}
