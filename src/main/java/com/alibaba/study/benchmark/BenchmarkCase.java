package com.alibaba.study.benchmark;

public interface BenchmarkCase {
	void init() throws Exception;

	String getName();

	void execute() throws Exception;
}
