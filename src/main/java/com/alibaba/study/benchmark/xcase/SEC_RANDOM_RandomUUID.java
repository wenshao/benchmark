package com.alibaba.study.benchmark.xcase;

import java.util.UUID;

public class SEC_RANDOM_RandomUUID extends BenchmarkCaseAdapter {

	public SEC_RANDOM_RandomUUID() {
		super("Random_UUID");
	}
	
	public void execute() throws Exception {
		UUID.randomUUID();
	}

}
