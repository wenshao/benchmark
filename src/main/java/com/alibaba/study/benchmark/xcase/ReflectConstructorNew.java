package com.alibaba.study.benchmark.xcase;

import java.lang.reflect.Constructor;

public class ReflectConstructorNew extends BenchmarkCaseAdapter {
	private Class<?> clazz;
	private Constructor<?> constructor;
	private Object value;

	public ReflectConstructorNew() {
		super("Reflect.new");
	}

	public void init() {
		clazz = X.class;
		try {
			constructor = clazz.getConstructor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void execute() {
		try {
			value = constructor.newInstance();
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
