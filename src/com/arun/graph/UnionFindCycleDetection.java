package com.arun.graph;

public class UnionFindCycleDetection {
	 
	int[] id;
 
	public UnionFindCycleDetection(int countVertices) {
		id = new int[countVertices];
 
		for (int i = 0; i < countVertices; i++) {
			id[i] = -1;
		}
	}
 
	int find(int i) {
 
		while (id[i] != -1) {
			i = id[i];
		}
 
		return i;
	}
 
 
	boolean addEdge(int p, int q) {
 
		int i = find(p);
		int j = find(q);
		if (i == j)
			return true;
 
		id[i] = j;
		return false;
	}
	
	private void printIdArray() {
		for (int i = 0; i < id.length; i++) {
			System.out.print(id[i] + " ");
		}
	}
 
	public static void main(String[] args) {
		UnionFindCycleDetection cycle = new UnionFindCycleDetection(3);
 
		System.out.println(cycle.addEdge(0, 1));
		cycle.printIdArray();
		System.out.println(cycle.addEdge(1, 2));
		cycle.printIdArray();
		System.out.println(cycle.addEdge(0, 2));
		cycle.printIdArray();

 
 
 
//		System.out.println(cycle.isCycle());
	}


}
