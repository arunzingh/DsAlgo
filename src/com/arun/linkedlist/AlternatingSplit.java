package com.arun.linkedlist;

public class AlternatingSplit {
	Node[] split(Node head) {
		Node tail1 = head;
		Node tail2 = head.next;
		Node[] result = {tail1, tail2};
		Node curr = head.next.next;
		int count = 0;
		while (curr != null) {
			if (count%2 == 0){
				tail1.next = curr;
				tail1 = tail1.next;
			} else {
				tail2.next = curr;
				tail2 = tail2.next;
			}
			curr = curr.next;
			count++;
		}
		
		tail1.next = null;
		tail2.next = null;
		
		return result;
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
		
		Node[] result = new AlternatingSplit().split(head);
		
		Utils.printList(result[0]);
		
		Utils.printList(result[1]);

	}
}
