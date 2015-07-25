package com.arun.graph;

public class MyStack<T> {
	
	private final MyList<T> list = new MyList<T>();
	
	void push(T t) {
		list.add(t);
	}
	
	T pop() {
		return list.removeFromTail();
	}
	
	boolean isEmpty() {
		return list.count == 0 ? true : false;
	}
	
	T peek() {
		return list.peek();
	}
}
