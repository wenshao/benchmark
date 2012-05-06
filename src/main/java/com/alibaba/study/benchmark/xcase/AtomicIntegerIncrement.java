package com.alibaba.study.benchmark.xcase;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerIncrement extends BenchmarkCaseAdapter {
	private final AtomicInteger counter = new AtomicInteger(0);
	public AtomicIntegerIncrement() {
		super("AtomicInteger.increment");
	}
	
	public void execute() {
		counter.incrementAndGet();
	}
}
