package com.alibaba.study.benchmark.xcase;

public class ThrowException extends BenchmarkCaseAdapter {
	private Exception exception = new Exception();
	private int index;
	private Exception error;
	
	public ThrowException() {
		super("Exception.throw-catch");
	}

	public void execute() {
		try {
			int v = index++ % 3;
			if (v == 0) {
				f();
			} else if (v == 1) {
				f1();
			} else {
				f2();
			}
		} catch (Exception ex) {
			error = ex;
		}
	}

	public void f() throws Exception {
		throw exception;
	}

	public void f1() throws Exception {
		throw exception;
	}

	public void f2() throws Exception {
		throw exception;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

}
