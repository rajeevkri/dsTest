package com.test.leetcode;

import java.util.List;

public class FindTrappedWater {

	/**
	 * Given n non-negative integers representing an elevation map where the width
	 * of each bar is 1, compute how much water it is able to trap after raining.
	 * 
	 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	 * 
	 * @param height
	 * @return
	 */
	public int trap(int[] height) {
		// left[i] contains height of tallest bar to the
		// left of i'th bar including itself
		int n = height.length;
		if (n == 0) {
			return 0;
		}
		int left[] = new int[n];

		// Right [i] contains height of tallest bar to
		// the right of ith bar including itself
		int right[] = new int[n];

		// Initialize result
		int water = 0;

		// Fill left array
		left[0] = height[0];
		for (int i = 1; i < n; i++)
			left[i] = Math.max(left[i - 1], height[i]);

		// Fill right array
		right[n - 1] = height[n - 1];
		for (int i = n - 2; i >= 0; i--)
			right[i] = Math.max(right[i + 1], height[i]);

		// Calculate the accumulated water element by element
		// consider the amount of water on i'th bar, the
		// amount of water accumulated on this particular
		// bar will be equal to min(left[i], right[i]) - arr[i] .
		for (int i = 0; i < n; i++)
			water += Math.min(left[i], right[i]) - height[i];

		return water;
	}

}
