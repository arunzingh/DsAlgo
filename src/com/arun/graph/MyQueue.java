package com.arun.graph;

public class MyQueue<T> {
	private final MyList<T> list = new MyList<T>(); 
	
	void add(T t) {
		list.add(t);
	}
	
	T poll() {
		return list.removeFromHead();
	}
	
	boolean isEmpty() {
		return list.count == 0 ? true : false;
	}
}
