package com.javaadvanceconcepts.javaadvanceconcepts.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyDemo {

	private static int counter = 0;
	private static volatile boolean volatileFlag = false;
	private static final Lock lock = new ReentrantLock();

	public static void demonstrateRaceCondition() throws InterruptedException {
		counter = 0;
		ExecutorService executor = Executors.newFixedThreadPool(2);

		Runnable task = () -> {
			for (int i = 0; i < 1000; i++) {
				counter++;
			}
		};

		executor.submit(task);
		executor.submit(task);

		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.MINUTES);

		System.out.println("Counter value with race condition: " + counter);
	}

	public static void demonstrateSynchronization() throws InterruptedException {
		counter = 0;
		ExecutorService executor = Executors.newFixedThreadPool(2);

		Runnable task = () -> {
			for (int i = 0; i < 1000; i++) {
				synchronized (ConcurrencyDemo.class) {
					counter++;
				}
			}
		};

		executor.submit(task);
		executor.submit(task);

		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.MINUTES);

		System.out.println("Counter value with synchronization: " + counter);
	}

	public static void demonstrateVolatile() throws InterruptedException {
		volatileFlag = false;

		Thread writer = new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			volatileFlag = true;
			System.out.println("Flag set to true");
		});

		Thread reader = new Thread(() -> {
			while (!volatileFlag) {
				// Busy wait
			}
			System.out.println("Flag detected as true");
		});

		writer.start();
		reader.start();

		writer.join();
		reader.join();
	}

	public static void demonstrateDeadlock() {
		Object lock1 = new Object();
		Object lock2 = new Object();

		Thread thread1 = new Thread(() -> {
			synchronized (lock1) {
				System.out.println("Thread 1 acquired lock1");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock2) {
					System.out.println("Thread 1 acquired lock2");
				}
			}
		});

		Thread thread2 = new Thread(() -> {
			synchronized (lock2) {
				System.out.println("Thread 2 acquired lock2");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock1) {
					System.out.println("Thread 2 acquired lock1");
				}
			}
		});

		thread1.start();
		thread2.start();
	}
}