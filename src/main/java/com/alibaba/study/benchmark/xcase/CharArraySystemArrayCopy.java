package com.alibaba.study.benchmark.xcase;

public class CharArraySystemArrayCopy extends BenchmarkCaseAdapter {
	private char[] bytes;
	private char[] dest;

	public CharArraySystemArrayCopy() {
		super("System.arrayCopy");
	}

	public void init() throws Exception {
		bytes = new char[1000];
		dest = new char[1000];
		for (int i = 0; i < bytes.length; ++i) {
			bytes[i] = (char) i;
		}
	}

	public void execute() {
		System.arraycopy(bytes, 0, dest, 0, 16);
	}

}
