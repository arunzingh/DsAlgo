package com.arun.practise;

import java.util.Deque;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class LruCache {
	
	Deque<Integer> dequeue;
	HashMap<Integer, Integer> map;
	int capacity;
	
	public LruCache(int capacity) {
		this.capacity = capacity;
		dequeue = new ConcurrentLinkedDeque<Integer>();
		map = new HashMap<Integer, Integer>(capacity);
	}
	
	public void referencePage(int pagenumber) {
		
		if (map.containsKey(pagenumber)) {
			dequeue.remove(pagenumber);
			dequeue.addFirst(pagenumber);
		} else {
			bringToCache(pagenumber);
		}
	}

	private void bringToCache(int pagenumber) {
		int size = dequeue.size();
		
		if (size == capacity) {
			int item = dequeue.removeLast();
			map.remove(item);
		}
		
		dequeue.addFirst(pagenumber);
		map.put(pagenumber, pagenumber);
	}
	
	public static void main(String[] args) {
		LruCache c = new LruCache(4);
		c.referencePage(1);
		c.referencePage(2);
		c.referencePage(3);
		c.referencePage(1);
		c.referencePage(4);
		c.referencePage(5);
		
		System.out.println(c.dequeue);
		
	}
}
