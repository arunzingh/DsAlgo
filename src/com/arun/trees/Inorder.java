package com.arun.trees;

import java.util.Stack;

public class InOrder {
	void traverseRecursive(TreeNode root) {
		if (root == null) return;
		
		traverseRecursive(root.left);
		System.out.print(root.data + " ");
		traverseRecursive(root.right);
	}
	
	void traverseIterative(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		if (root == null) return;
		
		TreeNode curr = root;
		while (!s.isEmpty() || curr != null) {
			
			if (curr != null) {
				s.push(curr);
				curr = curr.left;
			} else {
				TreeNode n = s.pop();
				System.out.print(n.data + " ");
				curr = n.right;
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(5);
		
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(2);
		
		InOrder in = new InOrder();
		in.traverseRecursive(root);
		System.out.println();
		in.traverseIterative(root);
	}
}
