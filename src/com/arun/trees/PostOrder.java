package com.arun.trees;

import java.util.Stack;


public class PostOrder {
	
	void traverseRecursive(TreeNode root) {
		
		if (root == null) return;
		
		traverseRecursive(root.left);
		traverseRecursive(root.right);
		System.out.print(root.data + " ");
	}
	
	void traverseIterative2(TreeNode root) {
		
		TreeNode curr = root;
		Stack<TreeNode> s = new Stack<TreeNode>();
		
		while (true) {
			if (curr != null) {
				if (curr.right != null)  s.push(curr.right);
				s.push(curr);
				curr = curr.left;
				continue;
			}    

			if(s.isEmpty()) break;
			
			curr = s.pop();
			if (curr.right != null && !s.isEmpty()
					&& s.peek() == curr.right) {
				s.pop();
				s.push(curr);
				curr = curr.right;
			} else {
				System.out.print(curr.data + " ");
				curr = null;
			}
		}
	}
	
	void traverseIterative1(TreeNode root) {
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		
		s1.push(root);
		
		while (!s1.isEmpty()) {
			TreeNode n1 = s1.pop();
			s2.push(n1);
			if (n1.left != null) s1.push(n1.left);
			if (n1.right != null) s1.push(n1.right);
			
			System.out.print("s1 = " + s1);
			System.out.print(" s2 = " + s2);
			System.out.println("");
		}
		
		while (!s2.isEmpty()) {
			System.out.print(s2.pop().data + " ");
		}
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode n1 = new TreeNode(-1);
		root.left = n1;
		root.right = new TreeNode(11);
		root.right.left = new TreeNode(21);
		root.right.right = new TreeNode(6);
		n1.left = new TreeNode(-2);
		n1.right = new TreeNode(-3);
		n1.right.right = new TreeNode(5);
		
		PostOrder po = new PostOrder();
//		po.traverseRecursive(root);
		po.traverseIterative1(root);
	}
}
