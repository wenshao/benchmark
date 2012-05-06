package com.alibaba.study.benchmark.xcase;

public class IntVolatileIncrement extends BenchmarkCaseAdapter {
	private volatile int value;

	public IntVolatileIncrement() {
		super("IntVolatile.inc");
	}

	public void execute() {
		value++;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
