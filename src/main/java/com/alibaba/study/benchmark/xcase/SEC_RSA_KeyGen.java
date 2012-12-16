package com.alibaba.study.benchmark.xcase;

import java.security.KeyPairGenerator;

public class SEC_RSA_KeyGen extends BenchmarkCaseAdapter {

	public SEC_RSA_KeyGen() {
		super("RSA-KeyGen");
	}

	public void init() throws Exception {

	}

	public void execute() throws Exception {
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		keyPairGen.initialize(3072);
		keyPairGen.generateKeyPair();
	}
}
