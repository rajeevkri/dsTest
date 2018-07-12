package com.test.hackerearth.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {

	LinkedList<Integer> G[];
	int n;

	public Graph(int n) {
		super();
		this.n = n;
		G = new LinkedList[n+1];
		for (int i = 0; i < n+1; i++) {
			G[i] = new LinkedList<Integer>();
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < G.length; i++)
			result.append(i + " ==> " + G[i] + "\n");
		return result.toString();
	}

	public void addEdge(int u, int v) {
		G[u].addFirst(v);
	}

	boolean isConnected(int u, int v) {
		for (Integer i : G[u]) {
			if (i == v) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// Graph g = new Graph(10);
		// g.addEdge(0, 2);
		// g.addEdge(0, 5);
		// g.addEdge(2, 2);
		// System.out.println(g);

		Scanner s = new Scanner(System.in);
		if (s.hasNext()) {
			Integer n = s.nextInt();
			Graph g = new Graph(n);
			for (int i = 1; i <= n - 1; i++) {
				int a = s.nextInt();
				int b = s.nextInt();
				g.addEdge(a, b);
				g.addEdge(b, a);
			}
			int x = s.nextInt();
			System.out.println("g ==" +g);
			System.out.println(g.countNodeAtLevel(x));
		}
	}

	int countNodeAtLevel(int x) {
		boolean visited[] = new boolean[n +1];
		Queue<Integer> queue = new LinkedList<Integer>();
		int s = 1, level = 2, count = 0;
		visited[s] = true;
		queue.add(s);
		queue.add(-1);
		while (!queue.isEmpty()) {
			s = queue.poll();
//			System.out.println(s + " " + level);
			if(level >x) {
				break;
			}
			if (s == -1) {
				level++;
				continue;
			}
			LinkedList<Integer> list = G[s];
			for (Integer l : list) {
				if (!visited[l]) {
					if(level == x) {
						count ++;
					}
					visited[l] = true;
					queue.add(l);
				}
			}
			queue.add(-1);
		}
		return count;
	}
}
