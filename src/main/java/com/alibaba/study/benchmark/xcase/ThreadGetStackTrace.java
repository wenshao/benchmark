package com.alibaba.study.benchmark.xcase;

public class ThreadGetStackTrace extends BenchmarkCaseAdapter {
	private StackTraceElement[] stackTrace;

	public ThreadGetStackTrace() {
		super("Thread.getStackTrace");
	}

	public void execute() {
		stackTrace = Thread.currentThread().getStackTrace();
	}

	public void f() throws Exception {
		throw new RuntimeException();
	}

	public StackTraceElement[] getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(StackTraceElement[] stackTrace) {
		this.stackTrace = stackTrace;
	}

}
