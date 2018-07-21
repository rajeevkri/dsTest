package com.test.hackerearth.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		if (s.hasNext()) {
			Integer n = s.nextInt();
			Graph g = new Graph(n);
			for (int i = 1; i <= n - 1; i++) {
				int a = s.nextInt();
				int b = s.nextInt();
				g.addEdge(a, b);
			}
		}
	}
}
