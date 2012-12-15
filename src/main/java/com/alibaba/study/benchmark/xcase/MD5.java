package com.alibaba.study.benchmark.xcase;

import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class MD5 extends BenchmarkCaseAdapter {
	MessageDigest digest;
	private byte[] plainBytes;

	public MD5() {
		super("SHA-256");
	}

	public void init() throws Exception {
		plainBytes = new byte[1024 * 4]; // 4k

		SecureRandom random = new SecureRandom();
		random.nextBytes(plainBytes);

		digest = MessageDigest.getInstance("SHA-384");
	}

	public void execute() throws Exception {
		digest.digest(plainBytes);
	}

}
