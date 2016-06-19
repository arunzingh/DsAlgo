package com.arun.trees;

/**
 * 
 * Maximum of below three 
 *  (a) Diameter of current [left subtree ht + 1 + right subtree ht]
 *  (b) Diameter of left subtree
 *  (c) Diameter of right subtree
 *  
 * @author Arun
 *
 */
public class Diameter {
	
	class Result {
		int height = 0;
		int diameter = 0;
	}
	
	Result getDiameter(TreeNode root) {
		
		if (root == null) return new Result(); 
		
		Result resLeft = getDiameter(root.left);
		Result resRight = getDiameter(root.right);
		
		Result res = new Result();
		res.height = 1 + Math.max(resLeft.height, resRight.height);
		
		int diameter = resLeft.height + 1 + resRight.height;
		res.diameter = Math.max(diameter, Math.max(resLeft.diameter, resRight.diameter));
		
		return res;
	}
	


	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode c1 = new TreeNode(2);
		TreeNode c2 = new TreeNode(3);

		TreeNode c3 = new TreeNode(5);
		c3.left = new TreeNode(7);
		c3.right = new TreeNode(8);

		c1.left = new TreeNode(4);
		c1.right = c3;

		root.left = c1;
		root.right = c2;

		c2.right = new TreeNode(6);

		TreeNode n1 = new TreeNode(9);
		n1.left = new TreeNode(10);
		n1.right = new TreeNode(11);
		n1.left.left = new TreeNode(12);
		n1.left.right = new TreeNode(13);

		c2.right.right = n1;

		Diameter d = new Diameter();
		
		BTreePrinter.printNode(root);
		Result res = d.getDiameter(root);
		System.out.println(res.diameter);
	}
}
