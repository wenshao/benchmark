package com.alibaba.study.benchmark.xcase;

import java.util.Arrays;

public class ObjectArrayCopyOf extends BenchmarkCaseAdapter {
	private Object[] bytes;
	private Object[] dest;

	public ObjectArrayCopyOf() {
		super("Array.copyOf");
	}

	public void init() throws Exception {
		bytes = new Object[1000];
		dest = new Object[1000];
		for (int i = 0; i < bytes.length; ++i) {
			bytes[i] = (char) i;
		}
	}

	public void execute() {
		dest = Arrays.copyOf(bytes, 8);
	}

}
