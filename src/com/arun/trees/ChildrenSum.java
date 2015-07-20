package com.arun.trees;


public class ChildrenSum {
	 
	boolean checkChildSum(TreeNode root) {
		if (root == null 
				|| root.left == null && root.right == null) return true;
		
		int ldata = root.left != null ? root.left.data : 0;
		int rdata = root.right != null ? root.right.data : 0;
		int sumChild = ldata + rdata;
		
		if (root.data != sumChild) {
			return false;
		} else if (root.data == sumChild) {
			return checkChildSum(root.left) && checkChildSum(root.right);
		}
		return false; 
	}
	
	void convert(TreeNode root) {
		
		if (root == null 
				|| (root.left == null && root.right == null))
				return;
		
		convert(root.left);
		convert(root.right);
		
		int ldata = root.left != null ? root.left.data : 0;
		int rdata = root.right != null ? root.right.data : 0;
		int sumChild = ldata + rdata;
		int diff = sumChild - root.data;

		if (diff == 0) {
			return;
		} else if (diff > 0) {
			root.data = root.data + diff;
		} else {
			increment(root, -diff);
		}
		
	}
	
	void increment(TreeNode root, int diff) {
		
		if (root.left != null) {
			root.left.data += diff;
			increment(root.left, diff);
		} else if (root.right != null){
			root.right.data += diff;
			increment(root.right, diff);
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode n1 = new TreeNode(8);
		TreeNode n2 = new TreeNode(2);
		root.left = n1;
		root.right = n2;
		n1.left = new TreeNode(3);
		n1.right = new TreeNode(5);
		n2.left = new TreeNode(2);
		
		ChildrenSum cs = new ChildrenSum();
		
		System.out.println(cs.checkChildSum(root));
		
		TreeNode root1 = new TreeNode(50);
		TreeNode c1 = new TreeNode(7);
		TreeNode c2 = new TreeNode(2);
		root1.left = c1;
		root1.right = c2;
		c1.left = new TreeNode(3);
		c1.right = new TreeNode(5);
		c2.left = new TreeNode(1);
		c2.right = new TreeNode(30);
		
		cs.convert(root1);
		
		new Inorder().traverse(root1);
		
	}
}
