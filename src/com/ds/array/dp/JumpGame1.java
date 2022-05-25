package com.ds.array.dp;

import java.util.Arrays;

public class JumpGame1 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;

        }
        boolean[] isPossible = new boolean[n];
        Arrays.fill(isPossible, false);
        if (nums[0] > 0)
            isPossible[0] = true;
        for (int i = 0; i < n; i++) {
            boolean lasPossibility = isPossible[i];
            int jumps = nums[i];
            inner:
            for (int j = i + 1, k = 0; k < jumps; k++, j++) {
                if (j == n) {
                    break inner;
                }
                isPossible[j] = lasPossibility;
            }
        }
        return isPossible[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
//        int [] nums = {3,2,1,0,4};
//        int [] nums ={0,2,3};
        JumpGame1 jg = new JumpGame1();
        boolean isPossible = jg.canJump1(nums);
        System.out.println(isPossible);
    }

    public boolean canJump1(int[] nums) {
        int latestGoodIndex = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= latestGoodIndex) {
                latestGoodIndex = i;
            }
        }
        return latestGoodIndex == 0;
    }
}
