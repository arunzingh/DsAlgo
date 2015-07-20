package com.arun.trees;

import java.util.Stack;

public class Inorder {
	
	void traverse(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode curr = root;
		
		while (!s.isEmpty() || curr != null) {
			
			if (curr != null) {
				s.push(curr);
				curr = curr.left;
			} else {
				curr = s.pop();
				System.out.print(curr.data + " ");
				curr = curr.right;
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode c1 = new TreeNode(2);
		TreeNode c2 = new TreeNode(3);
		root.left = c1;
		root.right = c2;
		c1.left = new TreeNode(4);
		c1.right = new TreeNode(5);
		c2.left = new TreeNode(6);
		c2.right = new TreeNode(7);
		
		Inorder in = new Inorder();
		in.traverse(root);
		
	}
}
