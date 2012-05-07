package com.alibaba.study.benchmark.xcase;


public class Synchronized extends BenchmarkCaseAdapter {
	private Object lock = new Object();
	private int value;

	public Synchronized() {
		super("synchronized");
	}

	public void execute() {
		synchronized (lock) {
			value = 0;
		}
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
