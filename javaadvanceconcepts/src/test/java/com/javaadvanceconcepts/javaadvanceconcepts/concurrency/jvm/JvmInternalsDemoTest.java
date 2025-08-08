package com.javaadvanceconcepts.javaadvanceconcepts.concurrency.jvm;

import com.javaadvanceconcepts.javaadvanceconcepts.jvm.JvmInternalsDemo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JvmInternalsDemoTest {

	@Test
	@DisplayName("Test Bytecode Information")
	void testBytecode() throws Exception {
		JvmInternalsDemo.demonstrateBytecode();
		System.out.println("Bytecode test completed");
	}

	@Test
	@DisplayName("Test ClassLoader Hierarchy")
	void testClassLoaders() {
		JvmInternalsDemo.demonstrateClassLoaders();
		System.out.println("ClassLoader test completed");
	}

	@Test
	@DisplayName("Test JVM Options Info")
	void testJvmOptions() {
		JvmInternalsDemo.printJvmOptions();
		System.out.println("JVM options test completed");
	}
}
