package com.arun.linkedlist;

public class MergeSortedLists {
	
	Node merge(Node head1, Node head2) {
		Node resultHead = null;
		Node resultTail = null;
		
		if (head1.data < head2.data) {
			resultHead = head1;
			resultTail = resultHead;
			head1 = head1.next;
		} else {
			resultHead = head2;
			resultTail = resultHead;
			head2 = head2.next;
		}
		
		while (head1 != null && head2 != null){
			if (head1.data < head2.data) {
				resultTail.next = head1;
				resultTail = head1;
				head1 = head1.next;
			} else {
				resultTail.next = head2;
				resultTail = head2;
				head2 = head2.next;
			}
		}
		
		if (head1 == null) {
			resultTail.next = head2;
		}
		
		if (head2 == null) {
			resultTail.next = head1;
		}
		
		return resultHead;
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
