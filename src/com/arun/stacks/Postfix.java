package com.arun.stacks;

import java.util.Stack;

public class Postfix {
	
	Stack<Integer> stack = new Stack<Integer>();
	
	int evaluate(char[] input) {
		for (int i = 0; i < input.length; i++) {
			if(Character.isDigit(input[i])){
				stack.push(Integer.parseInt(String.valueOf(input[i])));
			} else {
				int x = stack.pop();
				int y = stack.pop();
				final char op = input[i];
				int result = 0;
				switch(op) {
				case '+':
					result = y + x;
					break;
				case '-':
					result = y - x;
					break;
				case '*':
					result = y * x;
					break;
				case '/':
					result = y / x;
					break;
				case '^':
					result = y ^ x;
					break;
				}
				stack.push(result);
			}
		}
		
		return stack.pop();
	}
	
	public static void main(String[] args) {
		String str = "231*+9-";
		System.out.println(new Postfix().evaluate(str.toCharArray()));
	}
}
