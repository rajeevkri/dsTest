package com.test.tree;

public class Test4 {
	class Inner{
		void test(){
			if(Test4.this.flag) {
				sample();
			}
		}

	}
	private boolean flag= true;
	public void sample() {
		System.out.println("sample");
	}
	
	public Test4(){
		(new Inner()).test();
	}
	
	public static void main(String[] args) {
//		new Test4();
		String s1 = "abc";
		String s2 = "def";
		String s3 = s1.concat(s2.toUpperCase());
		System.out.println(s1+s2+s3);
	}
}
