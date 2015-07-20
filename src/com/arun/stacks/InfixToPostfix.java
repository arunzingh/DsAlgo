package com.arun.stacks;

import java.util.Stack;

public class InfixToPostfix {
	
	private Stack<String> stack = new Stack<String>();
	
	char[] convert(char[] input) {
		
		char[] output = new char[input.length];
		int k = 0;
		for (int i = 0; i < input.length; i++) {
			if (isOperand(input[i])){
				output[k++] = input[i];
			} else if (input[i] == '(') {
				stack.push(String.valueOf(input[i]));
			} else if (input[i] == ')') {
				while(!stack.isEmpty() && stack.peek().charAt(0) != '('){
					output[k++] = stack.pop().charAt(0);
				}
				stack.pop();
			} else {
				while (!stack.isEmpty() && getPrecedence(input[i]) <= getPrecedence(stack.peek().charAt(0))){
					output[k++] = stack.pop().charAt(0);
				}
				stack.push(String.valueOf(input[i]));
			}
			System.out.println(output);
		}
		
		while (!stack.isEmpty())
			output[k++] = stack.pop().charAt(0);
		
		return output;
	
	}
	
	boolean isOperand(char c) {
		return (c >= 'a' && c <= 'z') || c >= 'A' && c <= 'Z';
	}
	
	int getPrecedence(final char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		String str = "a+b*(c^d-e)^(f+g*h)-i";
		char[] input = str.toCharArray();
		
		System.out.println(new InfixToPostfix().convert(input));
	}
}
