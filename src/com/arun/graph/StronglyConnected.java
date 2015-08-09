package com.arun.graph;

import java.util.Stack;

public class StronglyConnected {
	
	
	void fillOrder(Graph g, Vertex u, Stack<Vertex> s) {
		u.visited = true;
		for (int v = 0; v < g.countVertex; v++) {
			if (g.adjMatrix[u.index][v] != 0 && !g.listVertex[v].visited)
				fillOrder(g, g.listVertex[v], s);
		}
		
		s.push(u);
	}
	
	void printStronglyConnectedComponents(Graph g) {
		
		Stack<Vertex> s = new Stack<Vertex>();
		
		for (Vertex u : g.listVertex) {
			if (!u.visited) {
				fillOrder(g, u, s);
			}
		}
		Graph gt = g.getTranspose();
		while (!s.isEmpty()) {
			Vertex u = s.pop();
			if (!gt.listVertex[u.index].visited) {
				dfsUtil(gt, gt.listVertex[u.index], true);
			}
			
			System.out.println("");
		}
	}
	
	
	
	void dfsUtil(Graph g, Vertex u, boolean print) {
		u.visited = true;
		if (print) System.out.print(u.index + " ");
		for (int v = 0; v < g.countVertex; v++) {
			if (g.adjMatrix[u.index][v] != 0 && !g.listVertex[v].visited)
				dfsUtil(g, g.listVertex[v], print);
		}
	}
	
	
	boolean isStronglyConnected(Graph g) {
		
		dfsUtil(g, g.listVertex[0], false);
		
		for (int u = 0; u < g.countVertex; u++) {
			if (!g.listVertex[u].visited)
				return false;
		}
		
		Graph gt = g.getTranspose();
		
		dfsUtil(gt, gt.listVertex[0], false);
		
		for (int u = 0; u < gt.countVertex; u++) {
			if (!gt.listVertex[u].visited)
				return false;
		}
		
		
		return true;
	}
	
	public static void main(String[] args) {
		
		StronglyConnected sc = new StronglyConnected();
		
		// Create graphs given in the above diagrams
	    Graph g1 = new Graph(5, true);
	    g1.addEdge(0, 1);
	    g1.addEdge(1, 2);
	    g1.addEdge(2, 3);
	    g1.addEdge(3, 0);
	    g1.addEdge(2, 4);
	    g1.addEdge(4, 2);
//	    System.out.println(sc.isStronglyConnected(g1));
	 
	    Graph g2 = new Graph(4, true);
	    g2.addEdge(0, 1);
	    g2.addEdge(1, 2);
	    g2.addEdge(2, 3);
//	    System.out.println(sc.isStronglyConnected(g2));
	    
	    
	 // Create a graph given in the above diagram
	    Graph g = new Graph(5, true);
	    g.addEdge(1, 0);
	    g.addEdge(0, 2);
	    g.addEdge(2, 1);
	    g.addEdge(0, 3);
	    g.addEdge(3, 4);
	    
	    sc.printStronglyConnectedComponents(g);
	 
	}
	
}
