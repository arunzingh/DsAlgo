package com.arun.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {
	
	private static final int MAX = 10;
	private List<Integer> list = new ArrayList<Integer>();
	
	private ReentrantLock lock = new ReentrantLock();
	private Condition full = lock.newCondition();
	private Condition empty = lock.newCondition();
	
	public void put(int item) {
		synchronized (this) {
			System.out.println(list.size());
			while (list.size() == MAX) {
				try {
					System.out.println(Thread.currentThread().getName() + " wait");
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + " resume");

			list.add(item);
			notifyAll();
		}
	}
	
	public int take() {
		synchronized (this) {
			while (list.isEmpty()) {
				try {
					System.out.println(Thread.currentThread().getName() + " wait");
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + " resume");
			int item = list.remove(0);
			notifyAll();
			return item;
		}
	}
	
	
	public void put1(int item) {
		this.lock.lock();
		try {
			while (list.size() == MAX)  {
				System.out.println(Thread.currentThread().getName() + " full wait");

				full.await();
			}
			
			System.out.println(Thread.currentThread().getName() + " empty signal");

			list.add(item);
			empty.signal();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			this.lock.unlock();
		}
		
	}
	
	public int take1() {
		int item = 0;
		this.lock.lock();
		try {
			while (list.isEmpty()) {
				System.out.println(Thread.currentThread().getName() + " empty wait");

				empty.await();
			}
			
			System.out.println(Thread.currentThread().getName() + " full signal");

			item = list.remove(0);
			full.signal();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			this.lock.unlock();
		}
		return item;
	}
	
	public static void main(String[] args) {
		ProducerConsumer pc = new ProducerConsumer();
		
		for (int i = 0; i < 10; i++) {
			pc.put1(i);
		}
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				pc.put1(100);
				
			}
		}, "t1").start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				pc.take1();
				
			}
		}, "t2").start();
		
	}
}
