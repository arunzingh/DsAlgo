package com.arun.practise;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class HrDagSolution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	
    	Graph g = new Graph(N, true);
    	
    	for (int count = 0; count < M; count++) {
    		int u = sc.nextInt();
    		int v = sc.nextInt();
    		g.addEdge(u-1, v-1);
		}
    	
//    	g.printAdjMatrix();
    	int[] count = {0};
    	int result = 0;
    	
    	Stack<Vertex> stack = new Stack<Vertex>();
    	
    	for (Vertex u : g.listVertex) {
//    		dfsUtil(g, u, count);
//    		System.out.println("Vertex u=" + u.index + " count=" + count[0]);
    		dfsUtil(g, stack, u, count);
    		
    		if (count[0] * 2 >= N) result++;
    		count[0] = 0;
    		g.reset();
		}
    	
    	System.out.println(result);
    }

	private static void dfsUtil(Graph g, Stack<Vertex> stack, Vertex u,
			int[] count) {
		
		u.visited = true;
		stack.push(u);
		count[0]++;
		
		while (!stack.isEmpty()) {
			Vertex adjacent = g.getAdjUnvisitedVertex(stack.peek());
			if (adjacent != null) {
				adjacent.visited = true;
				stack.push(adjacent);
				count[0]++;
			} else {
				stack.pop();
			}
		}
	}

	private static void dfsUtil(Graph g, Vertex u, int[] count) {
		u.visited = true;
		count[0]++;
		
		for (Vertex v : g.listVertex) {
			if (g.adjMatrix[u.index][v.index] == 1 && !v.visited)
				dfsUtil(g, v, count);
		}
	}
}


class Graph {
	
	private final String[] LABELS = { "A", "B", "C", "D", "E", "F", "G", 
			"H", "I", "J", "K", "L", "K", "M"};
	int countVertex;
	int[][] adjMatrix;
	Vertex[] listVertex;
	boolean mIsDirected;
	
	public Graph(int count, boolean isDirected) {
		countVertex = count;
		adjMatrix = new int[countVertex][countVertex];
		listVertex = new Vertex[countVertex]; 
		mIsDirected = isDirected;
		for (int i = 0; i < countVertex; i++) {
			listVertex[i] = new Vertex(i, LABELS[i]);
		}
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
	
	void reset() {
		for (int i = 0; i < countVertex; i++) {
			listVertex[i].visited = false;
		}
	}
	
	public void addEdge(int i, int j){
		if (i >=0 && i < countVertex && j >= 0 && j < countVertex) {
			adjMatrix[i][j] = 1;
			if (!mIsDirected) adjMatrix[j][i] = 1;
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

