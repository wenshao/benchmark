package com.alibaba.study.benchmark.xcase;

import java.lang.reflect.Field;

public class ReflectGetField2 extends BenchmarkCaseAdapter {
	private Class<X> clazz;
	private Field field;

	public ReflectGetField2() {
		super("Reflect.getField2");
	}

	public void init() {
		clazz = X.class;
		
	}

	public void execute() {
		try {
			field = clazz.getField("value");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Field getValue() {
		return field;
	}


	public static class X {
		public int value;
	}
}
