package com.alibaba.study.benchmark.xcase;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectGetMethod extends BenchmarkCaseAdapter {
	private Class<X> clazz;
	private Method method;

	public ReflectGetMethod() {
		super("Reflect.getField2");
	}

	public void init() {
		clazz = X.class;
		
	}

	public void execute() {
		try {
			method = clazz.getMethod("getValue");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Method getValue() {
		return method;
	}


	public static class X {
		public int value;
		
		public int getValue() {
			return value;
		}
	}
}
