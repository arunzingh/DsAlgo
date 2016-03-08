package com.arun.graph;

public class BellmanFord {
	
	void findShortestPath(Graph g, Vertex source) {
		
		int[] dist = new int[g.countVertex];
		
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		dist[source.index] = 0;
		
		for (int count = 0; count < g.listVertex.length; count++) {
			for (Vertex u : g.listVertex) {
				for (int v = 0; v < g.countVertex; v++) {
					if (g.adjMatrix[u.index][v] != 0 && dist[v] > dist[u.index] + g.adjMatrix[u.index][v]) 
						dist[v] = dist[u.index] + g.adjMatrix[u.index][v];
				}
			}
		}
		
		
		// To detect negative weight cycle
		for (int i = 0; i < g.countVertex; i++) {
			for (int j = 0; j < g.countVertex; j++) {
				if (g.isConnected(i, j) && dist[j] > dist[i] + g.adjMatrix[i][j])
					System.out.println("Negative cycles found");
			}
		}
		
		printSolution(g, dist);
		
	}
	
	private void printSolution(Graph g, int[] dist) {
		for (int i = 0; i < g.listVertex.length; i++) {
			System.out.println(g.listVertex[i].index + " " + dist[i]);
		}
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph(5, true);
		graph.addEdge(0, 1, -1);
		graph.addEdge(0, 2, 4);	
		graph.addEdge(1, 2, 3);
		graph.addEdge(1, 3, 2);
		graph.addEdge(1, 4, 2);
		graph.addEdge(3, 2, 5);
		graph.addEdge(3, 1, 1);
		graph.addEdge(4, 3, -3);
//		graph.printAdjMatrix();
		BellmanFord bf = new BellmanFord();
		bf.findShortestPath(graph, graph.listVertex[0]);
	}
}
