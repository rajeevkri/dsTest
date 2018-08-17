package com.test.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency Lists

	// Constructor
	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	public static Graph getSampleGraph() {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		return g;
	}

	public void topologicalSort() {
		boolean[] visited = new boolean[V];
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				topologicalSortUtil(i, visited, st);
			}
		}
		while (!st.empty()) {
			System.out.print(st.pop() + " ");
		}
	}

	private void topologicalSortUtil(int i, boolean[] visited, Stack<Integer> st) {
		visited[i] = true;
		Iterator<Integer> it = adj[i].iterator();
		while (it.hasNext()) {
			Integer x = it.next();
			if (!visited[x])
				topologicalSortUtil(x, visited, st);
		}
		st.push(i);
	}

	public static void main(String[] args) {
		Graph g = Graph.getSampleGraph();
		g.topologicalSort();
	}
}
