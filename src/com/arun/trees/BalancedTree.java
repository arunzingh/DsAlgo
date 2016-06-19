package com.arun.trees;

/**
 * How to determine if a binary tree is height-balanced?
 * 
 * left subtree is balanced
 * right subtree is balanced
 * diff between left subtree ht and right subtree ht is atmost 1
 * 
 * @author Arun
 *
 */
public class BalancedTree {
	class Result {
		boolean isBalanced;
		int height;
		
		
		public Result() {
		}
		
		public Result(boolean isBalanced, int height) {
			this.isBalanced = isBalanced;
			this.height = height;
		}
	}
	
	public Result isHeightBalanced(TreeNode root) {
		if (root == null) 
			return new Result(true, 0);
		
		Result left = isHeightBalanced(root.left);
		Result right = isHeightBalanced(root.right);
		
		Result res = new Result();
		int diff = Math.abs(left.height-right.height);
		res.height = 1 + Math.max(left.height, right.height);

		if (!left.isBalanced 
				|| !right.isBalanced 
				|| diff > 1) {
			res.isBalanced = false;
		} else {
			res.isBalanced = true;
		}
			
		return res;
		
	}
	
	public static void main(String[] args) {
		BalancedTree bt = new BalancedTree();
		
        TreeNode rootNotBalanced = new TreeNode(1);
        rootNotBalanced.left = new TreeNode(2);
        rootNotBalanced.right = new TreeNode(3);
        rootNotBalanced.left.left = new TreeNode(4);
        rootNotBalanced.left.right = new TreeNode(5);
        rootNotBalanced.left.left.left = new TreeNode(8);
        
        
        
        TreeNode rootBalanced = new TreeNode(1);  
        rootBalanced.left = new TreeNode(2);
        rootBalanced.right = new TreeNode(3);
        rootBalanced.left.left = new TreeNode(4);
        rootBalanced.left.right = new TreeNode(5);
        rootBalanced.right.left = new TreeNode(6);
        rootBalanced.left.left.left = new TreeNode(7);
        
        BTreePrinter.printNode(rootBalanced);
        
        System.out.println("balanced=" + bt.isHeightBalanced(rootBalanced).isBalanced);
        
        BTreePrinter.printNode(rootNotBalanced);

        
        System.out.println("balanced=" + bt.isHeightBalanced(rootNotBalanced).isBalanced);

	}
}
