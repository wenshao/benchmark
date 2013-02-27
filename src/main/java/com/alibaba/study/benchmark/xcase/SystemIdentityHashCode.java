package com.alibaba.study.benchmark.xcase;


public class SystemIdentityHashCode extends BenchmarkCaseAdapter {
	private Object object;
	private int hashCode;

	public SystemIdentityHashCode() {
		super("System.identityHashCode");
	}

	public void init() {
		object = new Object();
	}

	public void execute() {
		System.identityHashCode(object);
	}

	public Object getValue() {
		return hashCode;
	}
}
