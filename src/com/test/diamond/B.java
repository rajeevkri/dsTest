package com.test.diamond;

public interface B extends A{
	default void method(){
		System.out.println("test B");
	}
}
