package com.arun.linkedlist;

public class RemoveKthNodeFromEnd {
	Node remove(Node head, int k) {
		Node ptrSlow = head;
		Node ptrFast = head;
		
		int i = 0;
		
		while (i < k) {
			if (ptrFast.next == null) {
				System.out.println("List length is less than " + k);
				return null;
			}
			ptrFast = ptrFast.next;
			i++;
		}

		Node prev = null;
		while (ptrFast != null) {
			ptrFast = ptrFast.next;
			prev = ptrSlow;
			ptrSlow = ptrSlow.next;
		}
		
		prev.next = ptrSlow.next;
		
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
		
		RemoveKthNodeFromEnd re = new RemoveKthNodeFromEnd();
		Node result = re.remove(head, 11);
		
		Utils.printList(result);
	}
}
