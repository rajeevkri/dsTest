package com.test.hackerearth.graph;

import java.util.LinkedList;
import java.util.List;

public class WeightedGraph {
	class Edge {
		int v, w;

		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Edge [v=" + v + ", w=" + w + "]";
		}
		
	}
	List<Edge> G[];

	public WeightedGraph(int n /** n is size of graph */) {
		super();
		G =  new LinkedList[n];
		for(int i=0; i<n;i++) {
			G[i] =  new LinkedList<>();
		}
 	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for( int i = 0; i< G.length; i ++)
			result.append(i + " ==> " + G[i] + "\n");
		return result.toString();
	}
	
	void addEdge(int u, int v, int w) {
		G[u].add(0, new Edge(v, w));
	}
	boolean isConnected(int u, int v) {
		for(Edge e : G[u]) {
			if(e.v == v) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		WeightedGraph g = new WeightedGraph(10);
		g.addEdge(0, 2, 5);
		g.addEdge(0, 5, 10);
		g.addEdge(2, 2, 5);
		System.out.println(g);
	}
}
