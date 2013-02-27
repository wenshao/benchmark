package com.alibaba.study.benchmark.xcase;

import java.util.Random;

public class SEC_RANDOM_Random extends BenchmarkCaseAdapter {
	private Random random = new Random();
	
	public SEC_RANDOM_Random() {
		super("Random_UUID");
	}
	
	public void execute() throws Exception {
		random.nextBytes(new byte[16]);
	}

}
