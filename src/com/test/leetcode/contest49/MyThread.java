package com.test.leetcode.contest49;

public class MyThread extends Thread {

	public MyThread() {
		System.out.println(" MyThread");
	}
	
	public void run() {
		System.out.println(" bar");
	}
	
	public void run(String s) {
		System.out.println(" baz");
	}
}
