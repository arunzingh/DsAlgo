package com.arun.arrays;


public class MyQueue<T> {
	
	Node head = null;
	Node tail = null;
	
	class Node<T> {
		T data;
		Node<T> next;
		Node<T> prev;
		
		public Node(T data) {
			this.data = data;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "" + data;
		}
	}
	
	public void enQ(T t) {
		Node n = new Node(t);
		
		if (head == null) {
			head = n;
			tail = n;
		} else {
			n.prev = tail;
			tail.next = n;
			tail = n;
		}
	}
	
	public T deQ() {
		if (tail == null) {
			System.out.println("Error no item to dequeue");
		}
		System.out.println("head = " + head);
		Node temp = head;
		head = head.next;
		
		return (T) temp.data;
		
	}
	
	@Override
	public String toString() {
		Node curr  = tail;
		StringBuffer sb = new StringBuffer();
		while (curr != null) {
			sb.append(curr.data + " ");
			curr = curr.prev;
		}
		return sb.toString();
	}
	
	public boolean isEmpty() {
		return head == tail;
	}
	
	public T deQueueFromTail() {
		if (tail == null) {
			System.out.println("Error no item to dequeue");
		}
		
		Node prev = tail.prev;
		tail = prev;
		tail.next = null;
		return (T) prev.data;
		
	}
	
	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.enQ(10);
		queue.enQ(6);
		queue.enQ(10);
		queue.enQ(3);
		queue.enQ(4);
		queue.enQ(8);
		
		System.out.println(queue);
		queue.deQueueFromTail();
		queue.deQueueFromTail();
		queue.deQueueFromTail();
		
		System.out.println(queue);
		
		queue.enQ(5);
		queue.enQ(9);
		System.out.println(queue);
	}
	
}
