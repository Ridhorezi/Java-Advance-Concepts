package com.javaadvanceconcepts.javaadvanceconcepts.security;

import org.junit.jupiter.api.Test;

import javax.crypto.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class SecurityDemoTest {

	@Test
	void testSecureRandom() {
		SecurityDemo.demonstrateSecureRandom();
		System.out.println("SecureRandom test completed");
	}

	@Test
	void testPasswordHandling() {
		SecurityDemo.demonstratePasswordHandling();
		System.out.println("Password handling test completed");
	}

	@Test
	void testHashing() throws NoSuchAlgorithmException {
		SecurityDemo.demonstrateHashing();
		System.out.println("Hashing test completed");
	}

	@Test
	void testEncryption() throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException,
			InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		SecurityDemo.demonstrateEncryption();
		System.out.println("Encryption test completed");
	}
}
