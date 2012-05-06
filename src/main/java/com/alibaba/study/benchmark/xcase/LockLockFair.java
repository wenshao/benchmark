package com.alibaba.study.benchmark.xcase;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockLockFair extends BenchmarkCaseAdapter {
	private Lock lock = new ReentrantLock(true);
	private int value;

	public LockLockFair() {
		super("ReentrantLock.lockFair");
	}

	public void execute() {
		lock.lock();
		try {
			value = 0;
		} finally {
			lock.unlock();
		}
	}

	public Lock getLock() {
		return lock;
	}

	public void setLock(Lock lock) {
		this.lock = lock;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
