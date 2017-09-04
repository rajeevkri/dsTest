package com.test.leetcode;

import java.util.ArrayList;

public class RemoveDuplicatesfromSortedArray {
	public static int removeDuplicates(int[] nums) {
		int count = 1;
		int n = nums.length;
		if (n == 0 || n == 1) {
			return n;
		}
		ArrayList<Integer> iList = new ArrayList<>();
		iList.add(nums[0]);
		for (int i = 1; i < n; i++) {
			if (nums[i] != nums[i - 1]) {
				count++;
				iList.add(nums[i]);
			}
		}
		for (int i = 0; i < count; i++) {
			nums[i] = iList.get(i);
		}
		for (int i = count; i < n; i++) {
			nums[i] = 0;
		}
		return count;
	}

	public static int removeDuplicates(int A[], int n) {
		if (n < 2)
			return n;
		int id = 1;
		for (int i = 1; i < n; ++i)
			if (A[i] != A[i - 1])
				A[id++] = A[i];
		return id;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2 };
		System.out.println(removeDuplicates(arr, 3));
		System.out.println("test");
	}
}
