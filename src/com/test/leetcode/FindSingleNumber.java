package com.test.leetcode;

public class FindSingleNumber {

	static final int INT_SIZE = 32;
    
	public int singleNumber(int[] nums) {
        int INT_SIZE = 32;
        int n = nums.length;
        int result = 0;
        int x, sum;
        for(int i=0; i<INT_SIZE; i++)
        {
            sum = 0;
            x = (1 << i);
            for(int j=0; j<n; j++)
            {
                if((nums[j] & x) == 0)
                sum++;
            }
            if ((sum % 2) == 0)
            result |= x;
        }
        return result;
    }
}
