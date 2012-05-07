package com.alibaba.study.benchmark.xcase;

import java.lang.reflect.Method;

public class ReflectInvoke extends BenchmarkCaseAdapter {
	private Class<X> clazz;
	private Method method;
	private Object value;

	private X object = new X();

	public ReflectInvoke() {
		super("Reflect.invoke");
	}

	public void init() {
		clazz = X.class;
		try {
			method = clazz.getMethod("f");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void execute() {
		try {
			method.invoke(object);
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
		private int value;

		public int f() {
			return value++;
		}

		public int getValue() {
			return value;
		}

	}
}
