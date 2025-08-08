package com.javaadvanceconcepts.javaadvanceconcepts.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class IoDemo {

	public static void traditionalIoCopy(File source, File dest) throws IOException {
		try (InputStream in = new FileInputStream(source); OutputStream out = new FileOutputStream(dest)) {

			byte[] buffer = new byte[1024];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
		}
		System.out.println("Traditional IO copy completed");
	}

	public static void nioCopy(File source, File dest) throws IOException {
		try (FileChannel inChannel = new FileInputStream(source).getChannel();
				FileChannel outChannel = new FileOutputStream(dest).getChannel()) {

			inChannel.transferTo(0, inChannel.size(), outChannel);
		}
		System.out.println("NIO copy completed");
	}

	public static void demonstrateMemoryMappedFile(File file) throws IOException {
		try (RandomAccessFile raf = new RandomAccessFile(file, "rw"); FileChannel channel = raf.getChannel()) {

			ByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, channel.size());

			// Baca dari buffer
			byte[] data = new byte[(int) channel.size()];
			buffer.get(data);
			System.out.println("File content: " + new String(data, StandardCharsets.UTF_8));

			// Tulis ke buffer
			buffer.put(0, (byte) 'U');
			buffer.put(1, (byte) 'P');
			buffer.put(2, (byte) 'D');
		}
		System.out.println("Memory mapped file demonstration completed");
	}

	public static void demonstratePathApi() throws IOException {
		Path path = Paths.get("test.txt");

		// Tulis file dengan NIO.2
		Files.write(path, "Hello NIO.2".getBytes(), StandardOpenOption.CREATE);

		// Baca file dengan NIO.2
		byte[] content = Files.readAllBytes(path);
		System.out.println("File content: " + new String(content));

		Files.deleteIfExists(path);
		System.out.println("Path API demonstration completed");
	}
}
