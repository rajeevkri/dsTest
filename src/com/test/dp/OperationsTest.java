package com.test.dp;

import org.junit.Test;

public class OperationsTest {
	Operations ops = new Operations();
	@Test
	public void testMaximumSubsequence() {
		 int arr[] = {1, 101, 10, 2, 3, 100,4};
	        int r = ops.maximumSumIncreasingSubsequence(arr);
	        System.out.print(r);
//	        Assert.assertEquals(1, 1);
	}
	
	@Test
	public void testFindMaxSum(){
        int arr[] = new int[]{5, 5, 10, 100, 10, 5};
        System.out.println(ops.findMaxSum(arr, arr.length));
	}
}
