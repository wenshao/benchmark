package com.alibaba.study.benchmark.xcase;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;

public class SEC_RSA_Verify extends BenchmarkCaseAdapter {
	private Signature signature;
	private byte[] plainBytes;
	private byte[] signedBytes;

	public SEC_RSA_Verify() {
		super("RSA-Verify");
	}

	public void init() throws Exception {
		plainBytes = new byte[32]; // 4k

		SecureRandom random = new SecureRandom();
		random.nextBytes(plainBytes);

		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		keyPairGen.initialize(512);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();

		{
			Signature signature = Signature.getInstance("SHA1withRSA");

			signature.initSign(privateKey);

			signature.update(plainBytes);
			signedBytes = signature.sign();
		}
		
		signature = Signature.getInstance("SHA1withRSA");
		signature.initVerify(publicKey);
	}

	public void execute() throws Exception {
		signature.verify(signedBytes);
	}
}
