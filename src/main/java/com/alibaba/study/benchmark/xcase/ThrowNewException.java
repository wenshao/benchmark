package com.alibaba.study.benchmark.xcase;

public class ThrowNewException extends BenchmarkCaseAdapter {
	private Exception exception;

	public ThrowNewException() {
		super("Exception.new-throw-catch");
	}

	public void execute() {
		try {
			f();
		} catch (Exception ex) {
			exception = ex;
		}
	}

	public void f() throws Exception {
		throw new RuntimeException();
	}

	public void f1() throws Exception {
		throw new RuntimeException();
	}

	public void f2() throws Exception {
		throw new RuntimeException();
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

}
