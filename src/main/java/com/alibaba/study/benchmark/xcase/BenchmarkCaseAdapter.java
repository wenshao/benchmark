package com.alibaba.study.benchmark.xcase;

import com.alibaba.study.benchmark.BenchmarkCase;

public abstract class BenchmarkCaseAdapter implements BenchmarkCase {
	private final String name;

	public BenchmarkCaseAdapter(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void init() throws Exception {
		
	}

	public void execute() throws Exception {
		
	}

}
