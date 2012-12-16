package com.alibaba.study.benchmark.xcase;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class SEC_DES_Encrypt extends BenchmarkCaseAdapter {
	private Cipher cipher;
	private byte[] plainBytes;

	public SEC_DES_Encrypt() {
		super("DES-Encrypt");
	}

	public void init() throws Exception {
		plainBytes = new byte[1024 * 1]; // 4k
		
		SecureRandom random = new SecureRandom();
		random.nextBytes(plainBytes);
		
		KeyGenerator keyGen = KeyGenerator.getInstance("DES");
		keyGen.init(56);
		SecretKey secretKey = keyGen.generateKey();
		
		cipher = Cipher.getInstance(secretKey.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	}

	public void execute() throws Exception {
		cipher.doFinal(plainBytes);
	}
}
