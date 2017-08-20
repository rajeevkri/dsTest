package com.test.hackerrank.stack;

import java.util.Scanner;
import java.util.Stack;

public class MaxRectangleInStack {
	static long largestRectangle(int[] h) {
		// Complete this function
		Stack<Integer> st = new Stack<>();
		int i = 0;
		int n = h.length;
		long area = 0;
		long maxArea = 0;
		while (i < n) {
			if (st.isEmpty() || h[st.peek()] <= h[i]) {
				st.push(i);
				i++;
			} else {
				int top = st.pop();

				if (st.isEmpty()) {
					area = (long) h[top] * (long) i;
				} else {
					area = (long) h[top] * (long) (i - st.peek() - 1);
				}
				if (area > maxArea) {
					maxArea = area;
				}
			}

		}
		while (!st.isEmpty()) {
			int top = st.pop();

			if (st.isEmpty()) {
				area = h[top] * i;
			} else {
				area = h[top] * (i - st.peek() - 1);
			}
			if (area > maxArea) {
				maxArea = area;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] h = new int[n];
		for (int h_i = 0; h_i < n; h_i++) {
			h[h_i] = in.nextInt();
		}
		long result = largestRectangle(h);
		System.out.println(result);
		in.close();
	}
}
