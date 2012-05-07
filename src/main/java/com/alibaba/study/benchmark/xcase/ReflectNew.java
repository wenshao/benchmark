package com.alibaba.study.benchmark.xcase;

public class ReflectNew extends BenchmarkCaseAdapter {
	private Class<?> clazz;
	private Object value;

	public ReflectNew() {
		super("Reflect.new");
	}

	public void init() {
		clazz = X.class;
	}

	public void execute() {
		try {
			value = clazz.newInstance();
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

	}
}
