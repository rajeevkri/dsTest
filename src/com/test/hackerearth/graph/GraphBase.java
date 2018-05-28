package com.test.hackerearth.graph;

/**
 * You have been given an undirected graph consisting of N nodes and M edges.
 * This graph can consist of self-loops as well as multiple edges. In addition ,
 * you have also been given Q queries. For each query , you shall be given 2
 * integers A and B. You just need to find if there exists an edge between node
 * A and node B. If yes, print "YES" (without quotes) else , print "NO"(without
 * quotes).
 * 
 * Input Format:
 * 
 * The first line consist of 2 integers N and M denoting the number of nodes and
 * edges respectively. Each of the next M lines consist of 2 integers A and B
 * denoting an undirected edge between node A and B. The next line contains a
 * single integer Q denoting the number of queries. The next Line contains 2
 * integers A and B denoting the details of the query.
 * 
 * Output Format
 * 
 * Print Q lines, the answer to each query on a new line.
 * 
 * Constraints:
 * 
 * 
 * 
 * 
 * 
 * 
 * @author srajeev
 *
 */

//import for Scanner and other utility classes
import java.util.*;

public class GraphBase {

	public static void main(String[] args) {
		// Scanner
		Scanner s = new Scanner(System.in);
		if(s.hasNext()) {
			String n = s.next();// Number of nodes
			String m = s.next();// Number of edges
			// Initialize graph with all false values
			boolean[][] graph = new boolean[Integer.valueOf(n) + 1][Integer.valueOf(n) + 1];

			// populating graph value to true for mapped values
			for (int i = 1; i <= Integer.valueOf(m); i++) {
				int a = s.nextInt();
				int b = s.nextInt();
				graph[a][b] = true;
				graph[b][a] = true;
			}
			int q = s.nextInt();
			for (int i = 1; i <= q; i++) {
				int a = s.nextInt();
				int b = s.nextInt();
				if (graph[a][b] == true && graph[b][a] == true) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
			s.close();
		}
	}

}
