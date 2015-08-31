package com.arun.graph;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FordFulkerson {
	 
	boolean bfsUtil(Graph g, Vertex source, Vertex sink, int[] parent) {
		Queue<Vertex> q = new ConcurrentLinkedQueue<Vertex>();
 
		// Mark all vertices as unvisited
		for (int i = 0; i < g.countVertex; i++) {
			g.listVertex[i].visited = false;
		}
 
		// start with the source vertex
		source.visited = true; 
		q.add(source);
 
		// Parent of source vertex is -1
		parent[source.index] = -1;
 
 		while (!q.isEmpty()) {
 
			Vertex u = q.poll();
 
			for (int v = 0; v < g.countVertex; v++) {
				if (g.adjMatrix[u.index][v] > 0 && !g.listVertex[v].visited) {
					g.listVertex[v].visited = true;
					q.add(g.listVertex[v]);
					parent[v] = u.index;
				}
			}
		}
 
		return sink.visited == true;
 
	}
 
	int findMaxFlow(Graph g) {
 
		// Create a residual graph
		Graph gResidual = new Graph(g.countVertex, g.mIsDirected);
 
		// Init the residual graph with residual capacities same
		// as original capacity
		for (int i = 0; i < g.countVertex; i++) {
			for (int j = 0; j < g.countVertex; j++) {
				gResidual.adjMatrix[i][j] = g.adjMatrix[i][j];
			}
		}
 
		int[] parent = new int[gResidual.countVertex];
		int maxFlow = 0;
		Vertex source = gResidual.listVertex[0];
		Vertex sink = gResidual.listVertex[gResidual.countVertex - 1];
 
		while (bfsUtil(gResidual, source, sink, parent)) {
			// find bottleneck capacity
			int bottleneckCapacity = Integer.MAX_VALUE;
 
			for (int v = sink.index; v != source.index; v = parent[v]) {
				int u = parent[v];
				bottleneckCapacity = Math.min(bottleneckCapacity, gResidual.adjMatrix[u][v]);
			}
 
			// Update residual capacities
			for (int v = sink.index; v != source.index; v = parent[v]) {
				int u = parent[v];
				gResidual.adjMatrix[u][v] -= bottleneckCapacity;
				gResidual.adjMatrix[v][u] += bottleneckCapacity;
			}
 
			maxFlow += bottleneckCapacity;
		}
 
		return maxFlow;
	}
 
 
	public static void main(String[] args) {
		Graph g = new Graph(6, true);
		g.addEdge(0, 1, 16);
		g.addEdge(0, 2, 13);
		g.addEdge(1, 2, 10);
		g.addEdge(2, 1, 4);
		g.addEdge(1, 3, 12);
		g.addEdge(3, 2, 9);
		g.addEdge(2, 4, 14);
		g.addEdge(4, 3, 7);
		g.addEdge(3, 5, 20);
		g.addEdge(4, 5, 4);
 
		FordFulkerson ff = new FordFulkerson();
		System.out.println("The maximum possible flow is " + ff.findMaxFlow(g));
	}
}
