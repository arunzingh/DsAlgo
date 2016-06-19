package com.arun.trees;

public class PopulateInorderSuccessor {

	/* Approach 1 - Do by reverse InOrder */
	public static TreeNode<Integer> next = null;
	public void populateInOrderSuccessor(TreeNode<Integer> node){
		if(node==null){
			return;
		}
		
		populateInOrderSuccessor(node.right);
		node.next = next;
		next = node;
		populateInOrderSuccessor(node.left);
	}
}
