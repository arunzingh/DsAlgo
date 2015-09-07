package com.arun.graph;

public class FloydWarshall {
	 
	void findAllPairShortestPath(Graph g) {
 
		for (int k = 0; k < g.countVertex; k++) {
			for (int i = 0; i < g.countVertex; i++) {
				for (int j = 0; j < g.countVertex; j++) {
					if (g.adjMatrix[i][j] > g.adjMatrix[i][k] + g.adjMatrix[k][j]) {
						g.adjMatrix[i][j] = g.adjMatrix[i][k] + g.adjMatrix[k][j];
					}
				} 
			}
		}
	}
 
	public static void main(String[] args) {
		Graph g = new Graph(4, true);
		g.initEdgesMax();
//		g.printAdjMatrix();
		g.addEdge(0, 1, 5);
		g.addEdge(1, 2, 3);
		g.addEdge(2, 3, 1);
		g.addEdge(0, 3, 10);
//		g.printAdjMatrix();
 
		FloydWarshall fw = new FloydWarshall();
 
		fw.findAllPairShortestPath(g);
		g.printAdjMatrix();
	}
}