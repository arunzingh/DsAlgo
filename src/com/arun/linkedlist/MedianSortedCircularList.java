package com.arun.linkedlist;

public class MedianSortedCircularList {
	
	int findMedian(Node node) {
		
		Node curr = node.next;
		int length = 0;
		Node startNode = curr;
		while(curr != node) {
			length++;
			curr = curr.next;
			if (curr.data < startNode.data) {
				startNode = curr;
			}
		}
		System.out.println("length = " + length + " start = " + startNode.data);
		
		curr = startNode;
		for (int i=0; i < length/2; i++) {
			curr = curr.next;
		}
			
		
		if (length % 2 == 0) {
			//length is even so median is avg of middle two nodes
			return (curr.data + curr.next.data) / 2;
		} else {
			return curr.data;
		}
	}
	public static void main(String[] args) {
		Node head = new Node(15);
		Node n1 = new Node(17);
		Node n2 = new Node(21);
		Node n3 = new Node(23);
		Node n4 = new Node(3);
		Node n5 = new Node(4);
		Node n6 = new Node(7);
		Node n7 = new Node(9);
		Node n8 = new Node(11);
		Node n9 = new Node(13);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = head;
		
//		System.out.println("Input");
//		Utils.printList(head);
		
		MedianSortedCircularList median = new MedianSortedCircularList();
		int med = median.findMedian(n3);
		System.out.println("Median = " + med);
	}
}
