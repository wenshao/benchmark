package com.alibaba.study.benchmark.xcase;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongIncrement extends BenchmarkCaseAdapter {
	private final AtomicLong counter = new AtomicLong(0);

	public AtomicLongIncrement() {
		super("AtomicLong.increment");
	}

	public void execute() {
		counter.incrementAndGet();
	}

	public AtomicLong getCounter() {
		return counter;
	}

}
