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
			adj[i] = new LinkedList<Integer>();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	public static Graph getSampleGraph() {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(1, 0);
		g.addEdge(0, 2);
//		g.addEdge(1, 2);
//		g.addEdge(2, 1);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 2);
//		g.addEdge(3, 3);
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
		System.out.println(g.isCyclic());
	}

	// Find cycle in undirected graph
	public boolean isCyclic() {
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				if (isCyclicUtil(i, visited, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isCyclicUtil(int current, boolean[] visited, int parent) {
		visited[current] = true;
		Iterator<Integer> it = adj[current].iterator();
		int i;
		while (it.hasNext()) {
			i = it.next();
			if (!visited[i]) {
				if (isCyclicUtil(i, visited, current)) {
					return true;
				}
			} else if (i != parent) {
				return true;
			}
		}
		return false;
	}
}
