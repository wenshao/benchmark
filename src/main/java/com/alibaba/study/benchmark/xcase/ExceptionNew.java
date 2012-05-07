package com.alibaba.study.benchmark.xcase;

public class ExceptionNew extends BenchmarkCaseAdapter {
	private Exception exception;

	public ExceptionNew() {
		super("Exception.new");
	}

	public void execute() {
		exception = new RuntimeException();
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

}
