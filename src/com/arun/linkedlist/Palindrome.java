package com.arun.linkedlist;

import java.util.Stack;

public class Palindrome {
	
	boolean check(Node head) {
		
		Node slow = head;
		Node fast = head;
		Stack<Integer> stack = new Stack<Integer>();
		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
			
		}
		System.out.println("stack = " + stack.toString());
		if (fast != null) {
			// length is odd
			slow = slow.next;
		}
		
		while (slow != null) {
			
			if (slow.data != stack.pop())
				return false;
			slow = slow.next;
		}
		
		return true;
	}
	
	
	boolean check1(Node head) {
		
		Node slow = head;
		Node fast = head;
		Node revStart = null;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		Node mid = slow;
		System.out.println("mid = " + mid.data + " mid_next = " + mid.next.data);
		Node rev = new ReverseList().reverse(slow);
		Node revHead = rev;
		System.out.println("Reversed second half");
		Utils.printList(rev);
		
		slow = head;
		
		while (slow != mid) {
			if (slow.data != rev.data)
				return false;
			
			slow = slow.next;
			rev = rev.next;
		}
		Node reset = new ReverseList().reverse(revHead);
		System.out.println("reset");
		Utils.printList(reset);
 
		mid.next = reset.next;
		Utils.printList(head);
		return true;

	}
	

	
	public static void main(String[] args) {
		Node head = new Node(0);
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(2);
		Node n5 = new Node(1);
		Node n6 = new Node(5);
//		Node n7 = new Node(7);
//		Node n8 = new Node(8);
//		Node n9 = new Node(9);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6; 
//		n6.next = n7;
//		n7.next = n8;
//		n8.next = n9;
		
		Utils.printList(head);
		
		Palindrome pa = new Palindrome();
		boolean result = pa.check1(head);
		
		System.out.println("result = " + result);
		
	}

}
