package com.alibaba.study.benchmark.xcase;

public class ArraySystemArrayCopy extends BenchmarkCaseAdapter {
	private byte[] bytes;
	private byte[] dest;

	public ArraySystemArrayCopy() {
		super("System.arrayCopy");
	}

	public void init() throws Exception {
		bytes = new byte[1000];
		dest = new byte[1000];
		for (int i = 0; i < bytes.length; ++i) {
			bytes[i] = (byte) i;
		}
	}

	public void execute() {
		System.arraycopy(bytes, 0, dest, 0, 16);
	}

}
