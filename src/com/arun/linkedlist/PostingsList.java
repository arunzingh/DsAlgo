package com.arun.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class PostingsList {
	Node copy(Node head) {
		
		// 1. Copy original nodes and create a copy linked list
		Node currOrig = head;
		Node headCopy = null;
		Node currCopy = null;
		Node prevCopy = null;
		Map<Node, Node> map = new HashMap<Node, Node>();

		while (currOrig != null) {
			currCopy = new Node(currOrig.data);
			if (prevCopy != null) {
				prevCopy.next = currCopy;
			}
			if (headCopy == null) {
				headCopy = currCopy;
			}
			
			prevCopy = currCopy;
			map.put(currOrig, currOrig.next);
			currOrig = currOrig.next;
		}
		
		// 3. Make original linked list nodes next point to corresponding copy
		// and copy random point to corresponding original
		
		currOrig = head;
		currCopy = headCopy;
		Node next = null;
		while (currOrig != null && currCopy != null) {
			next = currOrig.next;
			currOrig.next = currCopy;
			currCopy.random = currOrig;
			
			currOrig = next;
			currCopy  = currCopy.next;
		}
		
		
		// 4. Make orbit 
		currCopy = headCopy;
		while (currCopy != null && currCopy.random != null) {
			if (currCopy.random.random != null)
				currCopy.random = currCopy.random.random.next;
			else 
				currCopy.random = currCopy.random.random;
			
			currCopy = currCopy.next;
		}
		
		// 5. Reset original next pointers
		currOrig = head;
		while (currOrig != null) {
			currOrig.next = map.get(currOrig);
			currOrig = currOrig.next;
		}
		Utils.printList(head);
		Utils.printRandom(head);
		
		return headCopy;
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
		
		PostingsList list = new PostingsList();
		Node result = list.copy(head);
		
		System.out.println("Original");
		Utils.printList(head);
		Utils.printRandom(head);
		
		System.out.println("Copy");
		Utils.printList(result);
		Utils.printRandom(result);
	}
}
