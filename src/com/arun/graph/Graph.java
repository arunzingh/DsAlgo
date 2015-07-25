package com.arun.graph;

public class Graph {
	
	private final String[] LABELS = { "A", "B", "C", "D", "E", "F", "G", 
			"H", "I", "J", "K", "L", "K", "M"};
	int countVertex;
	int[][] adjMatrix;
	Vertex[] listVertex;
	
	public Graph(int count) {
		countVertex = count;
		adjMatrix = new int[countVertex][countVertex];
		listVertex = new Vertex[countVertex]; 
		
		for (int i = 0; i < count; i++) {
			listVertex[i] = new Vertex(i, LABELS[i]);
		}
	}
	
	public void addEdge(int i, int j){
		if (i >=0 && i < countVertex && j >= 0 && j < countVertex) {
			adjMatrix[i][j] = 1;
			adjMatrix[j][i] = 1;
		}
	}
	
	void printAdjMatrix() {
		for (int i = 0; i < countVertex; i++) {
			for (int j = 0; j < countVertex; j++) {
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	public boolean isConnected(int i, int j) {
		if (i >=0 && i < countVertex && j >= 0 && j < countVertex) {
			return adjMatrix[i][j] == 1;
		}
		return false;
	}

	public Vertex getAdjUnvisitedVertex(Vertex v) {
//		System.out.println("adj un vertex = " + v.index);
		int index = v.index;
		for (int j = 0; j < countVertex; j++) {
			if (adjMatrix[index][j] == 1 && listVertex[j].visited == false)
				return listVertex[j];
		}
		return null;
	}
	
}

class Vertex {
	int index;
	String label;
	boolean visited;
	
	public Vertex(int index, String label) {
		this.index = index;
		this.label = label;
	}
}