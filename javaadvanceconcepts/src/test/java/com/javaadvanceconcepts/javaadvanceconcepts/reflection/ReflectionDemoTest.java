package com.javaadvanceconcepts.javaadvanceconcepts.reflection;

import org.junit.jupiter.api.Test;

public class ReflectionDemoTest {

	@Test
	void testReflection() throws Exception {
		ReflectionDemo.demonstrateReflection();
		System.out.println("Reflection test completed");
	}

	@Test
	void testDynamicProxy() {
		ReflectionDemo.demonstrateDynamicProxy();
		System.out.println("Dynamic proxy test completed");
	}
}