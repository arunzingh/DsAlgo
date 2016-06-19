package com.arun.trees;

public class SumTree {

	class Result {
		boolean isSumTree;
		int data;

		public Result(boolean isSum, int value) {
			this.isSumTree = isSum;
			this.data = value;
		}
	}

	Result checkSumTree(TreeNode root) {

		if (root == null)
			return new Result(true, 0);
		if (root.left == null && root.right == null)
			return new Result(true, root.data);

		Result resLeft = checkSumTree(root.left);
		Result resRight = checkSumTree(root.right);

		if (!resLeft.isSumTree 
				|| !resRight.isSumTree
				|| root.data != resLeft.data + resRight.data)
			return new Result(false, 0);

		Result result = new Result(true, root.data * 2);
		return result;
	}
	
	private int convertToSumTree(TreeNode root) {
		if (root == null) return 0;
		
		if (root.left == null && root.right == null) {
			int old = root.data;
			root.data = 0;
			return old;
		}
		
		int ldata = convertToSumTree(root.left);
		int rdata = convertToSumTree(root.right);
		int old = root.data;
		root.data = ldata + rdata;
		
		return root.data + old;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(26);
		root.left = new TreeNode(10);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(6);
		root.right.right = new TreeNode(3);

		SumTree s = new SumTree();

		Result res = s.checkSumTree(root);
		System.out.println(res.isSumTree);

		/* Constructing tree given in the above figure */
		TreeNode root1 = new TreeNode(10);
		root1.left = new TreeNode(-2);
		root1.right = new TreeNode(6);
		root1.left.left = new TreeNode(8);
		root1.left.right = new TreeNode(-4);
		root1.right.left = new TreeNode(7);
		root1.right.right = new TreeNode(5);
		
		Result res1 = s.checkSumTree(root1);
		System.out.println(res1.isSumTree);
		
		BTreePrinter.printNode(root1);
		
		s.convertToSumTree(root1);
		BTreePrinter.printNode(root1);

	}
}
