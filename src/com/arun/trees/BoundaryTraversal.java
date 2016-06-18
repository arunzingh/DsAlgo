package com.arun.trees;

public class BoundaryTraversal {
	
	public void doBoundaryTraversal(TreeNode root) {
		if (root == null) return;
		
		System.out.print(root.data + " ");
		
		printLeftBorder(root.left);
		
		printLeaves(root.left);
		printLeaves(root.right);
		
		printRightBorder(root.right);
	}
	
	
	
	
	private void printRightBorder(TreeNode root) {
		if (root == null) return;
		
		if (root.right != null) {
			printRightBorder(root.right);
			System.out.print(root.data + " ");
		} else if (root.left != null) {
			printRightBorder(root.left);
			System.out.print(root.data + " ");
		}
	}

	private void printLeaves(TreeNode root) {
		if (root == null) return;
		
		if (root.left == null && root.right == null)
			System.out.print(root.data + " ");
		
		printLeaves(root.left);
		printLeaves(root.right);
	}
	
	private void printLeftBorder(TreeNode root) {
		if (root == null) return;
		
		if (root.left != null) {
			System.out.print(root.data + " ");
			printLeftBorder(root.left);
		} else if (root.right != null) {
			System.out.print(root.data + " ");
			printLeftBorder(root.right);
		}
	}
	
	public static void main(String[] args) {
	        TreeNode root = new TreeNode(20);
	        root.left = new TreeNode(8);
	        root.left.left = new TreeNode(4);
	        root.left.right = new TreeNode(12);
	        root.left.right.left = new TreeNode(10);
	        root.left.right.right = new TreeNode(14);
	        root.right = new TreeNode(22);
	        root.right.right = new TreeNode(25);
	        new BoundaryTraversal().doBoundaryTraversal(root);
	 
	}
}
