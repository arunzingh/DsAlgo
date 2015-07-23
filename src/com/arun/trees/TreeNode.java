package com.arun.trees;

public class TreeNode {
	public int data;
	public TreeNode left;
	public TreeNode right;
	public int hd;
	
	public TreeNode(int data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return String.valueOf(data);
	}
}
