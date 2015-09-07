package com.arun.graph;

public class Prim {
	 
	void findMinSpanningTree(Graph g) {
		
		// key values to all vertices
		int[] key = new int[g.countVertex];
		
		boolean[] minSpanningTreeSet = new boolean[g.countVertex];
		int[] parent = new int[g.countVertex];
 
		for (int i = 0; i < g.countVertex; i++) {
			key[i] = 9999;
		}
 
		key[0] = 0;
 
 
		for (int count = 0; count < g.countVertex - 1; count++) {
 
			// Pick the vertex which has minimum key and not added to
			// min spanning tree vertex set
			Vertex u = minKey(g, key, minSpanningTreeSet);
 
			// Add to the min spanning tree vertices set
			minSpanningTreeSet[u.index] = true;
 
			for (int v = 0; v < g.countVertex; v++) {
				if (g.adjMatrix[u.index][v] != 0 
						&& !minSpanningTreeSet[v]
						&& key[v] > g.adjMatrix[u.index][v]) {
					key[v] = g.adjMatrix[u.index][v];
					parent[v] = u.index;
				}
			}
 
		}
 
		printMinSpanningTree(g, key, parent);
 
	}
 
	private void printMinSpanningTree(Graph g, int[] key, int[] parent) {
		for (int i = 1; i < key.length; i++) {
			System.out.println(parent[i] + " - " +  i  + " -> " + g.adjMatrix[i][parent[i]]);			
		}
	}
 
	private Vertex minKey(Graph g, int[] key, boolean[] minSpanningTreeSet) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i = 0; i < key.length; i++) {
			if (!minSpanningTreeSet[i] && key[i] < min) {
				min = key[i];
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
 
		Prim p = new Prim();
		p.findMinSpanningTree(graph);
	}
}
