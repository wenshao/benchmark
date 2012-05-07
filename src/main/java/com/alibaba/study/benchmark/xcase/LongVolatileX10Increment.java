package com.alibaba.study.benchmark.xcase;

public class LongVolatileX10Increment extends BenchmarkCaseAdapter {
	private volatile long v0;
	private volatile long v1;
	private volatile long v2;
	private volatile long v3;
	private volatile long v4;
	private volatile long v5;
	private volatile long v6;
	private volatile long v7;
	private volatile long v8;
	private volatile long v9;

	public LongVolatileX10Increment() {
		super("LongVolatile.x10.inc");
	}

	public void execute() {
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
