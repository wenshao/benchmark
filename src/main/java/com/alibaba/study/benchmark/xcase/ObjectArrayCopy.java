package com.alibaba.study.benchmark.xcase;

public class ObjectArrayCopy extends BenchmarkCaseAdapter {
	private Object[] bytes;
	private Object[] dest;

	public ObjectArrayCopy() {
		super("ArrayCopy");
	}

	public void init() throws Exception {
		bytes = new Object[1000];
		dest = new Object[1000];
		for (int i = 0; i < bytes.length; ++i) {
			bytes[i] = (char) i;
		}
	}

	public void execute() {
		for (int i = 0; i < 8; ++i) {
			dest[i] = bytes[i];
		}
	}

}
