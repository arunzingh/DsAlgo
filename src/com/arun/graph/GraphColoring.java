package com.arun.graph;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class GraphColoring {
	
	
	// Backtracking algorithm
	// 
	void checkColoring(Graph g, int m) {
		
		int[] color = new int[g.countVertex];
		
		for (int i = 0; i < color.length; i++) {
			color[i] = -1;
		}
		
		// start with vertex 0
		if (checkColoringUtil(g, m, color, 0) == false) {
			System.out.println("Coloring does not exist");
			return;
		}
		
		for (int i = 0; i < color.length; i++) {
			System.out.println("Vertex " + i + " --> color " + color[i]);
		}
	}
	
	
	private boolean checkColoringUtil(Graph g, int m, int[] color, int u) {
		
		if (u == g.countVertex)
			return true;
		
		
		for (int c = 1; c <= m; c++) {
			if (isSafe(g, m, color, u, c)) {
				color[u] = c;
				
				if (checkColoringUtil(g, m, color, u+1))
					return true;
				
				color[u] = -1;
			}
		}
		
		return false;
		
	}


	private boolean isSafe(Graph g, int m, int[] color, int u, int c) {
		
		for (int v = 0; v < g.countVertex; v++) {
			if (g.adjMatrix[u][v] != 0 && color[v] == c) {
				return false;
			}
		}
		
		return true;
	}


	boolean isBipartite(Graph g) {
		Queue<Vertex> q = new ConcurrentLinkedQueue<Vertex>();
		
		
		int[] color = new int[g.countVertex];
		for (int i = 0; i < color.length; i++) {
			color[i] = -1;
		}
		
		color[g.listVertex[0].index] = 0;
		q.add(g.listVertex[0]);
		
		while (!q.isEmpty()) {
			Vertex u = q.poll();
			
			for (int v = 0; v < g.countVertex; v++) {
				if (g.adjMatrix[u.index][v] != 0 && color[v] == -1) {
					color[v] = 1 - color[u.index];
					q.add(g.listVertex[v]);
				} else if (g.adjMatrix[u.index][v] != 0 && color[v] == color[u.index]) {
					return false;
				}
			}
		}
		
		return true;
	}

	// Greedy algorithm
	// assign first vertex with first color
	// For remaining v-1 vertices keep assigning lowest number color which is
	// not
	// assigned to its neighbors
	void findUpperBound(Graph g) {

		int[] color = new int[g.countVertex];

		color[0] = 0;

		for (int u = 1; u < color.length; u++) {
			color[u] = -1;
		}

		boolean[] used = new boolean[g.countVertex];

		for (int u = 1; u < g.countVertex; u++) {
			for (int v = 0; v < g.countVertex; v++) {

				if (g.adjMatrix[u][v] != 0 && color[v] != -1) {
					used[color[v]] = true;
				}
			}

			int k = 0;
			for (k = 0; k < used.length; k++) {
				if (used[k] == false)
					break;
			}

			color[u] = k;

			for (int v = 0; v < g.countVertex; v++) {
				if (g.adjMatrix[u][v] != 0 && color[v] != -1) {
					used[v] = false;
				}
			}
		}

		for (int i = 0; i < color.length; i++) {
			System.out.println("Vertex " + i + " --> color " + color[i]);
		}
	}

	public static void main(String[] args) {
		Graph g1 = new Graph(5, false);
		g1.addEdge(0, 1);
		g1.addEdge(0, 2);
		g1.addEdge(1, 2);
		g1.addEdge(1, 3);
		g1.addEdge(2, 3);
		g1.addEdge(3, 4);

		GraphColoring gc = new GraphColoring();
//		gc.findUpperBound(g1);
		
		Graph g2 = new Graph(5, false);
		g2.addEdge(0, 1);
		g2.addEdge(0, 2);
		g2.addEdge(1, 2);
		g2.addEdge(1, 4);
		g2.addEdge(2, 4);
		g2.addEdge(4, 3);
//		gc.findUpperBound(g2);
		
		Graph g3 = new Graph(4, false);
		g3.addEdge(0, 1);
		g3.addEdge(0, 3);
		g3.addEdge(1, 2);
		g3.addEdge(2, 3);
		
//		System.out.println(gc.isBipartite(g3));
		
		Graph g4 = new Graph(4, false);
		g4.addEdge(0, 1);
		g4.addEdge(0, 2);
		g4.addEdge(0, 3);
		g4.addEdge(1, 2);
		g4.addEdge(2, 3);
		gc.checkColoring(g4, 3);

	}
}
