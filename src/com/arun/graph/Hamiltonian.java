package com.arun.graph;

public class Hamiltonian {
	 
	 
	private boolean isSafeToAdd(Graph g, int[] path, int pathIndex, int v) {
 
		if (g.adjMatrix[path[pathIndex-1]][v] == 0)
			return false;
 
 
		for (int i = 0; i < pathIndex; i++) {
			if (path[i] == v)
				return false;
		}
 
 
		return true;
	}
 
	private boolean checkForHamCycleUtil(Graph g, int[] path, int pathIndex) {
 
		if (pathIndex == g.countVertex) {
			if (g.adjMatrix[path[pathIndex - 1]][0] != 0)
				return true;
			else 
				return false;
 
		}
 
		for (int v = 1; v < path.length; v++) {
			if (isSafeToAdd(g, path, pathIndex, v)) {
				path[pathIndex] = v;
 
				if (checkForHamCycleUtil(g, path, pathIndex + 1))
					return true;
 
				path[pathIndex] = -1;
			}
		}
 
		return false;
	}
 
	void checkForHamiltonianCycle(Graph g) {
 
		int[] path = new int[g.countVertex];
		for (int i = 0; i < path.length; i++) {
			path[i] = -1;
		}
		int pathIndex = 0;
 
		path[pathIndex] = g.listVertex[0].index;
 
		if (checkForHamCycleUtil(g, path, pathIndex + 1)) {
			printHamCycle(path);
			System.out.println("Hamiltonian cycle exists");
			return;
		}
 
 
		System.out.println("Hamiltonian cycle does not exist");
	}
 
	private void printHamCycle(int[] path) {
		for (int i = 0; i < path.length; i++) {
			System.out.print(path[i] + " ");
		}
	}
 
	public static void main(String[] args) {
		Graph g = new Graph(5, false);
		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 3);
		g.addEdge(1, 2);
		g.addEdge(1, 4);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
//		g.printAdjMatrix();
		Hamiltonian ham = new Hamiltonian();
		ham.checkForHamiltonianCycle(g);
 
 
	}
}
