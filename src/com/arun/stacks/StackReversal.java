package com.arun.stacks;
 
import java.util.Stack;
 
public class StackReversal {
 
	void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
 
		// Remove bottom element from stack
		int bottom = popBottomMostElement(stack);
 
		// Reverse everything else in stack
		reverse(stack);
 
		// Add original bottom element to top of stack
		stack.push(bottom);
	}
 
	private int popBottomMostElement(Stack<Integer> stack) {
		int top = stack.pop();
 
		if (stack.isEmpty()) {
			// If we removed the last element, return it
			return top;
		} else {
			// We didn't remove the last element, so remove the last element
			// from what remains
			int bottom = popBottomMostElement(stack);
 
			// Since the element we removed in this function call isn't the
			// bottom element, add it back onto the top of the stack where it
			// came from
			stack.push(top);
 
			return bottom;
		}
	}
 
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		StackReversal r = new StackReversal();
		r.reverse(stack);
		System.out.println("Revered Stack : " + stack);
	}
}