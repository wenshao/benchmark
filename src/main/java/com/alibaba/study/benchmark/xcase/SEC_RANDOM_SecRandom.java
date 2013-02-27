package com.alibaba.study.benchmark.xcase;

import java.security.SecureRandom;

public class SEC_RANDOM_SecRandom extends BenchmarkCaseAdapter {
	private SecureRandom random = new SecureRandom();
	
	public SEC_RANDOM_SecRandom() {
		super("Random_UUID");
	}
	
	public void execute() throws Exception {
		random.nextBytes(new byte[16]);
	}

}
