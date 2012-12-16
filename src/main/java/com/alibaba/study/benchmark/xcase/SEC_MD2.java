package com.alibaba.study.benchmark.xcase;

import java.security.MessageDigest;
import java.security.SecureRandom;

public class SEC_MD2 extends BenchmarkCaseAdapter {
	MessageDigest digest;
	private byte[] plainBytes;

	public SEC_MD2() {
		super("MD2");
	}

	public void init() throws Exception {
		plainBytes = new byte[1024 * 1]; // 4k

		SecureRandom random = new SecureRandom();
		random.nextBytes(plainBytes);

		digest = MessageDigest.getInstance("MD2");
	}

	public void execute() throws Exception {
		digest.digest(plainBytes);
	}

}
