package com.alibaba.study.benchmark.xcase;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.Cipher;

public class SEC_RSA_Decrypt extends BenchmarkCaseAdapter {
	private Cipher cipher;
	private byte[] plainBytes;
	private byte[] cipherBytes;

	public SEC_RSA_Decrypt() {
		super("RSA-Encrypt");
	}

	public void init() throws Exception {
		plainBytes = new byte[32]; // 4k

		SecureRandom random = new SecureRandom();
		random.nextBytes(plainBytes);

		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		keyPairGen.initialize(2048);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		PublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		PrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

		{
			Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			cipherBytes = cipher.doFinal(plainBytes);
		}
		
		cipher = Cipher.getInstance(privateKey.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
	}

	public void execute() throws Exception {
		cipher.doFinal(cipherBytes);
	}
}
