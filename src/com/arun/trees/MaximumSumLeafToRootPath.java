package com.arun.trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MaximumSumLeafToRootPath {
	
	class Result {
		List<TreeNode> path;
		int maxSum;
		
		public Result(int sum) {
			path = new ArrayList<TreeNode>();
			maxSum = sum;
		}
	}
	
	Result maxSumLeafToRootPath(TreeNode root, int sum) {
		
		if (root == null) return new Result(0);
		
		if (root.left == null && root.right == null) {
			Result res = new Result(sum + root.data);
			res.path = new ArrayList<TreeNode>();
			res.path.add(root);
			return res;
		}
		
		Result ldata = maxSumLeafToRootPath(root.left, sum + root.data);
		Result rdata = maxSumLeafToRootPath(root.right, sum + root.data);
		
		Result res;
		if (ldata.maxSum > rdata.maxSum) {
			res = new Result(ldata.maxSum);
			res.path = ldata.path;
		} else {
			res = new Result(rdata.maxSum);
			res.path = rdata.path;
		}
		res.path.add(root);
		return res;
	}
	
	
	void printMaxSumAndPath(TreeNode node) {
		TreeNode[] targetLeaf = {null} ;
		// 0 - has max sum so far
		int[] sum = new int[1];
		
		printMaxSumAndPathUtil(node, targetLeaf, sum, 0);
		System.out.println("Max sum = " + sum[0]);
		System.out.println("Target leaf = " + targetLeaf[0].data);
		printPath(node, targetLeaf);
	}
	
	private boolean printPath(TreeNode n, TreeNode[] targetLeaf) {
		if (n == null) return false;
		
		if (n == targetLeaf[0] || printPath(n.left, targetLeaf) || printPath(n.right, targetLeaf)) {
			System.out.print(n.data + " -> ");
			return true;
		}
		
		return false;
	}

	private void printMaxSumAndPathUtil(TreeNode node, TreeNode[] targetLeaf,
			int[] sum, int currSum) {
		
		if (node == null) return;
		
		currSum += node.data;
		 
		 if (node.left == null && node.right == null) {
			 if (currSum > sum[0]) {
				 targetLeaf[0] = node;
				 sum[0] = currSum;
			 }
		 }
		 
		 printMaxSumAndPathUtil(node.left, targetLeaf, sum, currSum);
		 printMaxSumAndPathUtil(node.right, targetLeaf, sum, currSum);
	}

	int findMaxSumLeafToRoot(TreeNode node) {
		
		// base case 1
		if (node == null) 
			return 0;
		
		// base case 2
		if (node.left == null && node.left == null) 
			return node.data;
		
		
		int left = findMaxSumLeafToRoot(node.left);
		int right = findMaxSumLeafToRoot(node.right);
		
		return Math.max(left, right) + node.data;
	}
	
	
	public static void main(String[] args) {
//		TreeNode n1 = new TreeNode(10);
//		n1.left = new TreeNode(-2);
//		n1.right = new TreeNode(7);
//		n1.left.left = new TreeNode(8);
//		n1.left.right = new TreeNode(-4);
		
		MaximumSumLeafToRootPath max = new MaximumSumLeafToRootPath();
//		System.out.println(max.findMaxSumLeafToRoot(n1));
		
		TreeNode root = new TreeNode(1);
		TreeNode n1 = new TreeNode(-1);
		root.left = n1;
		root.right = new TreeNode(11);
		root.right.left = new TreeNode(21);
		root.right.right = new TreeNode(6);
		n1.left = new TreeNode(-2);
		n1.right = new TreeNode(-3);
		n1.right.right = new TreeNode(5);
		
//		System.out.println(max.findMaxSumLeafToRoot(root));

//		max.printMaxSumAndPath(root);
		BTreePrinter.printNode(root);
		List<TreeNode> path = new ArrayList<TreeNode>();
		Result res = max.maxSumLeafToRootPath(root, 0);
		System.out.println(res.maxSum);
		
		Iterator<TreeNode> it = res.path.iterator();
		
		while (it.hasNext()) {
			TreeNode n = it.next();
			System.out.print(n.data + " ");
		}
	}
}
