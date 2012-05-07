package com.alibaba.study.benchmark;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.study.benchmark.xcase.AtomicIntegerIncrement;
import com.alibaba.study.benchmark.xcase.AtomicLongIncrement;
import com.alibaba.study.benchmark.xcase.ExceptionNew;
import com.alibaba.study.benchmark.xcase.ExceptionNewGetStackTrace;
import com.alibaba.study.benchmark.xcase.HashMap_String_Get;
import com.alibaba.study.benchmark.xcase.IntIncrement;
import com.alibaba.study.benchmark.xcase.IntVolatileIncrement;
import com.alibaba.study.benchmark.xcase.LockLockFair;
import com.alibaba.study.benchmark.xcase.LockLockUnfair;
import com.alibaba.study.benchmark.xcase.LongIncrement;
import com.alibaba.study.benchmark.xcase.ReflectGetField;
import com.alibaba.study.benchmark.xcase.ReflectInvoke;
import com.alibaba.study.benchmark.xcase.ReflectNew;
import com.alibaba.study.benchmark.xcase.SystemCurrentMillis;
import com.alibaba.study.benchmark.xcase.SystemNano;
import com.alibaba.study.benchmark.xcase.ThreadGetStackTrace;
<<<<<<< HEAD
import com.alibaba.study.benchmark.xcase.ThrowException;
=======
>>>>>>> branch 'master' of https://wenshao@github.com/wenshao/benchmark.git
import com.alibaba.study.benchmark.xcase.ThrowNewException;

public class BenchmarkExecutor {
	private List<BenchmarkCase> caseList = new ArrayList<BenchmarkCase>();

	private int loopCount = 10;

	private int executeCount = 1000 * 1000;

	public List<BenchmarkCase> getCaseList() {
		return caseList;
	}

	public void setCaseList(List<BenchmarkCase> caseList) {
		this.caseList = caseList;
	}

	public int getLoopCount() {
		return loopCount;
	}

	public void setLoopCount(int loopCount) {
		this.loopCount = loopCount;
	}

	public int getExecuteCount() {
		return executeCount;
	}

	public void setExecuteCount(int executeCount) {
		this.executeCount = executeCount;
	}

	public void execute() {
		System.out.println("java.runtime.version "
				+ System.getProperty("java.runtime.version"));

		for (int i = 0; i < caseList.size(); ++i) {
			executeCase(caseList.get(i));
		}
	}

	private void executeCase(BenchmarkCase xcase) {
		for (int p = 0; p < loopCount; ++p) {
			xcase.init();

			long startMillis = System.currentTimeMillis();
			for (int i = 0; i < executeCount; ++i) {
				xcase.execute();
			}
			long millis = System.currentTimeMillis() - startMillis;
			System.out.println(xcase.getName() + "\t" + millis);
		}
	}

	public static void main(String[] args) throws Exception {
		BenchmarkExecutor executor = new BenchmarkExecutor();
		executor.getCaseList().add(new AtomicIntegerIncrement());
		executor.getCaseList().add(new AtomicLongIncrement());
		executor.getCaseList().add(new IntIncrement());
		executor.getCaseList().add(new LongIncrement());
		executor.getCaseList().add(new IntVolatileIncrement());
		executor.getCaseList().add(new SystemCurrentMillis());
		executor.getCaseList().add(new SystemNano());
		executor.getCaseList().add(new LockLockFair());
		executor.getCaseList().add(new LockLockUnfair());
		executor.getCaseList().add(new HashMap_String_Get());
		executor.getCaseList().add(new ReflectNew());
		executor.getCaseList().add(new ReflectInvoke());
		executor.getCaseList().add(new ReflectGetField());
		executor.getCaseList().add(new ThrowException());
		executor.getCaseList().add(new ThrowNewException());
		executor.getCaseList().add(new ExceptionNew());
		executor.getCaseList().add(new ExceptionNewGetStackTrace());
		executor.getCaseList().add(new ThreadGetStackTrace());

		executor.execute();
	}
}
