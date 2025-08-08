package com.javaadvanceconcepts.javaadvanceconcepts.jvm;

import java.lang.reflect.Method;

public class JvmInternalsDemo {

	public static void demonstrateBytecode() throws Exception {
		System.out.println("Bytecode demonstration:");
		// Mendapatkan method ini
		Method method = JvmInternalsDemo.class.getMethod("demonstrateBytecode");

		// Informasi dasar tentang method (karena bytecode tidak bisa diakses langsung
		// dari refleksi)
		System.out.println("Method name: " + method.getName());
		System.out.println("Return type: " + method.getReturnType().getName());
		System.out.println("Parameter count: " + method.getParameterCount());
		System.out.println("Method toString: " + method.toString());

		// Catatan untuk melihat bytecode sebenarnya
		System.out.println("Note: Use 'javap -c JvmInternalsDemo' to view actual bytecode.");
	}

	public static void demonstrateClassLoaders() {
		System.out.println("ClassLoader hierarchy:");

		// ClassLoader dari class ini
		ClassLoader loader = JvmInternalsDemo.class.getClassLoader();
		System.out.println("Application/System ClassLoader: " + loader);

		// Parent ClassLoader (Extension)
		ClassLoader extLoader = loader != null ? loader.getParent() : null;
		System.out.println("Extension ClassLoader: " + extLoader);

		// Parent of Extension (Bootstrap - biasanya null)
		ClassLoader bootstrapLoader = extLoader != null ? extLoader.getParent() : null;
		System.out.println("Bootstrap ClassLoader: " + bootstrapLoader);
	}

	public static void printJvmOptions() {
		System.out.println("JVM Runtime Information:");
		Runtime runtime = Runtime.getRuntime();
		System.out.println("Max memory: " + runtime.maxMemory() / 1024 / 1024 + " MB");
		System.out.println("Total memory: " + runtime.totalMemory() / 1024 / 1024 + " MB");
		System.out.println("Free memory: " + runtime.freeMemory() / 1024 / 1024 + " MB");
		System.out.println("Available processors: " + runtime.availableProcessors());
	}
}
