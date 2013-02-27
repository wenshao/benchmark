package com.alibaba.study.benchmark.xcase;

public class CharArrayCopy extends BenchmarkCaseAdapter {
	private char[] bytes;
	private char[] dest;

	public CharArrayCopy() {
		super("ArrayCopy");
	}

	public void init() throws Exception {
		bytes = new char[1000];
		dest = new char[1000];
		for (int i = 0; i < bytes.length; ++i) {
			bytes[i] = (char) i;
		}
	}

	public void execute() {
		for (int i = 0; i < 16; ++i) {
			dest[i] = bytes[i];
		}
	}

}
