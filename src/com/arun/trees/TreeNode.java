package com.arun.trees;

public class TreeNode<T> {
	public int data;
	public TreeNode left;
	public TreeNode right;
	public TreeNode next;
	public int hd;
	
	public TreeNode(int data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return String.valueOf(data);
	}
}
