package com.arun.linkedlist;

public class Utils {
	public static void printList(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data);
			curr = curr.next;
			if (curr != null)
				System.out.print(" -> ");
		}
		System.out.println("");
	}
	
	public static void printRandom(Node head) {
		Node curr = head;
		while (curr != null && curr.random != null) {
			System.out.print(curr.data);
			System.out.print(" -> " + curr.random.data + " ");
			curr = curr.next;
		}
		System.out.println("");
	}
	
	public static int getLength(Node head){
		int count = 0;
		Node curr = head;
		
		while (curr != null) {
			count++;
			curr = curr.next;
		}
		
		return count;
	}
}
