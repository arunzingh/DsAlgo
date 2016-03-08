package com.arun.trees;

import java.util.Stack;

public class InOrder {
	
	void doMorrisTraversal(TreeNode root) {
		TreeNode curr = root;
		
		while (curr != null) {
			if (curr.left == null) {
				System.out.print(curr.data + " ");
				curr = curr.right;
			} else {
				// find inorder predecessor
				TreeNode pre = curr.left;
				while (pre.right != null && pre.right != curr) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = curr;
					curr = curr.left;
				} else {
					pre.right = null;
					System.out.print(curr.data + " ");
					curr = curr.right;
				}
			}
		}
	}
	
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
	
	
	void doInorderIterative(TreeNode root) {
		TreeNode curr = root;
		Stack<TreeNode> s = new Stack<TreeNode>();

		while (curr != null || !s.isEmpty()) {
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
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(5);
		
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(12);
		
		InOrder in = new InOrder();
		in.traverseRecursive(root);
		System.out.println();
//		in.traverseIterative(root);
		
//		in.doMorrisTraversal(root);
		
		System.out.println("Arun");
		in.doInorderIterative(root);
	}
}
