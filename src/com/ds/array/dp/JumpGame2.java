package com.ds.array.dp;

import java.util.Arrays;

public class JumpGame2 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
//        int [] nums = {3,2,1,0,4};
//        int [] nums ={0,2,3};
        JumpGame2 jg = new JumpGame2();
        int isPossible = jg.jump(nums);
        System.out.println(isPossible);
    }

    public int jump(int[] nums) {
        int l = nums.length;
        int[] jumps = new int[l];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0;
        for(int i =0; i< l; i++) {
            int k = nums[i];
            int x = jumps[i];
            for (int j=0; j<k; j++) {
                if(j + i+1 > l-1) break;
                jumps[j + i+1] = Math.min(jumps[j + i+1], x+1);
            }
        }
        return jumps[l-1];
    }
}
