package com.alibaba.study.benchmark.xcase;

import java.lang.reflect.Field;

public class ReflectGetField extends BenchmarkCaseAdapter {
	private Class<X> clazz;
	private Field field;
	private Object value;

	private X object = new X();

	public ReflectGetField() {
		super("Reflect.getField");
	}

	public void init() {
		clazz = X.class;
		try {
			field = clazz.getField("value");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void execute() {
		try {
			value = field.get(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public static class X {
		public int value;
	}
}
