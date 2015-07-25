package com.arun.trees;

import com.arun.linkedlist.Node;
import com.arun.linkedlist.Utils;

public class TreeToDoublyLL {
	
	static Node prev = null;
	static Node head = null;
	Node convertTreeToDoublyLL(TreeNode node) {
		if (node == null) return null;
		
		convertTreeToDoublyLL(node.left);
		Node n = new Node(node.data);
		
		if (prev == null) {
			head = n;
		} else {
			prev.next = n;
			n.prev = prev;
		}
		prev = n;
		
		convertTreeToDoublyLL(node.right);
//		Utils.printList(n);
		return head;
		
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode n1 = new TreeNode(12);
		TreeNode n2 = new TreeNode(15);
		root.left = n1;
		root.right = n2;
		n1.left = new TreeNode(25);
		n1.right = new TreeNode(30);
		n2.left = new TreeNode(36);
		
		TreeToDoublyLL ll = new TreeToDoublyLL();
		Node result = ll.convertTreeToDoublyLL(root);
		
		Utils.printList(result);
	}
}
