package com.alibaba.study.benchmark.xcase;


public class ThrowException extends BenchmarkCaseAdapter {
	private int value;

	public ThrowException() {
		super("Exception.throw-catch");
	}

	public void execute() {
		try {
			f();
		} catch (Exception ex) {
			// skip
		}
	}
	
	public void f() throws Exception {
		throw new RuntimeException();
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
