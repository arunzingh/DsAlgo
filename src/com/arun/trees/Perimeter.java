package com.arun.trees;

public class Perimeter {
	
	void printPerimeter(TreeNode root) {
		if (root == null) return;
		
		System.out.print(root.data + " ");
		printLeftLeaves(root.left);
		
		printBottomLeaves(root.left);
		printBottomLeaves(root.right);
		
		printRightLeaves(root.right);
	}
	
	void printBottomLeaves(TreeNode node) {
		if (node == null) return;
		
		printBottomLeaves(node.left);
		
		if(node.left == null && node.right == null) {
			System.out.print(node.data + " ");
		}
		printBottomLeaves(node.right);

	}
	
	
	void printLeftLeaves(TreeNode node) {
		if (node == null) return;
		
		if (node.left != null) {
			System.out.print(node.data + " ");
			printLeftLeaves(node.left);
		} else if (node.right != null){
			System.out.print(node.data + " ");
			printLeftLeaves(node.right);
		}
	}
	
	
	void printRightLeaves(TreeNode node) {
		if (node == null) return;
		
		if (node.right != null) {
			printRightLeaves(node.right);
			System.out.print(node.data + " ");
		} else if (node.left != null){
			printRightLeaves(node.left);
			System.out.print(node.data + " ");
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode c1 = new TreeNode(2);
		TreeNode c2 = new TreeNode(3);

		TreeNode c3 = new TreeNode(5);
		c3.left = new TreeNode(7);
		c3.right = new TreeNode(8);

		c1.left = new TreeNode(4);
		c1.right = c3;

		root.left = c1;
		root.right = c2;

		c2.right = new TreeNode(6);

		TreeNode n1 = new TreeNode(9);
		n1.left = new TreeNode(10);
		n1.right = new TreeNode(11);
		n1.left.left = new TreeNode(12);
		n1.left.right = new TreeNode(13);

		c2.right.right = n1;
		
		Perimeter p = new Perimeter();
		p.printPerimeter(root);
		
	}
}
