package com.javaadvanceconcepts.javaadvanceconcepts.reflection;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation {
	String value() default "default";

	int priority() default 0;
}

public class ReflectionDemo {

	@MyAnnotation(value = "important", priority = 1)
	public void annotatedMethod() {
		System.out.println("This is an annotated method");
	}

	private String privateField = "Private field value";

	private void privateMethod() {
		System.out.println("Private method called");
	}

	public static void demonstrateReflection() throws Exception {
		ReflectionDemo demo = new ReflectionDemo();
		Class<?> clazz = demo.getClass();

		// Mendapatkan annotation
		Method method = clazz.getMethod("annotatedMethod");
		MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
		System.out.println("Annotation value: " + annotation.value());
		System.out.println("Annotation priority: " + annotation.priority());

		// Mengakses private field
		Field field = clazz.getDeclaredField("privateField");
		field.setAccessible(true); // Bypass access control
		System.out.println("Private field value: " + field.get(demo));

		// Memanggil private method
		Method privateMethod = clazz.getDeclaredMethod("privateMethod");
		privateMethod.setAccessible(true);
		privateMethod.invoke(demo);

		// Membuat instance baru
		Constructor<?> constructor = clazz.getConstructor();
		Object newInstance = constructor.newInstance();
		System.out.println("New instance created: " + newInstance);
	}

	public static void demonstrateDynamicProxy() {
		MyInterface original = new MyInterfaceImpl();

		// Membuat proxy dinamis
		MyInterface proxy = (MyInterface) Proxy.newProxyInstance(MyInterface.class.getClassLoader(),
				new Class<?>[] { MyInterface.class }, (proxyInstance, method, args) -> {
					System.out.println("Before method: " + method.getName());
					Object result = method.invoke(original, args);
					System.out.println("After method: " + method.getName());
					return result;
				});

		proxy.doSomething();
	}

	interface MyInterface {
		void doSomething();
	}

	static class MyInterfaceImpl implements MyInterface {
		@Override
		public void doSomething() {
			System.out.println("Doing something...");
		}
	}
}