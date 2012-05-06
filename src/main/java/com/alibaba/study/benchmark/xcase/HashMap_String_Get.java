package com.alibaba.study.benchmark.xcase;

import java.util.HashMap;

public class HashMap_String_Get extends BenchmarkCaseAdapter {
	private HashMap<String, Object> map = new HashMap<String, Object>();
	
	public HashMap_String_Get() {
		super("HashMap<String,Object>.get()");
	}
	
	public void init() {
		for (int i = 0; i < 1000; ++i) {
			map.put(Integer.toString(i), new Object());
		}
	}
	
	public void execute() {
		map.get("3");
	}

}
