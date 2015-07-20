package com.arun.trees;

public class Diameter {

	int getDiameter(TreeNode root) {
		if (root == null)
			return 0;

		int lht = getHeight(root.left);
		int rht = getHeight(root.right);

		int rootd = lht + 1 + rht;
		int ld = getDiameter(root.left);
		int rd = getDiameter(root.right);
		
		System.out.println("root=" + root.data + " lht=" + lht + " rht=" + rht
				+ " ld=" + ld + " rd=" + rd);

		return Math.max(rootd, Math.max(ld, rd));
	}

	int getHeight(TreeNode root) {
		if (root == null)
			return 0;

		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

	int[] getDiameter1(TreeNode root) {
		
		int result[] = {0, 0}; // 0 - diameter , 1 - height
		
		if (root == null) return result;
		
		
		int[] leftResult = getDiameter1(root.left);
		int[] rightResult = getDiameter1(root.right);
		
		int height = 1 + Math.max(leftResult[1], rightResult[1]);
		
		int rootd = leftResult[1] + rightResult[1] + 1;
		int ld = leftResult[0];
		int rd = rightResult[0];
		
		result[0] = Math.max(rootd, Math.max(ld, rd));
		result[1] = height;
		
		return result;
		
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
		System.out.println(d.getDiameter(root));

	}
}
