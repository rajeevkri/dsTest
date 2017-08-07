package com.test.common;

import org.junit.Test;

public class OperationsTest {
	Operations ops = new Operations();

	@org.junit.Test
	public void testFindFourElements() {
		int arr[] = { 10, 20, 30, 40, 1, 2 };
		int n = arr.length;
		int X = 91;
		ops.findFourElements(arr, n, X);
	}
	
	@Test
	public void testPermute(){
		ops.permute("sfjsa", 0, 4);
	}
}
