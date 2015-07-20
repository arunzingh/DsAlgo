package com.arun.linkedlist;

public class ReorderEvenOdd {
	
	Node reorder(Node head) {
		Node currEven = head;
		Node currOdd = head.next;
		Node startOdd = currOdd;
		Node preEven = null;
		while (currEven != null && currOdd != null) {
			preEven = currEven;
			currEven.next = currOdd.next;
			currEven = currEven.next;
			if (currEven != null) {
				currOdd.next = currEven.next;
				currOdd = currOdd.next;
			}
		}
		
		if (currEven != null) {
			preEven = currEven; 
		}
		
		preEven.next = startOdd;
		return head;
	}
	
	public static void main(String[] args) {
		Node head = new Node(0);
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
//		Node n9 = new Node(9);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
//		n8.next = n9;
		
		Utils.printList(head);
		
		ReorderEvenOdd re = new ReorderEvenOdd();
		Node result = re.reorder(head);
		
		Utils.printList(result);
	}

}
