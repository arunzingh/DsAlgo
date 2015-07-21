package com.arun.trees;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


public class LevelOrder {
	void traverse(TreeNode root) {
		TreeNode curr = root;
		
		Queue<TreeNode> q = new ConcurrentLinkedQueue<TreeNode>();
		
		while (curr != null) {
			System.out.print(curr.data + " ");
			if (curr.left != null) q.add(curr.left);
			if (curr.right != null) q.add(curr.right);
			
			curr = q.poll();
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
		
		new LevelOrder().traverse(root);
	}
}
