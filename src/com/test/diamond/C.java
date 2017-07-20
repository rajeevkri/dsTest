package com.test.diamond;

public interface C extends A{

	@Override
	default void method() {
		System.out.println("test C");
	}

}
