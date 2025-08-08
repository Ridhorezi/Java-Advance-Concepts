package com.javaadvanceconcepts.javaadvanceconcepts.concurrency;

import org.junit.jupiter.api.Test;

public class ConcurrencyDemoTest {

	@Test
	void testRaceCondition() throws InterruptedException {
		ConcurrencyDemo.demonstrateRaceCondition();
		System.out.println("Race condition test completed");
	}

	@Test
	void testSynchronization() throws InterruptedException {
		ConcurrencyDemo.demonstrateSynchronization();
		System.out.println("Synchronization test completed");
	}

	@Test
	void testVolatile() throws InterruptedException {
		ConcurrencyDemo.demonstrateVolatile();
		System.out.println("Volatile test completed");
	}

	@Test
	void testDeadlock() {
		ConcurrencyDemo.demonstrateDeadlock();
		System.out.println("Deadlock demonstration skipped in automated tests");
	}
}