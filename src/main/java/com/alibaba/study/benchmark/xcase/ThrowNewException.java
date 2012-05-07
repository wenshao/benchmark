package com.alibaba.study.benchmark.xcase;

public class ThrowNewException extends BenchmarkCaseAdapter {
	private Exception exception;
	private int index;

	public ThrowNewException() {
		super("Exception.new-throw-catch");
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
