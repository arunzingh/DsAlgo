package com.arun.trees;

import java.util.ArrayList;
import java.util.List;

public class PathSumNBst {
	
	private List<Integer> paths = new ArrayList<>();
	private final static int MAX = 100;
	
	
	public void printPathSum(TreeNode root, int N) {
		int[] path = new int[MAX];
		int[] result = new int[1];
		printPathSumUtil(root, N, path, 0, result);
	}
	
	private void printPathSumUtil(TreeNode root, int N, int path[], int level, int[] result) {
		
		if (root == null) return;
		
		path[level] = root.data;
		int counter = level;
		int sum = 0;
		while(counter >=0 && sum < N) {
			sum += path[counter];
			counter--;
		}
		
		if (sum == N) {
			// found a path
			System.out.println("Found path starting from " + path[counter+1] + " ending at " + root.data);
			result[0]++;
		}
		
		printPathSumUtil(root.left, N, path, level+1, result);
		printPathSumUtil(root.right, N, path, level+1, result);
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(4);
		root.left.right.right = new TreeNode(7);
		
		root.right = new TreeNode(10);
		root.right.right = new TreeNode(14);
		root.right.right.left = new TreeNode(13);
		
		new BTreePrinter().printNode(root);
		
		PathSumNBst path = new PathSumNBst();
		path.printPathSum(root, 13);
		
	}
	
	class NodeInfo {
		int pathSum;
		int value;
	}
}
