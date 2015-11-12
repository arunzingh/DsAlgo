package com.arun.graph;

import java.util.LinkedList;
import java.util.List;

public class Graph {
	
	private final String[] LABELS = { "A", "B", "C", "D", "E", "F", "G", 
			"H", "I", "J", "K", "L", "K", "M"};
	int countVertex;
	int[][] adjMatrix;
	Vertex[] listVertex;
	boolean mIsDirected;
	
	List[] adjList;
	
	public Graph(int count, boolean isDirected) {
		countVertex = count;
		adjMatrix = new int[countVertex][countVertex];
		adjList = new LinkedList[countVertex];
		listVertex = new Vertex[countVertex]; 
		mIsDirected = isDirected;
		for (int i = 0; i < countVertex; i++) {
			listVertex[i] = new Vertex(i, LABELS[i]);
			adjList[i] = new LinkedList<Vertex>();
		}
	}
	
	void reset() {
		for (int i = 0; i < countVertex; i++) {
			listVertex[i].visited = false;
		}
	}
	
	public void addEdge(int i, int j, int w){
		if (i >=0 && i < countVertex && j >= 0 && j < countVertex) {
			adjMatrix[i][j] = w;
			if (!mIsDirected) adjMatrix[j][i] = w;
		}
	}
	
	public void addEdge(int i, int j){
		if (i >=0 && i < countVertex && j >= 0 && j < countVertex) {
			adjMatrix[i][j] = 1;
			if (!mIsDirected) adjMatrix[j][i] = 1;
			adjList[i].add(listVertex[j]);
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
			return adjMatrix[i][j] != 0 ;
		}
		return false;
	}

	public Vertex getAdjUnvisitedVertex(Vertex vertex) {
//		System.out.println("adj un vertex = " + v.index);
		int u = vertex.index;
		for (int v = 0; v < countVertex; v++) {
			if (adjMatrix[u][v] == 1 && listVertex[v].visited == false)
				return listVertex[v];
		}
		return null;
	}
	
	Graph getTranspose() {
		Graph gt = new Graph(this.countVertex, this.mIsDirected);
		for (int u = 0; u < countVertex; u++) {
			for (int v = 0; v < countVertex; v++) {
				if (this.adjMatrix[u][v] != 0) {
					gt.adjMatrix[v][u] = this.adjMatrix[u][v];
				}
			}
		}
		
		return gt;
	}

	public void initEdgesMax() {
		for (int u = 0; u < countVertex; u++) {
			for (int v = 0; v < countVertex; v++) {
				adjMatrix[u][v] = 9999;
			}
		}
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
	
	@Override
	public String toString() {
		return index + " -> " + visited;
	}
}