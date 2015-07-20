package com.arun.stacks;

import java.util.Stack;

public class StackSorting {
	void sort(Stack<Integer> stack) {
		if (!stack.isEmpty()) {
			int temp = stack.pop();
			sort(stack);
			insert(stack, temp);
		}
	}
	
	void insert(Stack<Integer> stack, int item) {
		if (stack.isEmpty() || stack.peek() < item) {
			stack.push(item);
		} else {
			int e = stack.pop();
			insert(stack, item);
			stack.push(e);
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(9);
		stack.push(8);
		stack.push(8);
		stack.push(0);
		stack.push(3);
		stack.push(4);
		stack.push(2);
		stack.push(9);
		stack.push(0);
		stack.push(4);
		System.out.println(stack);
		new StackSorting().sort(stack);
		System.out.println(stack);
	}
}
