package com.alibaba.study.benchmark.xcase;

import java.util.concurrent.ThreadLocalRandom;


public class SEC_RANDOM_ThreadLocalRandom extends BenchmarkCaseAdapter {
	
	public SEC_RANDOM_ThreadLocalRandom() {
		super("LocalRandom_UUID");
	}
	
	public void execute() throws Exception {
		ThreadLocalRandom.current().nextBytes(new byte[16]);
	}

}
