package com.arun.concurrent;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer1 {
	static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
	
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Producer1(queue), "Producer1");
		Thread t2 = new Thread(new Consumer1(queue), "Consumer1");
		
		t1.start();
		t2.start();
	}
}

class Producer1 implements Runnable {

	private final BlockingQueue<Integer> q;
	private final Random mRand = new Random();
	
	public Producer1(BlockingQueue<Integer> q) {
		
		this.q = q;
	}

	@Override
	public void run() {
		int count = 0;
		while (count < 10) {
			produce();
			count++;
		}
	}

	private void produce() {
		int item = mRand.nextInt(100);
		System.out.println("Produced: " + item);
		try {
			q.put(item);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Consumer1 implements Runnable {

	private final BlockingQueue<Integer> q;
	
	public Consumer1(BlockingQueue<Integer> q) {
		this.q = q;
	}

	@Override
	public void run() {
		while (true) {
			consume();
		}

	}

	private void consume() {
		int item = -1;
		try {
			item = q.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Consumed: " + item);
	}
}

