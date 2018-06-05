package com.test.leetcode.contest49;

public class TipTop {
	static final Integer i1 = 1;
	final Integer i2 =2;
	Integer i3 = 3;
	static String str;
	public TipTop() {
		System.out.println("In cons");
		str = "Hello world";
	}
	public static void main(String[] args) {
//		System.out.println(str);
//		final Integer i4 = 4;
//		Integer i5 = 5;
//		class Inner {
//			final Integer i6 = 6;
//			Integer i7 = 7;
//			Inner() {
//				System.out.println(i6 +i7);;
//			}
//		}
		boolean b1= true;
		boolean b2 = false;
		boolean b3 = true;
		if(b1&b2 | b2 & b3 |b2) 
			System.out.println("Ok");
		if(b1&b2 | b2 & b3 |b2 | b1) 
			System.out.println("dookay");
	}
}
