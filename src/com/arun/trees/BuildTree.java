package com.arun.trees;

public class BuildTree {
	
	
	TreeNode buildTreeFromInorderPreOrder(int[] in, int[] pre) {

		int[] preIndex = {0};
		
		return builderInorderPreOrderUtil(in, pre, 0, in.length - 1, preIndex);
	}
	
	TreeNode builderInorderPreOrderUtil(int[] in, int[] pre, int left, int right, int[] preIndex) {
		if (left > right) return null;
		
		int data = pre[preIndex[0]++];
		TreeNode node = new TreeNode(data);
		
		if (left == right) return node;
		
		int index = searchInorder(in, data, left, right);
		
		node.left = builderInorderPreOrderUtil(in, pre, left, index - 1, preIndex);
		node.right = builderInorderPreOrderUtil(in, pre, index + 1, right, preIndex);
		
		return node;
	}
	
	int searchInorder(int[] in, int data, int left, int right) {
		for (int i = left; i <= right; i++) {
			if (in[i] == data) return i;
		}
		
		return -1;
	}
	
	TreeNode buildTreeFromInorder(int[] in, int left, int right) {
		if (left > right) return null;
		
		int index = searchMax(in, left, right);
		
		TreeNode node = new TreeNode(in[index]);
		
		if (left == right) {
			return node;
		}

		node.left = buildTreeFromInorder(in, left, index - 1);
		node.right = buildTreeFromInorder(in, index + 1, right); 
		
		return node;
	}
	
	private int searchMax(int[] in, int left, int right) {
		int maxIdx = left;
		int max = in[left];
		
		for (int i = maxIdx + 1; i < right; i++) {
			if (in[i] > max) {
				max = in[i];
				maxIdx = i;
			}
		}
		return maxIdx;
	}

	public static void main(String[] args) {
		int[] inorder = {5, 10, 40, 30, 28};
		
		BuildTree tree = new BuildTree();
		TreeNode result = tree.buildTreeFromInorder(inorder, 0, inorder.length - 1);
		
		new InOrder().traverseRecursive(result);
		
		int in[] = {4, 2, 5, 1, 6, 3};
		int pre[] = {1, 2, 4, 5, 3, 6};
		
		TreeNode result1 = tree.buildTreeFromInorderPreOrder(in, pre);
		
		new InOrder().traverseRecursive(result1);

	}
}
