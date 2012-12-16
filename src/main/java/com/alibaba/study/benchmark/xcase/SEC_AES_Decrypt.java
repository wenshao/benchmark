package com.alibaba.study.benchmark.xcase;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class SEC_AES_Decrypt extends BenchmarkCaseAdapter {
	private Cipher cipher;
	private byte[] plainBytes;
	private byte[] cipherBytes;

	public SEC_AES_Decrypt() {
		super("AES-Decrypt");
	}

	public void init() throws Exception {
		plainBytes = new byte[1024 * 1]; // 4k

		SecureRandom random = new SecureRandom();
		random.nextBytes(plainBytes);

		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(192);
		SecretKey secretKey = keyGen.generateKey();

		{
			Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			cipherBytes = cipher.doFinal(plainBytes);
		}
		
		cipher = Cipher.getInstance(secretKey.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
	}

	public void execute() throws Exception {
		cipher.doFinal(cipherBytes);
	}

}
