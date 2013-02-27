package com.alibaba.study.benchmark.xcase;

import java.lang.reflect.Constructor;

public class ReflectGetConstructor extends BenchmarkCaseAdapter {
	private Class<X> clazz;
	private Constructor<?> constrcutor;

	public ReflectGetConstructor() {
		super("Reflect.getField2");
	}

	public void init() {
		clazz = X.class;
		
	}

	public void execute() {
		try {
			constrcutor = clazz.getConstructor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Constructor<?> getValue() {
		return constrcutor;
	}


	public static class X {
		public int value;
	}
}
