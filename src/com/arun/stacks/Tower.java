package com.arun.stacks;
 
import java.util.Stack;

public class Tower {
	private Stack<Integer> disks;
	private int index = 0;
	public Tower(int i) {
		disks = new Stack<Integer>();
		index = i;
	}
	
	int index() {
		return index;
	}
	
	void moveDisks(int n, Tower destination, Tower buffer) {
		if (n > 0) {
			moveDisks(n-1, buffer, destination);
			moveTop(destination);
			buffer.moveDisks(n-1, destination, this);
		}
	}
	
	void moveTop(Tower t) {
		int i = disks.pop();
		t.add(i);
		System.out.println("Move disk " + i + " from tower " + index() + " to " + t.index());
	}
	
	void add(int n) {
		if (!disks.isEmpty() && disks.peek() <= n) {
			System.err.println("Cannot add");
		}
		disks.push(n);
	}
	
	public static void main(String[] args) {
		Tower[] towers = new Tower[3];
		for (int i = 0; i < towers.length; i++) {
			towers[i] = new Tower(i+1);
		}
		
		for (int i = 3; i >= 1; i--) {
			towers[0].add(i);
		}
		
		towers[0].moveDisks(3, towers[2], towers[1]);
	}
}
