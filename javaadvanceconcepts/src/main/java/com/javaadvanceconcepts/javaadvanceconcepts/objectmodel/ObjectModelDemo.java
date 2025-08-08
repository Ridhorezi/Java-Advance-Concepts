package com.javaadvanceconcepts.javaadvanceconcepts.objectmodel;

public class ObjectModelDemo {

	// Contoh object layout dengan field alignment
	static class SampleObject {
		boolean flag; // 1 byte + 7 padding (dalam 64-bit JVM)
		int id; // 4 byte
		double value; // 8 byte
		String name; // 4 byte (reference)
	}

	public static void demonstrateObjectLayout() {
		SampleObject obj = new SampleObject();
		obj.flag = true;
		obj.id = 42;
		obj.value = 3.14;
		obj.name = "Test";

		System.out.println("Object layout demonstration:");
		System.out.println("Size: " + ObjectSizeCalculator.getObjectSize(obj) + " bytes");
	}

	public static void demonstrateHashCode() {
		Object obj1 = new Object();
		Object obj2 = new Object();

		System.out.println("HashCode demonstration:");
		System.out.println("obj1 hashCode: " + obj1.hashCode());
		System.out.println("obj2 hashCode: " + obj2.hashCode());
		System.out.println(
				"Same objects hashCode equal: " + (new String("test").hashCode() == new String("test").hashCode()));
	}
}

// Helper class untuk estimasi ukuran objek (simplified)
class ObjectSizeCalculator {
	public static long getObjectSize(Object obj) {
		// Implementasi sebenarnya lebih kompleks (menggunakan Instrumentation atau
		// Unsafe)
		// Ini hanya estimasi sederhana
		return 12 // object header
				+ 8 // boolean + padding
				+ 4 // int
				+ 8 // double
				+ 4; // reference
	}
}