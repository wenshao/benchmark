package com.alibaba.study.benchmark.xcase;

public class ExceptionNewGetStackTrace extends BenchmarkCaseAdapter {
	private Exception exception;
	private StackTraceElement[] stackTrace;

	public ExceptionNewGetStackTrace() {
		super("Exception.new&getStackTrace");
	}

	public void execute() {
		exception = new RuntimeException();
		stackTrace = exception.getStackTrace();
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public StackTraceElement[] getStackTrace() {
		return stackTrace;
	}

}
