package com.arun.trees;


public class RemoveNodeOnLeafPathK {
	TreeNode removeNode(TreeNode node, int length, int k) {
		if (node == null) return null;
		
		node.left = removeNode(node.left, length+1, k);
		node.right = removeNode(node.right, length+1, k);
		
		if (node.left == null && node.right == null && length < k) {
			node = null;
			return node;
		} 
		
		return node;
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		root.left = n1;
		root.right = n2;
		
		n1.left = new TreeNode(4);
		n1.right = new TreeNode(5);
		
		n1.left.left = new TreeNode(7);
		
		n2.right = new TreeNode(3);
		n2.right.right = new TreeNode(6);
		n2.right.right.left = new TreeNode(8);
		
		RemoveNodeOnLeafPathK rk = new RemoveNodeOnLeafPathK();
		TreeNode result = rk.removeNode(root, 1, 4);
		
		new Inorder().traverseRecursive(result);
		
	}
}
