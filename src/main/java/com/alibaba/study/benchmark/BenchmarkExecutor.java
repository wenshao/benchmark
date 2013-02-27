package com.alibaba.study.benchmark;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.study.benchmark.xcase.*;

public class BenchmarkExecutor {
	private List<BenchmarkCase> caseList = new ArrayList<BenchmarkCase>();

	private int loopCount = 20;

	private int executeCount = 1000 * 1000 * 1;

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

	public void execute() throws Exception {
		System.out.println("java.runtime.version "
				+ System.getProperty("java.runtime.version"));

		for (int i = 0; i < caseList.size(); ++i) {
			executeCase(caseList.get(i));
		}
	}

	private void executeCase(BenchmarkCase xcase) throws Exception {
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
//		executor.getCaseList().add(new AtomicIntegerIncrement());
//		executor.getCaseList().add(new AtomicLongIncrement());
//		executor.getCaseList().add(new AtomicLongX10Increment());
//		executor.getCaseList().add(new IntIncrement());
//		executor.getCaseList().add(new LongIncrement());
//		executor.getCaseList().add(new IntVolatileIncrement());
//		executor.getCaseList().add(new LongVolatileIncrement());
//		executor.getCaseList().add(new LongVolatileX10Increment());
//		executor.getCaseList().add(new IntIncrementX1000());
//		executor.getCaseList().add(new LongIncrementX1000());
//		executor.getCaseList().add(new LockLongIncrementX10());
//		executor.getCaseList().add(new SystemCurrentMillis());
//		executor.getCaseList().add(new SystemNano());
//		executor.getCaseList().add(new LockLockFair());
//		executor.getCaseList().add(new LockLockUnfair());
//		executor.getCaseList().add(new LockTryLock());
//		executor.getCaseList().add(new LockTryLockWithTime());
//		executor.getCaseList().add(new Synchronized());
//		executor.getCaseList().add(new HashMap_String_Get());
//		executor.getCaseList().add(new ReflectNew());
//		executor.getCaseList().add(new ReflectInvoke());
//		executor.getCaseList().add(new ReflectGetField());
//		executor.getCaseList().add(new ReflectGetField2());
//		executor.getCaseList().add(new ReflectGetMethod());
//		executor.getCaseList().add(new ReflectGetConstructor());
//		executor.getCaseList().add(new ReflectClassForName());
//		executor.getCaseList().add(new ReflectConstructorNew());
//		executor.getCaseList().add(new ThrowException());
//		executor.getCaseList().add(new ThrowNewException());
//		executor.getCaseList().add(new ThrowNewExceptionNoneStackTrace());
//		executor.getCaseList().add(new ExceptionNew());
//		executor.getCaseList().add(new ExceptionNewGetStackTrace());
//		executor.getCaseList().add(new ThreadGetStackTrace());
//		executor.getCaseList().add(new AES_Encrypt());
//		executor.getCaseList().add(new AES_Decrypt());
//		executor.getCaseList().add(new MD5());
//		executor.getCaseList().add(new SEC_RSA_Encrypt());
//		executor.getCaseList().add(new SEC_RSA_Decrypt());
//		executor.getCaseList().add(new DES_Decrypt());
//		executor.getCaseList().add(new SEC_DES_Encrypt());
//		executor.getCaseList().add(new SEC_DESede_Encrypt());
//		executor.getCaseList().add(new SEC_DESede_Decrypt());
//		executor.getCaseList().add(new SEC_Blowfish_Encrypt());
//		executor.getCaseList().add(new SEC_Blowfish_Decrypt());
//		executor.getCaseList().add(new SEC_RC2_Encrypt());
//		executor.getCaseList().add(new SEC_RC2_Decrypt());
//		executor.getCaseList().add(new SEC_RSA_KeyGen());
//		executor.getCaseList().add(new SEC_EC_Encrypt());
//		executor.getCaseList().add(new SEC_MD2());
//		executor.getCaseList().add(new SEC_RSA_Sign());
//		executor.getCaseList().add(new SEC_RSA_Verify());
//		executor.getCaseList().add(new SEC_EC_Sign());
//		executor.getCaseList().add(new SEC_EC_Verify());
		
//		executor.getCaseList().add(new SEC_RANDOM_RandomUUID());
//		executor.getCaseList().add(new SEC_RANDOM_SecRandom());
//		executor.getCaseList().add(new SEC_RANDOM_Random());
//		executor.getCaseList().add(new SEC_RANDOM_ThreadLocalRandom());
		
//		executor.getCaseList().add(new StringChatAt());
//		executor.getCaseList().add(new StringtoCharArray());
//		executor.getCaseList().add(new SystemIdentityHashCode());
//		executor.getCaseList().add(new ArrayCopy());
//		executor.getCaseList().add(new ArraySystemArrayCopy());
//		executor.getCaseList().add(new CharArrayCopy());
//		executor.getCaseList().add(new CharArraySystemArrayCopy());
//		executor.getCaseList().add(new ObjectArrayCopy());
		executor.getCaseList().add(new ObjectArraySystemArrayCopy());
//		executor.getCaseList().add(new ObjectArrayCopyOf());
		
		//SystemIdentityHashCode
		//StringtoCharArray
		
		//SEC_EC_Sign
		//SEC_RSA_Verify
		
		executor.execute();
	}
}
