package com.test.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShapeCheck {
	public static void main(String args[]) throws Exception {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT
		 */
		Scanner in = new Scanner(System.in);
		Map<String, Integer> map = new HashMap<>();

		while (in.hasNext()) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			int d = in.nextInt();
			String result = getShape(a, b, c, d);
			int count = 0;
			if (map.get(result) != null) {
				count = map.get(result);
			}
			count++;
			map.put(result, count);
		}

		System.out.println(map.get("square") + " " + map.get("rectangle") + " " + map.get("none"));
	}

	private static String getShape(int a, int b, int c, int d) {
		String shape = "";
		if (a < 0 || b < 0 || c < 0 || d < 0) {
			shape = "none";
		}
		if (a == b && b == c && c == d) {

			shape = "square";
		}
		if (a == c && b == d) {
			shape = "rectangle";
		}
		return shape;
	}

}
