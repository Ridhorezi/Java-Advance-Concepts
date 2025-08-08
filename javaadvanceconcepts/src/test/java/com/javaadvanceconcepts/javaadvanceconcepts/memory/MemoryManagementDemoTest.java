package com.javaadvanceconcepts.javaadvanceconcepts.memory;

import org.junit.jupiter.api.Test;

public class MemoryManagementDemoTest {

	@Test
	void testMemoryLeak() {
		MemoryManagementDemo.createMemoryLeak();
		System.out.println("Memory leak test completed");
	}

	@Test
	void testGarbageCollection() {
		MemoryManagementDemo.demonstrateGC();
		System.out.println("GC demonstration test completed");
	}

	@Test
	void testFinalize() throws InterruptedException {
		MemoryManagementDemo.demonstrateFinalize();
		// Beri waktu untuk finalizer berjalan
		Thread.sleep(1000);
		System.out.println("Finalize demonstration test completed");
	}
}
