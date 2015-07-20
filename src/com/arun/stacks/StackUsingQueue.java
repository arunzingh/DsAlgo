package com.arun.stacks;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class StackUsingQueue {
	
	Queue<Integer> q1 = new ConcurrentLinkedQueue<Integer>();
	Queue<Integer> q2 = new ConcurrentLinkedQueue<Integer>();

	
	void push(int item) {
		System.out.println("pushing " + item);
		q1.add(item);
	}
	
	int pop() {
		while (q1.size() > 1) {
			q2.add(q1.poll());
		}
		
		int result = q1.poll();
		Queue temp = q1;
		q1 = q2;
		q2 = temp;
		
		return result;
	}
	
	
	public static void main(String[] args) {
		StackUsingQueue stack = new StackUsingQueue();
		
		stack.push(10);
		stack.push(15);
		stack.push(75);
		stack.push(35);
		System.out.println("popping = " + stack.pop());
		System.out.println("popping = " + stack.pop());
		stack.push(97);
		stack.push(68);
		System.out.println("popping = " + stack.pop());
		System.out.println("popping = " + stack.pop());
		System.out.println("popping = " + stack.pop());

	}
}
