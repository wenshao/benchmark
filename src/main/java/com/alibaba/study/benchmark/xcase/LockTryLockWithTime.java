package com.alibaba.study.benchmark.xcase;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTryLockWithTime extends BenchmarkCaseAdapter {
	private Lock lock = new ReentrantLock();
	private int value;

	public LockTryLockWithTime() {
		super("ReentrantLock.tryLockWithTime");
	}

	public void execute() {
		boolean locked;
		try {
			locked = lock.tryLock(3, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			return;
		}
		
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
