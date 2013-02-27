package com.alibaba.study.benchmark.xcase;

public class ObjectArraySystemArrayCopy extends BenchmarkCaseAdapter {
	private Object[] bytes;
	private Object[] dest;

	public ObjectArraySystemArrayCopy() {
		super("System.arrayCopy");
	}

	public void init() throws Exception {
		bytes = new Object[1000];
		dest = new Object[1000];
		for (int i = 0; i < bytes.length; ++i) {
			bytes[i] = (char) i;
		}
	}

	public void execute() {
		System.arraycopy(bytes, 0, dest, 0, 8);
	}

}
