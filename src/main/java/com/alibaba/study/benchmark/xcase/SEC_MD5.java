package com.alibaba.study.benchmark.xcase;

import java.security.MessageDigest;
import java.security.SecureRandom;

public class SEC_MD5 extends BenchmarkCaseAdapter {
	MessageDigest digest;
	private byte[] plainBytes;

	public SEC_MD5() {
		super("MD5");
	}

	public void init() throws Exception {
		plainBytes = new byte[1024 * 4]; // 4k

		SecureRandom random = new SecureRandom();
		random.nextBytes(plainBytes);

		digest = MessageDigest.getInstance("MD5");
	}

	public void execute() throws Exception {
		digest.digest(plainBytes);
	}

}
