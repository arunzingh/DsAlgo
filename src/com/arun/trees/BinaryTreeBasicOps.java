package com.arun.trees;


public class BinaryTreeBasicOps {
	
	int getSize(TreeNode root) {
		
		if (root == null)
			return 0;
		
		return getSize(root.left) + 1 + getSize(root.right);
	}
	
	boolean isSame(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		
		if (root1 != null && root2 != null){
			return root1.data == root2.data 
					&& isSame(root1.left, root2.left) 
					&& isSame(root1.right, root2.right);
		}
		
		return false;
	}
	
	int getMaxDepth(TreeNode root) {
		
		if (root == null)
			return 0;
		
		int ldepth = getMaxDepth(root.left);
		int rdepth = getMaxDepth(root.right);
				
		int depth = Math.max(ldepth, rdepth);		
		
		return depth + 1;
	}
	
	void changeToMirrorTree(TreeNode root) {
		if (root == null)
			return;
		
		changeToMirrorTree(root.left);
		changeToMirrorTree(root.right);
		
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
	}
	
	void travereInorder(TreeNode root) {
		if (root == null) return;
		
		travereInorder(root.left);
		System.out.print(root.data + " ");
		travereInorder(root.right);
	}
	
	void printPathsToLeaf(TreeNode root) {
		int[] path = new int[100];
		int length = 0;
		printPathsRecur(root, path, length);
	}
	
	
	
	private void printPathsRecur(TreeNode root, int[] path, int length) {
		if (root == null) return;
		
		path[length++] = root.data;
		
		if (root.left == null && root.right == null) {
			for (int i = 0; i < length; i++) {
				System.out.print(path[i] + " ");
			}
			System.out.println("");
			return;
		} 

		printPathsRecur(root.left, path, length);
		printPathsRecur(root.right, path, length);
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
		
		BinaryTreeBasicOps ops = new BinaryTreeBasicOps();
		System.out.println(ops.getSize(root));
		
		TreeNode root1 = new TreeNode(10);
		root1.left = new TreeNode(8);
		root1.left.left = new TreeNode(3);
		root1.left.right = new TreeNode(5);
		
		root1.right = new TreeNode(2);
		root1.right.left = new TreeNode(2);
		
		System.out.println("is same = " + ops.isSame(root, root));
		
		System.out.println("max depth = " + ops.getMaxDepth(root1));
		
//		ops.changeToMirrorTree(root);
		
		ops.travereInorder(root);
		System.out.println("Paths to leaf");
		ops.printPathsToLeaf(root);
	}
}
