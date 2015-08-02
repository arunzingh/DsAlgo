package com.arun.trees;

public class ClosestLeaf {
	
	int findClosestLeaf(TreeNode root, TreeNode k) {
		TreeNode[] ancestors = new TreeNode[50];
		return findClosestLeafUtil(root, k, ancestors, 0);
	}
	
	int findClosestLeafUtil(TreeNode root, TreeNode k, TreeNode[] ancestors, int index) {
		if (root == null) return 9999;
		
		if (root == k) {
			
			int r1 = closestDown(root);
			
			for (int i = index-1; i >= 0; i--) {
				r1 = Math.min(r1, index - i + closestDown(ancestors[i]));
			}
			
			return r1;
		}
		
		ancestors[index] = root;
		return Math.min(findClosestLeafUtil(root.left, k, ancestors, index+1),
				findClosestLeafUtil(root.right, k, ancestors, index+1));
	}
	
	int closestDown(TreeNode node) {
		if (node == null) return 9999;
		
		if (node.left == null && node.right == null) return 0;
		
		return 1 + Math.min(closestDown(node.left), closestDown(node.right));
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode n1 = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = n1;
		
		n1.left = new TreeNode(5);
		n1.right = new TreeNode(6);
		n1.right.right = new TreeNode(8);
		n1.right.right.left = new TreeNode(11);
		
		n1.left.left = new TreeNode(7);
		n1.left.left.left = new TreeNode(9);
		n1.left.left.right = new TreeNode(10);
		
		ClosestLeaf l = new ClosestLeaf();
		System.out.println(l.findClosestLeaf(root, n1.right.right));
		System.out.println(l.findClosestLeaf(root, n1));
		System.out.println(l.findClosestLeaf(root, n1.left));
		System.out.println(l.findClosestLeaf(root, root.left));

	}
	
}
