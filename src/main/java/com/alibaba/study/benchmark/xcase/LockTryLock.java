package com.alibaba.study.benchmark.xcase;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTryLock extends BenchmarkCaseAdapter {
	private Lock lock = new ReentrantLock();
	private int value;

	public LockTryLock() {
		super("ReentrantLock.tryLock");
	}

	public void execute() {
		boolean locked = lock.tryLock();
		if (locked) {
			try {
				value = 0;
			} finally {
				lock.unlock();
			}
		}
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
