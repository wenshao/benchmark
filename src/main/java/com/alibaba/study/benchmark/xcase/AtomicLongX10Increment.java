package com.alibaba.study.benchmark.xcase;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongX10Increment extends BenchmarkCaseAdapter {
	private final AtomicLong c0 = new AtomicLong(0);
	private final AtomicLong c1 = new AtomicLong(0);
	private final AtomicLong c2 = new AtomicLong(0);
	private final AtomicLong c3 = new AtomicLong(0);
	private final AtomicLong c4 = new AtomicLong(0);
	private final AtomicLong c5 = new AtomicLong(0);
	private final AtomicLong c6 = new AtomicLong(0);
	private final AtomicLong c7 = new AtomicLong(0);
	private final AtomicLong c8 = new AtomicLong(0);
	private final AtomicLong c9 = new AtomicLong(0);

	public AtomicLongX10Increment() {
		super("AtomicLong.x10.increment");
	}

	public void execute() {
		c0.incrementAndGet();
		c1.incrementAndGet();
		c2.incrementAndGet();
		c3.incrementAndGet();
		c4.incrementAndGet();
		c5.incrementAndGet();
		c6.incrementAndGet();
		c7.incrementAndGet();
		c8.incrementAndGet();
		c9.incrementAndGet();
	}

	public AtomicLong getC0() {
		return c0;
	}

	public AtomicLong getC1() {
		return c1;
	}

	public AtomicLong getC2() {
		return c2;
	}

	public AtomicLong getC3() {
		return c3;
	}

	public AtomicLong getC4() {
		return c4;
	}

	public AtomicLong getC5() {
		return c5;
	}

	public AtomicLong getC6() {
		return c6;
	}

	public AtomicLong getC7() {
		return c7;
	}

	public AtomicLong getC8() {
		return c8;
	}

	public AtomicLong getC9() {
		return c9;
	}

}
