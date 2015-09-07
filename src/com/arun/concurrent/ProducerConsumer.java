package com.arun.concurrent;

import java.util.Random;
import java.util.Vector;

public class ProducerConsumer {
	public static final int SIZE = 10;
	private static Vector<Integer> mQueue = new Vector<Integer>();
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Producer(mQueue), "Producer1");
		Thread t2 = new Thread(new Consumer(mQueue), "Consumer1");
		Thread t3 = new Thread(new Consumer(mQueue), "Consumer2");
		Thread t4 = new Thread(new Consumer(mQueue), "Consumer3");
		Thread t5 = new Thread(new Consumer(mQueue), "Consumer4");
		Thread t6 = new Thread(new Consumer(mQueue), "Consumer5");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		
	}
}

class Producer implements Runnable {
	
	private final Vector<Integer> q;
	Random mRand = new Random();
	public Producer(Vector<Integer> q) {
		this.q = q;
	}

	@Override
	public void run() {
		while (true) {
			produce();
		}
		
	}

	private void produce() {
		if (q.size() == ProducerConsumer.SIZE) {
			synchronized (q) {
				try {
					System.out.println("Queue is full " + Thread.currentThread().getName()
                            + " is waiting , size: " + q.size());
					q.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		synchronized (q) {
			int item = mRand.nextInt(100);
			System.out.println("Produced: " + item);
			q.add(item);
			q.notifyAll();
		}
	}
	
}

class Consumer implements Runnable {
	
	private final Vector<Integer> q;

	public Consumer(Vector<Integer> q) {
		this.q = q;
	}
	
	@Override
	public void run() {
		while (true) {
			consume();
		}
	}

	private void consume() {
		if (q.isEmpty()) {
			synchronized (q) {
				try {System.out.println("Queue is empty " + Thread.currentThread().getName()
                        + " is waiting , size: " + q.size());

					q.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		synchronized (q) { 
			int item = q.remove(0);
			System.out.println("Consumed: " + item + " thread:" + Thread.currentThread().getName());
			q.notifyAll(); 
		}
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}