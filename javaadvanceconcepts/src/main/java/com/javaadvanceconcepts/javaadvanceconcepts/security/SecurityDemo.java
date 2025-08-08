package com.javaadvanceconcepts.javaadvanceconcepts.security;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;

public class SecurityDemo {

	public static void demonstrateSecureRandom() {
		SecureRandom secureRandom = new SecureRandom();
		byte[] randomBytes = new byte[16];
		secureRandom.nextBytes(randomBytes);

		System.out.println("SecureRandom bytes: " + Arrays.toString(randomBytes));
	}

	public static void demonstratePasswordHandling() {
		char[] password = "mySecretPassword".toCharArray();

		// Selalu gunakan char[] untuk password
		System.out.println("Password length: " + password.length);

		// Bersihkan array setelah digunakan
		Arrays.fill(password, '\0');
		System.out.println("Password cleared");
	}

	public static void demonstrateHashing() throws NoSuchAlgorithmException {
		String input = "password123";
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

		System.out.println("SHA-256 hash: " + Base64.getEncoder().encodeToString(hash));
	}

	public static void demonstrateEncryption()
			throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

		// Generate random IV
		SecureRandom secureRandom = new SecureRandom();
		byte[] iv = new byte[16];
		secureRandom.nextBytes(iv);
		IvParameterSpec ivSpec = new IvParameterSpec(iv);

		// Generate key from password
		String password = "password";
		String salt = "somesalt";
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
		SecretKey tmp = factory.generateSecret(spec);
		SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

		// Encrypt
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
		byte[] encrypted = cipher.doFinal("Secret message".getBytes(StandardCharsets.UTF_8));

		System.out.println("Encrypted message: " + Base64.getEncoder().encodeToString(encrypted));

		// Decrypt
		cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
		byte[] decrypted = cipher.doFinal(encrypted);
		System.out.println("Decrypted message: " + new String(decrypted, StandardCharsets.UTF_8));
	}
}