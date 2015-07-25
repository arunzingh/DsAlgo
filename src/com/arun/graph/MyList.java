package com.arun.graph;

public class MyList<T> {
	private ListNode<T> head;
	private ListNode<T> tail;
	int count = 0;
	
	void add(T t) {
		ListNode<T> newNode = new ListNode<T>(t);
		count++;
		if (head == null) {
			head = newNode;
			tail = head;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}
	
	T removeFromTail() {
//		System.out.println("count=" + count);
		if (count > 0) {
			ListNode<T> temp = tail;
			tail = tail.prev;
			if (tail != null) tail.next = null;
			count--;
			return temp.data;
		}
		return null;
	}
	
	T removeFromHead() {
		if (head == null) return null;
		
		ListNode<T> temp = head;
		head = head.next;
		if (head != null) head.prev = null;
		count--;
		return temp.data;
	}
	
	int getSize() {
		return count;
	}
	
	T peek() {
		return tail.data;
	}
	
	
	public static void main(String[] args) {
		MyList<Integer> list = new MyList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		list.printReverse();
		System.out.println("count=" + list.getSize());

		for (int i = 0; i < 2; i++) {
			list.removeFromHead();
		}
		
		list.printReverse();
		System.out.println("count=" + list.getSize());

		
		for (int i = 0; i < 2; i++) {
			list.removeFromTail();
		}
		
		list.printReverse();
		System.out.println("count=" + list.getSize());

	}

	private void print() {
		ListNode curr = head;
		
		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
	}  
	
	private void printReverse() {
		ListNode curr = tail;
		
		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.prev;
		}
	}
}

class ListNode<T> {
	T data;
	ListNode<T> next;
	ListNode<T> prev;
	public ListNode(T data) {
		this.data = data;
	}
	

}