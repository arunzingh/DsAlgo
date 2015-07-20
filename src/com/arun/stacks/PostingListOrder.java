package com.arun.stacks;

import java.util.Stack;

import com.arun.linkedlist.Node;

public class PostingListOrder {
	void orderRecursive(Node n) {
		orderRecursiveHelper(n, 0);
	}
	
	void orderRecursiveHelper(Node n, int order) {
		if (n != null && n.order == -1) {
			n.order = order++;
			System.out.println("Node = " + n.data + " order = " + n.order);
			orderRecursiveHelper(n.random, order);
			orderRecursiveHelper(n.next, order);
		}
	}
	
	void orderIterative(Node n) {
		Stack<Node> stack = new Stack<Node>();
		
		stack.push(n);
		int listOrder = 0;
		while (!stack.isEmpty()) {
			
			Node top = stack.pop();
			
			if (top != null && top.order == -1) {
				top.order = listOrder++;
				System.out.println("I Node = " + top.data + " order = " + top.order);
				stack.push(top.random);
				stack.push(top.next);
			}
			
		}
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		Node n1 = new Node(2);
		Node n2 = new Node(3);
		Node n3 = new Node(4);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		head.random = n2;
		n1.random = n3;
		n2.random = n1;
		
//		new PostingListOrder().orderRecursive(head);

		new PostingListOrder().orderIterative(head);
}
}
