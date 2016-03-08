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
	
	void printSpiralForm(TreeNode root) {
		
		if (root == null) return;
		
		System.out.print(root.data + ", ");
	}
	
	public static void main(String[] args) {
//		TreeNode root = new TreeNode(1);
//		TreeNode n1 = new TreeNode(-1);
//		root.left = n1;
//		root.right = new TreeNode(11);
//		root.right.left = new TreeNode(21);
//		root.right.right = new TreeNode(6);
//		n1.left = new TreeNode(-2);
//		n1.right = new TreeNode(-3);
//		n1.right.right = new TreeNode(5);
		
		
		TreeNode root = new TreeNode<Integer>(1);

		root.left = new TreeNode<Integer>(2);
		root.right = new TreeNode<Integer>(3);

		root.left.left = new TreeNode<Integer>(4);
		root.left.right = new TreeNode<Integer>(5);
		root.right.left = new TreeNode<Integer>(6);
		root.right.right = new TreeNode<Integer>(7);

		root.left.left.left = new TreeNode<Integer>(8);
		root.left.left.right = new TreeNode<Integer>(9);
		root.left.right.left = new TreeNode<Integer>(10);
		root.left.right.right = new TreeNode<Integer>(11);
		root.right.left.left = new TreeNode<Integer>(12);
		root.right.left.right = new TreeNode<Integer>(13);
		root.right.right.left = new TreeNode<Integer>(14);
		root.right.right.right = new TreeNode<Integer>(15);

		root.left.left.left.left = new TreeNode<Integer>(16);
		root.left.left.left.right = new TreeNode<Integer>(17);
		root.left.left.right.left = new TreeNode<Integer>(18);
		root.left.left.right.right = new TreeNode<Integer>(19);
		root.left.right.left.left = new TreeNode<Integer>(20);
		root.left.right.left.right = new TreeNode<Integer>(21);
		root.left.right.right.left = new TreeNode<Integer>(22);
		root.left.right.right.right = new TreeNode<Integer>(23);
		root.right.left.left.left = new TreeNode<Integer>(24);
		root.right.left.left.right = new TreeNode<Integer>(25);
		root.right.left.right.left = new TreeNode<Integer>(26);
		root.right.left.right.right = new TreeNode<Integer>(27);
		root.right.right.left.left = new TreeNode<Integer>(28);
		root.right.right.left.right = new TreeNode<Integer>(29);
		root.right.right.right.left = new TreeNode<Integer>(30);
		root.right.right.right.right = new TreeNode<Integer>(31);
		
//		new LevelOrder().traverse(root);
		
		BTreePrinter.printNode(root);
	}
}
