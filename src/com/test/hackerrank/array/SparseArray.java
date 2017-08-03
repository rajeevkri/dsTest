package com.test.hackerrank.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SparseArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0;i<n;i++) {
			String next = in.next();
			int count = 1;
			if(map.containsKey(next)) {
				count = map.get(next);
                count ++;
			}
			map.put(next, count);
		}
		int m = in.nextInt();
		for(int i=0;i<m;i++) {
			String next = in.next();
			Integer count = map.get(next);
			if(count == null)
				System.out.println("0");
			else
				System.out.println(count);
		}
	}
}
