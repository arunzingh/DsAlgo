package com.arun.linkedlist;

public class Zipping {
	
	Node zip(Node head) {
		Node slow = head;
		Node fast = head;
		Node preSlow = null;
		while (fast != null && fast.next != null) {
			preSlow = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		// IMP STEP TO MAKE PRE SLOW AS NULL
		preSlow.next = null; 
		
		Node rev = new ReverseList().reverse(slow);
		Utils.printList(rev);
		
		Node curr = head;
		Node next1 = null;
		Node next2 = null;
		while (curr != null && rev != null) {
			next1 = curr.next;
			curr.next = rev;
			curr = next1;
			next2 = rev.next;
			rev.next = next1;
			rev = next2;
			
			if (curr != null) System.out.println("curr " + curr.data);
			if (rev != null) System.out.println("rev " + rev.data);
		}
		
		return head;
	}
	
	void connect(Node a, Node b) {
		Node temp = a.next;
		a.next = b;
		a = temp;
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
		
		Zipping z = new Zipping();
		Node result = z.zip(head);
		
		Utils.printList(result);
		
	}
}
