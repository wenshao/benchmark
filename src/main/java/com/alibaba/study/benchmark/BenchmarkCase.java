package com.alibaba.study.benchmark;

public interface BenchmarkCase {
	void init();

	String getName();

	void execute();
}
