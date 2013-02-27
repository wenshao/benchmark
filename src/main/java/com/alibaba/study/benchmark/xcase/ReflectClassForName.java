package com.alibaba.study.benchmark.xcase;

public class ReflectClassForName extends BenchmarkCaseAdapter {
	private Class<?> clazz;

	public ReflectClassForName() {
		super("Reflect.classForName");
	}

	public void init() {
	}

	public void execute() {
		try {
			clazz = Class.forName("java.lang.System");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object getValue() {
		return clazz;
	}

}
