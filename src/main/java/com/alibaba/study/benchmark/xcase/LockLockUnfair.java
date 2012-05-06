package com.alibaba.study.benchmark.xcase;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockLockUnfair extends BenchmarkCaseAdapter {
	private Lock lock = new ReentrantLock();
	private int value;

	public LockLockUnfair() {
		super("ReentrantLock.lock");
	}

	public void execute() {
		lock.lock();
		try {
			value = 0;
		} finally {
			lock.unlock();
		}
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
