package com.arun.graph;

/**
 * INITIALIZE-SINGLE_SOURCE(G, s)
 * 	S = {}
 * 	Q = V[G]
 * 	
 * 	while (Q is not empty) {
 * 		u = extract-Min(Q)
 * 		S = S U {u}
 * 		for each vertex v -> adj[u]
 * 			relax (u, v, w)
 *  }
 * @author Arun
 *
 */
public class Dijkstra {

	void findShortestPath(Graph g, Vertex source) {
		
		// Holds the shortest distance from 
		// source vertex to ith vertex
		int[] dist = new int[g.countVertex];
		
		// if set means that vertex i is included in the 
		// shortest path tree
		boolean[] shortestPathSet = new boolean[g.countVertex];
		
		for (int i = 0; i < g.countVertex; i++) {
			dist[i] = Integer.MAX_VALUE;
			shortestPathSet[i] = false;
		}
		
		// Init the distance to source vertex as 0
		dist[source.index] = 0;
		
		
		for (int i = 0; i < g.countVertex; i++) {
			Vertex u = extractMinDistanceVertex(g, dist, shortestPathSet);
			
			shortestPathSet[u.index] = true;
			
			for (Vertex v : g.listVertex) {
				if (!shortestPathSet[v.index]
						&& g.isConnected(u.index, v.index)
						&& dist[v.index] > dist[u.index]+ g.adjMatrix[u.index][v.index]) {
					dist[v.index] = dist[u.index]+ g.adjMatrix[u.index][v.index];
				}
			}
			
		}
		
		printSolution(g, dist);
		
	}

	private void printSolution(Graph g, int[] dist) {
		for (int i = 0; i < g.listVertex.length; i++) {
			System.out.println(g.listVertex[i].index + " " + dist[i]);
		}
	}

	private Vertex extractMinDistanceVertex(Graph g, int[] dist, boolean[] shortestPathSet) {
		
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		for (int i = 0; i < dist.length; i++) {
			if (!shortestPathSet[i] && dist[i] <= min) {
				min = dist[i];
				minIndex = i;
			}
			
		}
		return g.listVertex[minIndex];
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph(9, false);
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 7, 8);	
		graph.addEdge(1, 2, 8);
		graph.addEdge(1, 7, 11);
		graph.addEdge(7, 8, 7);
		graph.addEdge(7, 6, 1);
		graph.addEdge(2, 8, 2);
		graph.addEdge(8, 6, 6);
		graph.addEdge(2, 3, 7);
		graph.addEdge(2, 5, 4);
		graph.addEdge(6, 5, 2);
		graph.addEdge(5, 4, 10);
		graph.addEdge(3, 4, 9);
		
		Dijkstra d = new Dijkstra();
		d.findShortestPath(graph, graph.listVertex[0]);
	}
}
