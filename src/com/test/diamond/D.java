package com.test.diamond;

public interface D extends B,C{

	@Override
	default void method() {
		C.super.method();
	}

}
