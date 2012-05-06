package com.alibaba.study.benchmark.xcase;


public class LongIncrement extends BenchmarkCaseAdapter {
	private long value;

	public LongIncrement() {
		super("Long.inc1000");
	}

	public void execute() {
		for (int i = 0; i < 1000; ++i) {
			value++;
		}
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

}
