package com.arun.trees;


public class Maximum {
	int findMaximum(TreeNode node) {
		
		if (node == null) return 0;
		
		int maxLeft = findMaximum(node.left);
		int maxRight = findMaximum(node.right);
		
		return Math.max(node.data, Math.max(maxLeft, maxRight));
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode n1 = new TreeNode(7);
		TreeNode n2 = new TreeNode(5);
		root.left = n1;
		root.right = n2;
		
		n1.right = new TreeNode(6);
		n1.right.left = new TreeNode(1);
		n1.right.right = new TreeNode(11);
		
		n2.right = new TreeNode(9);
		n2.right.left = new TreeNode(4);
		
		
		Maximum max = new Maximum();
		
		System.out.println(max.findMaximum(root));
		
	}
}
