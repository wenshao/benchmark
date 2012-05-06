package com.alibaba.study.benchmark.xcase;


public class SystemCurrentMillis extends BenchmarkCaseAdapter {
	private long millis;

	public SystemCurrentMillis() {
		super("System.currentTimeMillis");
	}

	public void execute() {
		millis = System.currentTimeMillis();
	}

	public long getMillis() {
		return millis;
	}

	public void setMillis(long millis) {
		this.millis = millis;
	}

}
