package com.test.hackerearth.graph;

import java.util.LinkedList;

public class Graph {

	LinkedList<Integer> G[];

	public Graph(int n) {
		super();
		G = new LinkedList[n];
		for(int i = 0; i<n; i++) {
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
		for(Integer i: G[u]) {
			if(i == v) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(10);
		g.addEdge(0, 2);
		g.addEdge(0, 5);
		g.addEdge(2, 2);
		System.out.println(g);
	}
}
