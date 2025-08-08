package com.javaadvanceconcepts.javaadvanceconcepts.unsafe;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import sun.misc.Unsafe;

public class UnsafeDemo {

	public static void demonstrateUnsafe() throws Exception {
		// Mendapatkan instance Unsafe melalui reflection
		Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
		theUnsafe.setAccessible(true);
		Unsafe unsafe = (Unsafe) theUnsafe.get(null);

		// Alokasi memori di luar heap
		long memoryAddress = unsafe.allocateMemory(1024);
		System.out.println("Allocated memory at address: " + memoryAddress);

		// Menulis data ke memori
		unsafe.putInt(memoryAddress, 42);
		System.out.println("Wrote value 42 to memory");

		// Membaca data dari memori
		int value = unsafe.getInt(memoryAddress);
		System.out.println("Read value from memory: " + value);

		// Membebaskan memori
		unsafe.freeMemory(memoryAddress);
		System.out.println("Freed memory");
	}

	public static void demonstrateDirectByteBuffer() {
		// Membuat direct byte buffer
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
		System.out.println("Created direct buffer with capacity: " + buffer.capacity());

		// Menyimpan data dalam native byte order
		buffer.order(ByteOrder.nativeOrder());
		buffer.putInt(0, 12345);

		// Membaca data
		int value = buffer.getInt(0);
		System.out.println("Read value from direct buffer: " + value);
	}
}