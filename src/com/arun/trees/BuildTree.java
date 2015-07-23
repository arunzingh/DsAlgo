package com.arun.trees;

import com.arun.linkedlist.Node;
import com.arun.linkedlist.Utils;

/**
 * BST Tree Builder from 
 * 
 * 	1 - Inorder
 *  2 - Inorder + preorder
 *  3 - sorted array
 *  4 - sorted linked list
 * @author Arun
 *
 */
public class BuildTree {
	static Node curr;
	
	TreeNode fromSortedLL(Node head) {
		int length = Utils.getLength(head);
		curr = head;
		return fromSortedLLUtil(0, length - 1);
	}
	
	TreeNode fromSortedLLUtil(int left, int right) {
		if (left > right) return null;
		
		int mid = left + (right - left) / 2;
		System.out.println("mid = " + mid);
		TreeNode lNode = fromSortedLLUtil(left, mid - 1);  
		System.out.println("parent = " + curr.data);
		TreeNode parent = new TreeNode(curr.data);
		curr = curr.next;
		TreeNode rNode = fromSortedLLUtil(mid + 1, right);
		
		parent.left = lNode;
		parent.right = rNode;
		if (lNode != null) System.out.println("left = " + lNode.data);
		else System.out.println("left is null");
		
		if (rNode != null) System.out.println("right = " + rNode.data);
		else System.out.println("right is null");
		return parent;
		
	}
	
	
	TreeNode fromSortedArray(int[] arr) {
		return fromSortedArrUtil(arr, 0, arr.length - 1);
	}
	
	TreeNode fromSortedArrUtil(int[] arr, int left, int right) {
		if (left > right) return null;
		 
		int mid = left + (right - left) / 2;
//		System.out.println("l= " + left + " r= " + right + " mid= " + mid);	
		TreeNode n = new TreeNode(arr[mid]);
//		System.out.println("node= " + n.data);
		n.left = fromSortedArrUtil(arr, left, mid - 1);
//		if (n.left != null) 
//			System.out.println("left = " + n.left.data);
//		else 
//			System.out.println("null to left");
		n.right = fromSortedArrUtil(arr, mid + 1, right);
//		if (n.left != null) 
//			System.out.println("right = " + n.right.data);
//		else 
//			System.out.println("null to right");
		return n;
		
	}
	
	
	TreeNode fromInorderPreOrder(int[] in, int[] pre) {

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
	
	TreeNode fromInorder(int[] in, int left, int right) {
		if (left > right) return null;
		
		int index = searchMax(in, left, right);
		
		TreeNode node = new TreeNode(in[index]);
		
		if (left == right) {
			return node;
		}

		node.left = fromInorder(in, left, index - 1);
		node.right = fromInorder(in, index + 1, right); 
		
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
		TreeNode result = tree.fromInorder(inorder, 0, inorder.length - 1);
//		new InOrder().traverseRecursive(result);
		
		int in[] = {4, 2, 5, 1, 6, 3};
		int pre[] = {1, 2, 4, 5, 3, 6};
		
		TreeNode result1 = tree.fromInorderPreOrder(in, pre);
//		new InOrder().traverseRecursive(result1);
		
		int[] arr = {1, 2, 3, 4, 5, 6};
		
//		TreeNode result2 = tree.fromSortedArray(arr);
//		new PreOrder().traverseRecursive(result2);
		
		Node head = new Node(1);
		Node n1 = new Node(2);
		Node n2 = new Node(3);
		Node n3 = new Node(4);
		Node n4 = new Node(5);
		Node n5 = new Node(6);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		TreeNode r3 = tree.fromSortedLL(head);
		new PreOrder().traverseRecursive(r3);
	}
}
