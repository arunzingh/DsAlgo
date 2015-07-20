package com.arun.linkedlist;

public class MergeSortedLists {
	
	Node merge(Node head1, Node head2) {
		Node result = null;
		Node ptrCurr = null;
		
		if (head1.data < head2.data) {
			result = head1;
			ptrCurr = result;
			head1 = head1.next;
		} else {
			result = head2;
			ptrCurr = result;
			head2 = head2.next;
		}
		
		while (head1 != null && head2 != null){
			if (head1.data < head2.data) {
				ptrCurr.next = head1;
				ptrCurr = head1;
				head1 = head1.next;
			} else {
				ptrCurr.next = head2;
				ptrCurr = head2;
				head2 = head2.next;
			}
		}
		
		if (head1 == null) {
			ptrCurr.next = head2;
		}
		
		if (head2 == null) {
			ptrCurr.next = head1;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Node head1 = new Node(5);
		Node n1 = new Node(10);
		Node n2 = new Node(15);
		Node n3 = new Node(20);
		head1.next = n1;
		n1.next = n2;
		n2.next = n3;
		
		
		Node head2 = new Node(3);
		Node n4 = new Node(6);
		Node n5 = new Node(19);
		head2.next = n4;
		n4.next = n5;
		
		Utils.printList(head1);
		Utils.printList(head2);
		
		MergeSortedLists merger = new MergeSortedLists();
		Node result = merger.merge(head1, head2);
		Utils.printList(result);
	}
	
	
}
