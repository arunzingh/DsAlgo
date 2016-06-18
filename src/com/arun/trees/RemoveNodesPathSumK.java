package com.arun.trees;

public class RemoveNodesPathSumK {
	
	TreeNode removeNodesPathSumK(TreeNode root, int sum) {
		if (root == null) return null;
		
		root.left = removeNodesPathSumK(root.left, sum - root.data);
		root.right = removeNodesPathSumK(root.right, sum - root.data);
		
		
		if (root.left == null && root.right == null) {
			if (root.data < sum) return null;
		}
		
		return root;
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.left.right = new TreeNode(5);
	    root.right.left = new TreeNode(6);
	    root.right.right = new TreeNode(7);
	    root.left.left.left = new TreeNode(8);
	    root.left.left.right = new TreeNode(9);
	    root.left.right.left = new TreeNode(12);
	    root.right.right.left = new TreeNode(10);
	    root.right.right.left.right = new TreeNode(11);
	    root.left.left.right.left = new TreeNode(13);
	    root.left.left.right.right = new TreeNode(14);
	    root.left.left.right.right.left = new TreeNode(15);
	    
	    BTreePrinter.printNode(root);
	    
	    RemoveNodesPathSumK rem = new RemoveNodesPathSumK();
	    rem.removeNodesPathSumK(root, 45);
	    
	    BTreePrinter.printNode(root);
	    
	    
	}
}
