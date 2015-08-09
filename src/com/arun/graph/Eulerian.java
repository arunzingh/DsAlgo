package com.arun.graph;

public class Eulerian {
	
	
	void isEulerian(Graph g) {
		int res = isEulerianUtil(g);
		
	    if (res == 0)
	        System.out.println("Graph is not Eulerian");
	    else if (res == 1)
	    	System.out.println("Graph has a Euler path");
	    else
	    	System.out.println("Graph has a Euler cycle");
	}
	
	// 0 - Not Eulerian
	// 1 - Semi Eulerian
	// 2 - Eulerian
	int isEulerianUtil(Graph g) {
		
		if (isConnected(g) == false) 
			return 0;
		
		int oddVertices = 0;
		
		for (int u = 0; u < g.countVertex; u++) {
			if (g.adjList[u].size() % 2 != 0)
				oddVertices++;
		}
		
		if (oddVertices > 2) {
			return 0;
		}
		
		if (oddVertices == 0) 
			return 2;
		else 
			return 1;
		
	}

	private boolean isConnected(Graph g) {
		int u;
		for (u = 0; u < g.countVertex; u++) {
			if (g.adjList[u].size() > 0)
				break;
		}
		
		if (u == g.countVertex)
			return true;
		
		dfsUtil(g, u);
		
		for (u = 0; u < g.countVertex; u++) {
			if (g.adjList[u].size() > 0 && !g.listVertex[u].visited) {
				return false;
			}
		}
		
		return true;
	}

	private void dfsUtil(Graph g, int u) {
		g.listVertex[u].visited = true;
		
		for (int v = 0; v < g.countVertex; v++) {
			if (g.adjMatrix[u][v] != 0 && !g.listVertex[v].visited)
				dfsUtil(g, v);
		}
	}
	
	public static void main(String[] args) {
		
		Eulerian eu = new Eulerian();
		
		Graph g1 = new Graph(5, false);
	    g1.addEdge(1, 0);
	    g1.addEdge(0, 2);
	    g1.addEdge(2, 1);
	    g1.addEdge(0, 3);
	    g1.addEdge(3, 4);
	    eu.isEulerian(g1);
	 
	    Graph g2 = new Graph(5, false);
	    g2.addEdge(1, 0);
	    g2.addEdge(0, 2);
	    g2.addEdge(2, 1);
	    g2.addEdge(0, 3);
	    g2.addEdge(3, 4);
	    g2.addEdge(4, 0);
	    eu.isEulerian(g2);
	 
	    Graph g3 = new Graph(5, false);
	    g3.addEdge(1, 0);
	    g3.addEdge(0, 2);
	    g3.addEdge(2, 1);
	    g3.addEdge(0, 3);
	    g3.addEdge(3, 4);
	    g3.addEdge(1, 3);
	    eu.isEulerian(g3);
	 
	    // Let us create a graph with 3 vertices
	    // connected in the form of cycle
	    Graph g4 = new Graph(3, false);
	    g4.addEdge(0, 1);
	    g4.addEdge(1, 2);
	    g4.addEdge(2, 0);
	    eu.isEulerian(g4);
	 
	    // Let us create a graph with all veritces
	    // with zero degree
	    Graph g5 = new Graph(3, false);
	    eu.isEulerian(g5);
	}
}
