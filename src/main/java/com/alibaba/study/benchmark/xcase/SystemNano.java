package com.alibaba.study.benchmark.xcase;

public class SystemNano extends BenchmarkCaseAdapter {
	private long nano;

	public SystemNano() {
		super("System.nanoTime");
	}

	public void execute() {
		nano = System.nanoTime();
	}

	public long getNano() {
		return nano;
	}

	public void setNano(long nano) {
		this.nano = nano;
	}

}
