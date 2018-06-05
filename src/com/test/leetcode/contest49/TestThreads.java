package com.test.leetcode.contest49;

public class TestThreads {
	public static void main(String[] args) {
		Thread t = new MyThread() {
			@Override
			public void run() {
				System.out.println(" foo");
			}
		};
		t.start();
	}
}
