package com.alibaba.study.benchmark;

public class X {
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 1000; ++i) {
			System.out.println("c" + i + "++;");
		}
	}
}
