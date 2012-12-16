package com.alibaba.study.benchmark.concurrent;

import java.lang.management.ManagementFactory;
import java.text.NumberFormat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import junit.framework.TestCase;

public class BlockingQueueTest extends TestCase {
	static final int elementCount = 1000 * 1000 * 10;
	
	public BlockingQueueTest() {
		// super("BlockingQueue");
	}

	public void init() throws Exception {
	}

	public void test_x() throws Exception {
		System.out.println("java.runtime.version "
				+ System.getProperty("java.runtime.version"));

		BlockingQueue<Integer> q;

		q = new java.util.concurrent.LinkedTransferQueue<Integer>();
//		 q = new jsr166y.LinkedTransferQueue<Integer>();
//		 q = new java.util.concurrent.LinkedBlockingQueue<Integer>();
//		 q = new java.util.concurrent.ArrayBlockingQueue<Integer>(1000 *
//		 1);
		int producerCount = 1;
		int consumerCount = 2;

		System.out.println("producers " + producerCount);
		System.out.println("consumers " + consumerCount);

		long totalMillis = 0;
		long startYgc = getYoungGC();

		NumberFormat format = NumberFormat.getInstance();
		for (int i = 0; i < 10; ++i) {
//			long millis = execute(q, producerCount, consumerCount);
			long millis = flow(q);
			System.out.println(q.getClass().getName() + " millis "
					+ format.format(millis));
			totalMillis += millis;
		}

		long ygc = getYoungGC() - startYgc;
		System.out.println("total " + format.format(totalMillis) + " ygc " + ygc);
	}
	
	public final static long flow(final BlockingQueue<Integer> q) throws Exception {
		long startMillis = System.currentTimeMillis();
		for (int i = 0; i < elementCount; ++i) {
			q.put(i);
			q.take();
		}
		
		long millis = System.currentTimeMillis() - startMillis;

		return millis;
	}

	public final static long execute(final BlockingQueue<Integer> q,
			final int producerCount, final int consumerCount) throws Exception {
		final CountDownLatch startLatch = new CountDownLatch(1);
		final CountDownLatch endLatch = new CountDownLatch(consumerCount
				+ producerCount);

		
		for (int i = 0; i < producerCount; ++i) {
			Thread producer = new Thread() {
				public void run() {
					try {
						startLatch.await();
						for (int i = 0; i < elementCount / producerCount; ++i) {
							q.put(i);
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						endLatch.countDown();
					}
				}
			};
			producer.start();
		}

		for (int i = 0; i < consumerCount; ++i) {
			Thread consumerThread = new Thread() {
				public void run() {
					try {
						startLatch.await();
						for (int i = 0; i < elementCount / consumerCount; ++i) {
							q.take();
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						endLatch.countDown();
					}
				}
			};
			consumerThread.start();
		}

		long startMillis = System.currentTimeMillis();
		startLatch.countDown();
		endLatch.await();
		long millis = System.currentTimeMillis() - startMillis;

		return millis;
	}

	public static long getYoungGC() {
		try {
			MBeanServer mbeanServer = ManagementFactory
					.getPlatformMBeanServer();
			ObjectName objectName;
			if (mbeanServer.isRegistered(new ObjectName(
					"java.lang:type=GarbageCollector,name=ParNew"))) {
				objectName = new ObjectName(
						"java.lang:type=GarbageCollector,name=ParNew");
			} else if (mbeanServer.isRegistered(new ObjectName(
					"java.lang:type=GarbageCollector,name=Copy"))) {
				objectName = new ObjectName(
						"java.lang:type=GarbageCollector,name=Copy");
			} else {
				objectName = new ObjectName(
						"java.lang:type=GarbageCollector,name=PS Scavenge");
			}

			return (Long) mbeanServer.getAttribute(objectName,
					"CollectionCount");
		} catch (Exception e) {
			throw new RuntimeException("error");
		}
	}

	public static long getFullGC() {
		try {
			MBeanServer mbeanServer = ManagementFactory
					.getPlatformMBeanServer();
			ObjectName objectName;

			if (mbeanServer
					.isRegistered(new ObjectName(
							"java.lang:type=GarbageCollector,name=ConcurrentMarkSweep"))) {
				objectName = new ObjectName(
						"java.lang:type=GarbageCollector,name=ConcurrentMarkSweep");
			} else if (mbeanServer.isRegistered(new ObjectName(
					"java.lang:type=GarbageCollector,name=MarkSweepCompact"))) {
				objectName = new ObjectName(
						"java.lang:type=GarbageCollector,name=MarkSweepCompact");
			} else {
				objectName = new ObjectName(
						"java.lang:type=GarbageCollector,name=PS MarkSweep");
			}

			return (Long) mbeanServer.getAttribute(objectName,
					"CollectionCount");
		} catch (Exception e) {
			throw new RuntimeException("error");
		}
	}
}
