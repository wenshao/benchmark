package com.alibaba.study.benchmark.xcase;


public class StringtoCharArray extends BenchmarkCaseAdapter {
	private String text = "";
	private char ch;

	public StringtoCharArray() {
		super("String.charAt");
	}

	public void init() {
		for (int i = 0; i < 1000; ++i) {
			text += (i % 9);
		}
	}

	public void execute() {
		char[] chars = text.toCharArray();
		for (int i = 0; i < chars.length; ++i) {
			ch = text.charAt(i);
		}
	}

	public char getValue() {
		return ch;
	}
}
