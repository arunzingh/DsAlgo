package com.arun.linkedlist;

public class Partition {
	public Node partition(Node head, int x){
		
		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;
		
		Node curr = head;
		Node next;
		while (curr != null) {
			next = curr.next;
			curr.next = null;
			if (curr.data < x) {
				if (beforeStart == null) {
					beforeStart = curr;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = curr;
					beforeEnd = curr;
				}
			} else {
				if (afterStart == null) {
					afterStart = curr;
					afterEnd = afterStart;
				} else {
					afterEnd.next = curr;
					afterEnd = curr;
				}
			}
			curr = next;
		}
		if (beforeStart == null) {
			return afterStart;
		} else {
			beforeEnd.next = afterStart;
			return beforeStart;
		}
	}
	
	public Node partition1(Node head, int x) {
		Node beforeStart = null;
		Node afterStart = null;
		Node curr = head;
		Node next = null;
		while (curr != null) {
			next = curr.next;
			
			if (curr.data < x) {
				curr.next = beforeStart;
				beforeStart = curr;
			} else {
				curr.next = afterStart;
				afterStart = curr;
			}
			
			curr = next;
		}
		
		if (beforeStart == null) {
			return afterStart;
		} 
		System.out.println("beforeStart=" + beforeStart.data);
		
		Node resultHead = beforeStart;
		while (beforeStart.next != null) {
			beforeStart = beforeStart.next;
		}
		
		beforeStart.next = afterStart;
		return resultHead;
		
	}
	
	public static void main(String[] args) {
		Node node = new Node(9);
		Node n1 = new Node(8);
		Node n2 = new Node(8);
		Node n3 = new Node(0);
		Node n4 = new Node(3);
		Node n5 = new Node(4);
		Node n6 = new Node(2);
		Node n7 = new Node(9);
		Node n8 = new Node(0);
		Node n9 = new Node(4);
		node.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		
		Utils.printList(node);
		
		Partition part = new Partition();
//		printList(part.partition(node, 5));
		Utils.printList(part.partition1(node, 5));
	}
	

}


