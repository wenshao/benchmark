package com.alibaba.study.benchmark.xcase;

public class LongVolatileIncrement extends BenchmarkCaseAdapter {
	private volatile long value;

	public LongVolatileIncrement() {
		super("LongVolatile.inc");
	}

	public void execute() {
		value++;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

}
