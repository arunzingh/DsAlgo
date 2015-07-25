package com.arun.graph;


public class Traversal {
	private final MyStack<Vertex> s = new MyStack<Vertex>();
	private final MyQueue<Vertex> q = new MyQueue<Vertex>();
	
	Graph graph;
	
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
		Graph graph = new Graph(8);
		
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
		t.bfs(graph, graph.listVertex[0]);
	}
}
