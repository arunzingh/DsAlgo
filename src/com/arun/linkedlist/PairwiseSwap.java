package com.arun.linkedlist;

public class PairwiseSwap {
	Node swap(Node head) {
		
		if (head == null) {
			return null;
		}
		
		Node curr = head;
		while(curr != null && curr.next != null) {
			int temp = curr.data;
			curr.data = curr.next.data;
			curr.next.data = temp;
			
			curr = curr.next.next;
		}
		
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
		Node n9 = new Node(9);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		
		Utils.printList(head);
		PairwiseSwap sw = new PairwiseSwap();
		Node result = sw.swap(head);
		Utils.printList(result);
	}
}
