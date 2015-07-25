package com.arun.linkedlist;

public class Node {
	public int data;
	public Node next;
	public Node random;
	public Node prev;
	public int order = -1;
	
	public Node(int data) {
		this.data = data;
	}
}
