package com.arun.graph;



public class Traversal {
	private final MyStack<Vertex> s = new MyStack<Vertex>();
	private final MyQueue<Vertex> q = new MyQueue<Vertex>();
	
	Graph graph;
	
	
	boolean isCyclic(Graph g) {
		boolean[] recStack = new boolean[g.countVertex];
		for (Vertex v : g.listVertex) {
			if (isCyclicUtil(g, v, recStack)) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isCyclicUtil(Graph g, Vertex u, boolean[] recStack) {
		
		if (!u.visited) {
			u.visited = true;
			recStack[u.index] = true;
			for (int v = 0; v < g.countVertex; v++) {
				if (g.adjMatrix[u.index][v] == 1) {
					if (!g.listVertex[v].visited && isCyclicUtil(g, g.listVertex[v], recStack)) {
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
	
	void dfsRecursive(Graph g, Vertex v) {
		dfsRecursiveUtil(g, v);
	}
	
	void dfsRecursiveUtil(Graph g, Vertex v) {
		v.visited = true;
		System.out.print(v.label + " ");
		
		int index = v.index;
		for (int j = 0; j < g.countVertex; j++) {
			if (g.adjMatrix[index][j] == 1 && !g.listVertex[j].visited)
				dfsRecursiveUtil(g, g.listVertex[j]);
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
		System.out.println(""); 
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
		graph1.printAdjMatrix();
		System.out.println(t.isCyclic(graph2));
	}
}
