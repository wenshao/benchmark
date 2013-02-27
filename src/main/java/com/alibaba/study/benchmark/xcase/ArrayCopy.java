package com.alibaba.study.benchmark.xcase;

public class ArrayCopy extends BenchmarkCaseAdapter {
	private byte[] bytes;
	private byte[] dest;

	public ArrayCopy() {
		super("ArrayCopy");
	}

	public void init() throws Exception {
		bytes = new byte[1000];
		dest = new byte[1000];
		for (int i = 0; i < bytes.length; ++i) {
			bytes[i] = (byte) i;
		}
	}

	public void execute() {
		for (int i = 0; i < 16; ++i) {
			dest[i] = bytes[i];
		}
	}

}
