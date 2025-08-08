package com.javaadvanceconcepts.javaadvanceconcepts.unsafe;

import org.junit.jupiter.api.Test;

public class UnsafeDemoTest {

	@Test
	void testUnsafe() throws Exception {
		UnsafeDemo.demonstrateUnsafe();
		System.out.println("Unsafe test completed");
	}

	@Test
	void testDirectByteBuffer() {
		UnsafeDemo.demonstrateDirectByteBuffer();
		System.out.println("Direct ByteBuffer test completed");
	}
}