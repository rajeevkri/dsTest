package com.test.hackerearth.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TestClass {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<Integer>();

		if (s.hasNext()) {
			Integer n = s.nextInt();
			boolean[][] graph = new boolean[n + 1][n + 1];
			for (int i = 1; i <= n - 1; i++) {
				int a = s.nextInt();
				int b = s.nextInt();
				graph[a][b] = true;
				graph[b][a] = true;
			}
			int x = s.nextInt();
			int[] visited = new int[n + 1];
			visited[0] = 1;
			visited[1] = 1;
			queue.add(1);
			queue.add(-1);
			int i = 0, element, level = 1, count = 0;
			while (!queue.isEmpty()) {
				element = queue.remove();
				if (element == -1) {
					level++;
					queue.add(-1);
					continue;
				}
				if(level == x) {
					count++;
				}
				if(level >x) {
					break;
				}
				i = element;
				while (i <= n) {
					if (graph[element][i] == true && visited[i] == 0) {
						queue.add(i);
						visited[i] = 1;
					}
					i++;
				}
				i = element;
			}
			System.out.println(count);
		}
		s.close();
	}
}
