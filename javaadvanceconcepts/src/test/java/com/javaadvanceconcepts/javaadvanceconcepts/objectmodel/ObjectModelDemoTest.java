package com.javaadvanceconcepts.javaadvanceconcepts.objectmodel;

import org.junit.jupiter.api.Test;

public class ObjectModelDemoTest {

	@Test
	void testObjectLayout() {
		ObjectModelDemo.demonstrateObjectLayout();
		System.out.println("Object layout test completed");
	}

	@Test
	void testHashCode() {
		ObjectModelDemo.demonstrateHashCode();
		System.out.println("HashCode test completed");
	}
}