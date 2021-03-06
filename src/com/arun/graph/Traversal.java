package com.arun.graph;

public class Traversal {
	private final MyStack<Vertex> s = new MyStack<Vertex>();
	private final MyQueue<Vertex> q = new MyQueue<Vertex>();
	
	Graph graph;
	
	/**
	 * Method to find whether the given directed graph has cycle or not
	 * it uses dfs traversal and detects cycle if there exists a back edge
	 * 
	 * 
	 * @param g
	 * @return
	 */
	boolean isCyclicDirected(Graph g) {
		boolean[] recStack = new boolean[g.countVertex];
		for (Vertex u : g.listVertex) {
			if (isCyclicDirectedUtil(g, u, recStack)) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isCyclicDirectedUtil(Graph g, Vertex u, boolean[] recStack) {
		
		if (!u.visited) {
			u.visited = true;
			recStack[u.index] = true;
			for (int v = 0; v < g.countVertex; v++) {
				if (g.adjMatrix[u.index][v] == 1) {
					if (!g.listVertex[v].visited) {
						if (isCyclicDirectedUtil(g, g.listVertex[v], recStack))
							return true;
					} else if (recStack[v]) {
						return true;
					}
				}
			}
		}
		recStack[u.index] = false;
		return false;
	}

	void topologicalSort(Graph g) {
		
		this.graph = g;
		
		MyStack<Vertex> topOrderStack = new MyStack<Vertex>();
		for (Vertex v : g.listVertex) {
			if (!v.visited) 
				topologicalSortUtil(g, v, topOrderStack);
		}
		while (!topOrderStack.isEmpty()) {
			System.out.print(topOrderStack.pop().index + " ");
		}
	}
	
	private void topologicalSortUtil(Graph g, Vertex v, MyStack<Vertex> topOrderStack) {
		
		MyStack<Vertex> dfsStack = new MyStack<Vertex>();
//		System.out.println("visiting = " + v.index);
		v.visited = true;
		dfsStack.push(v);
		
		while (!dfsStack.isEmpty()) {
			Vertex nextVertex = g.getAdjUnvisitedVertex(dfsStack.peek());
			if (nextVertex != null) {
//				System.out.println("visiting = " + nextVertex.index);
				nextVertex.visited = true;
				dfsStack.push(nextVertex);
			} else {
				Vertex finished = dfsStack.pop();
//				System.out.println("Finished = " + finished.index);
				topOrderStack.push(finished);
			}
		}
	}

	void bfs(Graph g, Vertex root) {
		this.graph = g;
		
		root.visited = true;
		System.out.print(root.label + " ");
		q.add(root);
		
		while (!q.isEmpty()) {
			Vertex v = q.poll();
			while (g.getAdjUnvisitedVertex(v) != null) {
				Vertex adjVertex = g.getAdjUnvisitedVertex(v);
				adjVertex.visited = true;
				System.out.print(adjVertex.label + " ");
				q.add(adjVertex);
			}
		}
	}
	
	void dfsRecursive(Graph g, Vertex u) {
		dfsRecursiveUtil(g, u);
	}
	
	void dfsRecursiveUtil(Graph g, Vertex u) {
		u.visited = true;
		System.out.print(u.label + " ");
		
		int indexU = u.index;
		for (int v = 0; v < g.countVertex; v++) {
			if (g.adjMatrix[indexU][v] == 1 && !g.listVertex[v].visited)
				dfsRecursiveUtil(g, g.listVertex[v]);
		}
	}
	
	void dfs(Graph g, Vertex root) {
		this.graph = g;
		root.visited = true;
		System.out.print(root.label + " ");
		s.push(root);
		
		while (!s.isEmpty()) {
			Vertex v = g.getAdjUnvisitedVertex(s.peek());
			if (v == null) {
				s.pop();
			} else {
				v.visited = true;
				System.out.print(v.label+ " ");
				s.push(v);
			}
		}
	}
	
	
	
	/**
	 * Method to detect whether the given undirected graph has cycle or not
	 * It uses dfs traversal.
	 * 
	 * For every visited vertex 'v', if there is an adjacent 'u' 
	 * such that u is already visited and u is not parent of v, 
	 * then there is a cycle in graph.
	 * 
	 * 
	 * 
	 * @param g
	 * @return
	 */
	boolean isCyclicUndirected(Graph g) {
		
		for (Vertex u : g.listVertex) {
			if (!u.visited)
				if (isCyclicUndirectedUtil(g, u, null))
					return true;
		}
		
		return false;
	}
	
	
	private boolean isCyclicUndirectedUtil(Graph g, Vertex u, Vertex parent) {
		u.visited = true;
		for (Vertex v : g.listVertex) {
			if (g.adjMatrix[u.index][v.index] == 1) {
				if (!v.visited) {
					if (isCyclicUndirectedUtil(g, v, u))
						return true;
				} else if (parent != null && v.index != parent.index)
					return true;
			}
			
		}
		return false;
	}

	public static void main(String[] args) {
		Graph graph = new Graph(8, false);
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 7);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);
		graph.addEdge(4, 7);
//		graph.printAdjMatrix();
		Traversal t = new Traversal();
//		t.dfs(graph, graph.listVertex[0]);
		graph.reset();
//		System.out.println(""); 
//		t.dfsRecursive(graph, graph.listVertex[0]);
		
//		t.bfs(graph, graph.listVertex[0]);
		Graph graph1 = new Graph(6, true);
		
		graph1.addEdge(5, 0);
		graph1.addEdge(5, 2);
		graph1.addEdge(4, 0);
		graph1.addEdge(4, 1);
		graph1.addEdge(2, 3);
		graph1.addEdge(3, 1);
		
//		t.topologicalSort(graph1);
		
		Graph graph2 = new Graph(4, true);
		graph2.addEdge(0, 1);
		graph2.addEdge(0, 2);
		graph2.addEdge(2, 0);
		graph2.addEdge(1, 2);
		graph2.addEdge(2, 3);
		graph2.addEdge(3, 3);
//		graph1.printAdjMatrix();
//		System.out.println(t.isCyclic(graph2));
		
		Graph g3 = new Graph(5, false);
		g3.addEdge(1, 0);
		g3.addEdge(0, 2);
		g3.addEdge(2, 0);
		g3.addEdge(0, 3);
		g3.addEdge(3, 4);
		
		System.out.println("isCyclic = " + t.isCyclicDirected(g3));
		
		Graph g4 = new Graph(3, false);
	    g4.addEdge(0, 1);
	    g4.addEdge(1, 2);
		System.out.println("isCyclic = " + t.isCyclicDirected(g4));
		
		
		Graph g5 = new Graph(5, false);
		g5.addEdge(1, 0);
		g5.addEdge(0, 2);
		g5.addEdge(2, 1);
		g5.addEdge(0, 3);
		g5.addEdge(3, 4);
		System.out.println("g5 isCyclic = " + t.isCyclicUndirected(g5));
		
		Graph g6 = new Graph(3, false);
		g6.addEdge(0, 1);
	    g6.addEdge(1, 2);
	    System.out.println("g6 isCyclic = " + t.isCyclicUndirected(g6));


	}
}
