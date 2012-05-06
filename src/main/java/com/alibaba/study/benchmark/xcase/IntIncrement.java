package com.alibaba.study.benchmark.xcase;


public class IntIncrement extends BenchmarkCaseAdapter {
	private int value;

	public IntIncrement() {
		super("Int.inc1000");
	}

	public void execute() {
		for (int i = 0; i < 1000; ++i) {
			value++;
		}
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
