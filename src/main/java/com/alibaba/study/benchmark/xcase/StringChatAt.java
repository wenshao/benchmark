package com.alibaba.study.benchmark.xcase;


public class StringChatAt extends BenchmarkCaseAdapter {
	private String text = "";
	private char ch;

	public StringChatAt() {
		super("String.charAt");
	}

	public void init() {
		for (int i = 0; i < 1000; ++i) {
			text += (i % 9);
		}
	}

	public void execute() {
		for (int i = 0; i < text.length(); ++i) {
			ch = text.charAt(i);
		}
	}

	public char getValue() {
		return ch;
	}
}
