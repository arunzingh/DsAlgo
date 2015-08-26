package com.arun.graph;

public class ArticulationPoint {
	
	void findArticulationPoints(Graph g) {
		
		int[] depth = new int[g.countVertex];
		int[] low = new int[g.countVertex];
		int[] parent = new int[g.countVertex];
		boolean[] ap = new boolean[g.countVertex];
		
		for (int i = 0; i < ap.length; i++) {
			parent[i] = -1;
		}
		
		findApUtil(g, g.listVertex[0], depth, low, parent, ap, 1);
		
		for (int i = 0; i < ap.length; i++) {
			if (ap[i])
				System.out.print(i + " ");
		}
	}

	private void findApUtil(Graph g, Vertex u, int[] depth, int[] low,
			int[] parent, boolean[] ap, int d) {
		
		u.visited = true;
		
		int children = 0;
		
		depth[u.index] = low[u.index] = d;
		d++;
		
		for (Vertex v : g.listVertex) {
			if (g.adjMatrix[u.index][v.index] != 0) {
				if (!v.visited) {
					children++;
					parent[v.index] = u.index;
					
					findApUtil(g, v, depth, low, parent, ap, d);
					
					low[u.index] = Math.min(low[u.index], low[v.index]);
					
					if (parent[u.index] == -1 && children > 1) 
						ap[u.index] = true;
					
					if (parent[u.index] != -1 && low[v.index] >= depth[u.index])
						ap[u.index] = true;
					
				} else if (v.index != parent[u.index]) {
					low[u.index] = Math.min(low[u.index], depth[v.index]);
				}
			}
				
		}
	}
	
	public static void main(String[] args) {
		Graph g1 = new Graph(5, false);
		g1.addEdge(1, 0);
	    g1.addEdge(0, 2);
	    g1.addEdge(2, 1);
	    g1.addEdge(0, 3);
	    g1.addEdge(3, 4);
	    
	    ArticulationPoint ap = new ArticulationPoint();
	    ap.findArticulationPoints(g1);
	    
	    System.out.println("");
	    
	    Graph g2 = new Graph(4, false);
	    g2.addEdge(0, 1);
	    g2.addEdge(1, 2);
	    g2.addEdge(2, 3);
//	    ap.findArticulationPoints(g2);
	    
	    System.out.println("" );
	    
	    Graph g3 = new Graph(7, false);
	    g3.addEdge(0, 1);
	    g3.addEdge(1, 2);
	    g3.addEdge(2, 0);
	    g3.addEdge(1, 3);
	    g3.addEdge(1, 4);
	    g3.addEdge(1, 6);
	    g3.addEdge(3, 5);
	    g3.addEdge(4, 5);
//	    ap.findArticulationPoints(g3);
	}
}
