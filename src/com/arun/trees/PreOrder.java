package com.arun.trees;

import java.util.Stack;

public class PreOrder {
	
	void traverseRecursive(TreeNode root) {
		if (root == null) return;
		
		System.out.print(root.data + " ");
		traverseRecursive(root.left);
		traverseRecursive(root.right);
	}
	
	void traverseIterative(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();

		s.push(root);
		while (!s.isEmpty()) {
			TreeNode n = s.pop();
			System.out.print(n.data + " ");
			if (n.right != null) s.push(n.right);
			if (n.left != null) s.push(n.left);
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(5);
		
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(2);
		
		PreOrder pre = new PreOrder();
		
		System.out.println("Recursive");
		pre.traverseRecursive(root);
		System.out.println("");
		System.out.println("Iterative");
		pre.traverseIterative(root);
	}
	
}
