package com.alibaba.study.benchmark.xcase;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Signature;

public class SEC_EC_Sign extends BenchmarkCaseAdapter {
	private Signature signature;
	private byte[] plainBytes;
	private byte[] signedBytes;

	public SEC_EC_Sign() {
		super("EC-Sign");
	}

	public void init() throws Exception {
		plainBytes = new byte[1024]; // 1k

		SecureRandom random = new SecureRandom();
		random.nextBytes(plainBytes);

		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("EC");
		keyPairGen.initialize(112);
		KeyPair keyPair = keyPairGen.generateKeyPair();
//		PublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();
		signature = Signature.getInstance("SHA1withECDSA");

		signature.initSign(privateKey);
		
		signature.update(plainBytes);
		signedBytes = signature.sign();
	}
	// 

	public void execute() throws Exception {
		signature.update(plainBytes);
		signedBytes = signature.sign();
	}
}
