package com.javaadvanceconcepts.javaadvanceconcepts.serialization;

import java.io.*;
import java.util.Base64;

public class SerializationDemo {

	static class User implements Serializable {
		private static final long serialVersionUID = 1L;
		private String username;
		private transient String password; // Tidak akan diserialisasi

		public User(String username, String password) {
			this.username = username;
			this.password = password;
		}

		private void writeObject(ObjectOutputStream out) throws IOException {
			out.defaultWriteObject();
			// Enkripsi password sebelum serialisasi
			out.writeObject(encrypt(password));
		}

		private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
			in.defaultReadObject();
			// Dekripsi password setelah deserialisasi
			password = decrypt((String) in.readObject());
		}

		private String encrypt(String input) {
			// Enkripsi sederhana (dalam produksi gunakan algoritma kuat)
			return Base64.getEncoder().encodeToString(input.getBytes());
		}

		private String decrypt(String input) {
			return new String(Base64.getDecoder().decode(input));
		}

		@Override
		public String toString() {
			return "User{username='" + username + "', password='" + password + "'}";
		}
	}

	public static String serializeUser(User user) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
			oos.writeObject(user);
		}
		return Base64.getEncoder().encodeToString(baos.toByteArray());
	}

	public static User deserializeUser(String serialized) throws IOException, ClassNotFoundException {
		byte[] data = Base64.getDecoder().decode(serialized);
		try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
			return (User) ois.readObject();
		}
	}

	public static void demonstrateSerialization() throws IOException, ClassNotFoundException {
		User user = new User("admin", "secret123");

		// Serialisasi
		String serialized = serializeUser(user);
		System.out.println("Serialized user: " + serialized);

		// Deserialisasi
		User deserialized = deserializeUser(serialized);
		System.out.println("Deserialized user: " + deserialized);
	}
}
