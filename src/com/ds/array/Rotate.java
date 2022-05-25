package com.ds.array;

import java.util.Arrays;

public class Rotate {
    public void rotate(int[] nums, int k) {

        int l = nums.length;
        k = k % l;
        int[] output = new int[l];
        int start = l - k;
        int j =0;
        for(int i =start ;i <l; i++) {
            output[j++] = nums[i];
        }
        for(int i= 0; i<start; i++) {
            output[j++] = nums[i];
        }
        for (int i = 0; i < l; i++)
            nums[i] = output[i];
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7};//[-1,0,3,5,9,12]
        int target = 3;
        Rotate rotate = new Rotate();
        rotate.rotate(nums, target);
        System.out.println(Arrays.toString(nums));
    }
}
