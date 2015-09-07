package com.arun.concurrent;

public class EvenOddPrinter {
	
	static Object lock = new Object();
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new PrintEven(lock), "t1");
		
		Thread t2 = new Thread(new PrintOdd(lock), "t2");
		t1.start();
		t2.start();
	}
}



class PrintEven implements Runnable {
	int n = 0;
	Object lock;

	public PrintEven(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (lock) {
				try {
					System.out.println(Thread.currentThread().getName() + " printing " + n);
					n = n + 2;
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}

class PrintOdd implements Runnable {
	int n = 1;
	Object lock;

	public PrintOdd(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException ie) {
		}
		while (true) {
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName() + " printing " + n);
				n = n + 2;
				lock.notify();
			}
		}
	}
	
}
