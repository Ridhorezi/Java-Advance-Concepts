package com.javaadvanceconcepts.javaadvanceconcepts.concurrency.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import com.javaadvanceconcepts.javaadvanceconcepts.io.IoDemo;

public class IoDemoTest {

	@Test
	void testIoCopy(@TempDir Path tempDir) throws IOException {
		File source = tempDir.resolve("source.txt").toFile();
		File dest = tempDir.resolve("dest.txt").toFile();
		// Buat file sumber
		try (FileWriter writer = new FileWriter(source)) {
			writer.write("Test content");
		}
		IoDemo.traditionalIoCopy(source, dest);
		System.out.println("IO copy test completed");
	}

	@Test
	void testNioCopy(@TempDir Path tempDir) throws IOException {
		File source = tempDir.resolve("source.txt").toFile();
		File dest = tempDir.resolve("dest.txt").toFile();
		// Buat file sumber
		try (FileWriter writer = new FileWriter(source)) {
			writer.write("Test content");
		}
		IoDemo.nioCopy(source, dest);
		System.out.println("NIO copy test completed");
	}

	@Test
	void testMemoryMappedFile(@TempDir Path tempDir) throws IOException {
		File file = tempDir.resolve("mapped.txt").toFile();
		// Buat file
		try (FileWriter writer = new FileWriter(file)) {
			writer.write("Original content");
		}
		IoDemo.demonstrateMemoryMappedFile(file);
		System.out.println("Memory mapped file test completed");
	}

	@Test
	void testPathApi() throws IOException {
		IoDemo.demonstratePathApi();
		System.out.println("Path API test completed");
	}
}