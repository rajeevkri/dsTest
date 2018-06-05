package com.test.leetcode.contest49;

public class NumberOfLongestIncreasingSubsequence {

	public static int findNumberOfLIS(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}
		int[] T = new int[n];
		for (int i = 0; i < n; i++) {
			T[i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (T[j] + 1 > T[i]) {
						T[i] = T[j] + 1;
					}
				}
			}
		}
		int count = 0;
		int first = T[0];
		int second = 0;
		int third = T[0];
		boolean seq = false;
		for (int i = 0; i < n - 1; i++) {// T= [1, 2, 3, 3, 4, 2, 5]
			if (third > second && !seq) {
				count++;
				seq = true;
			} else if (third > second) {

			} else if (third > first) {

			}
		}
		for (int i = n - 1; i > 0; i--) {

		}
		return count;
	}

	static int countSub(int nums[]) {
		int n = nums.length;
		int[] count = new int[10];

		for (int i = 0; i < n; i++) {
			for (int j = nums[i] - 1; j >= 0; j--)
				count[nums[i]] += count[j];

			count[nums[i]]++;
		}

		int result = 0;
		for (int i = 0; i < 10; i++)
			result += count[i];

		return result;
	}

//	public static void main(String[] args) {
//		int arr[] = { 1, 3, 5, 4, 7, 2, 8 };
//		System.out.println(countSub(arr));
//	}
	
	static long calculateAmount(int[] prices) {
        int n = prices.length;
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return prices[0];
        }
        long total = prices[0];
        int min = prices[0];
        for(int i=1;i<n;i++) {
            if(prices[i] < min) {
                min = prices[i];
            } else {
                total = total + prices[i] - min;
            }
        }
        return total;
    }
	class A {
		
	}
	
	class B extends A {
		
	}
	class C extends B {
		
	}
	public static void main(String[] args) {
		NumberOfLongestIncreasingSubsequence x = new NumberOfLongestIncreasingSubsequence();
		Object o = x.new B();
		System.out.println((o instanceof B) && (! (o instanceof C)));
	}
}
