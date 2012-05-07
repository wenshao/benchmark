package com.alibaba.study.benchmark.xcase;

import java.util.concurrent.locks.ReentrantLock;

public class LockLongIncrementX10 extends BenchmarkCaseAdapter {
	private ReentrantLock lock = new ReentrantLock();

	private long v0;
	private long v1;
	private long v2;
	private long v3;
	private long v4;
	private long v5;
	private long v6;
	private long v7;
	private long v8;
	private long v9;

	public LockLongIncrementX10() {
		super("long++.x10.lock");
	}

	public void execute() {
		lock.lock();
		try {
			v0++;
			v1++;
			v2++;
			v3++;
			v4++;
			v5++;
			v6++;
			v7++;
			v8++;
			v9++;
		} finally {
			lock.unlock();
		}
	}

	public long getV0() {
		return v0;
	}

	public void setV0(long v0) {
		this.v0 = v0;
	}

	public long getV1() {
		return v1;
	}

	public void setV1(long v1) {
		this.v1 = v1;
	}

	public long getV2() {
		return v2;
	}

	public void setV2(long v2) {
		this.v2 = v2;
	}

	public long getV3() {
		return v3;
	}

	public void setV3(long v3) {
		this.v3 = v3;
	}

	public long getV4() {
		return v4;
	}

	public void setV4(long v4) {
		this.v4 = v4;
	}

	public long getV5() {
		return v5;
	}

	public void setV5(long v5) {
		this.v5 = v5;
	}

	public long getV6() {
		return v6;
	}

	public void setV6(long v6) {
		this.v6 = v6;
	}

	public long getV7() {
		return v7;
	}

	public void setV7(long v7) {
		this.v7 = v7;
	}

	public long getV8() {
		return v8;
	}

	public void setV8(long v8) {
		this.v8 = v8;
	}

	public long getV9() {
		return v9;
	}

	public void setV9(long v9) {
		this.v9 = v9;
	}

}
