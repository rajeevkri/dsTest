package com.test.graph;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class GraphOperations {

	public void dfs(int adjacency_matrix[][], int source) {
		Stack<Integer> stack = new Stack<Integer>();
		int number_of_nodes = adjacency_matrix[source].length;

		int visited[] = new int[number_of_nodes + 1];
		int element = source;
		int i = source;
		System.out.print(element + "\t");
		visited[source] = 1;
		stack.push(source);

		while (!stack.isEmpty()) {
			element = stack.peek();
			i = element;
			while (i <= number_of_nodes) {
				if (adjacency_matrix[element][i] == 1 && visited[i] == 0) {
					stack.push(i);
					visited[i] = 1;
					element = i;
					i = 1;
					System.out.print(element + "\t");
					continue;
				}
				i++;
			}
			stack.pop();
		}
	}

	public void bfs(int adjacency_matrix[][], int source) {
		Queue<Integer> queue = new LinkedList<>();
		int numberOfNodes = adjacency_matrix[source].length;
		int[] visited = new int[numberOfNodes];

		visited[source] = 1;
		queue.add(source);
		int i, element;

		while (!queue.isEmpty()) {
			element = queue.poll();

			i = element;
			System.out.print(i + "\t");

			while (i < numberOfNodes) {
				if (adjacency_matrix[element][i] == 1 && visited[i] == 0) {
					queue.add(i);
					visited[i] = 1;
				}

				i++;
			}
		}
	}

	public static void main(String... arg) {
		int number_no_nodes, source;
		Scanner scanner = null;

		try {
			System.out.println("Enter the number of nodes in the graph");
			scanner = new Scanner(System.in);
			number_no_nodes = scanner.nextInt();

			int adjacency_matrix[][] = new int[number_no_nodes][number_no_nodes];
			System.out.println("Enter the adjacency matrix");
			for (int i = 0; i < number_no_nodes; i++)
				for (int j = 0; j < number_no_nodes; j++)
					adjacency_matrix[i][j] = scanner.nextInt();

			System.out.println("Enter the source for the graph");
			source = scanner.nextInt();

			GraphOperations ops = new GraphOperations();
			System.out.println("The BFS traversal of the graph is ");
			ops.bfs(adjacency_matrix, source);
			System.out.println();
			System.out.println("The DFS traversal of the graph is ");
			ops.dfs(adjacency_matrix, source);

		} catch (InputMismatchException inputMismatch) {
			System.out.println("Wrong Input Format");
		}
		scanner.close();
	}
	/**
	 * Give input like this
Enter the number of nodes in the graph
4
Enter the adjacency matrix
0 1 0 1
0 0 1 0
0 1 0 1
0 0 0 1
Enter the source for the graph
1
The BFS traversal of the graph is 
1	2	4	3
	 */
}
