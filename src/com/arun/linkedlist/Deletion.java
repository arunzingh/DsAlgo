package com.arun.linkedlist;

public class Deletion {
	
	Node deleteAtBegin(Node head) {
		if (head == null) {
			return null;
		}
		Node node = head.next;
		return node;
	}
	
	Node deleteAtEnd(Node head) {
		if (head == null) {
			return null;
		}
		Node curr = head;
		Node prev = null;
		while (curr.next != null) {
			prev = curr;
			curr = curr.next;
		}
		prev.next = null;
		curr = null;
		
		return head;
	}
	
	Node deleteAtIndex(Node head, int i) {
		if (head == null) {
			return null;
		}
		Node curr = head;
		Node prev = null;
		int count = 0;
		while (curr.next != null) {
			if (count == i)
				break;
			prev = curr;
			curr = curr.next;
			count++;
		}
		
		prev.next = curr.next;
		curr = null;
		return head;
	}
	
	public static void main(String[] args) {
		Node head = new Node(9);
		Node n1 = new Node(8);
		Node n2 = new Node(8);
		Node n3 = new Node(0);
		Node n4 = new Node(3);
		Node n5 = new Node(4);
		Node n6 = new Node(2);
		Node n7 = new Node(9);
		Node n8 = new Node(0);
		Node n9 = new Node(4);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		
		System.out.println("Input");
		Utils.printList(head);
		
		Deletion d = new Deletion();
		System.out.println("Deleting first node");
		Utils.printList(d.deleteAtBegin(head));
		System.out.println("Deleting last node");
		Utils.printList(d.deleteAtEnd(head));
		System.out.println("Deleting at index 3");
		Utils.printList(d.deleteAtIndex(head, 3));
		
	}
}
