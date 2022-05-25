package com.ds.array;

import java.util.Arrays;

public class KDiffPair {
    public int findPairs(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        if(nums.length < 2) {
            return count;
        }
        Arrays.sort(nums);
        int i = 0, j=1;
        int slow = nums[i];
        int fast = nums[j];
        int lastSlow = slow-1;
        int lastFast = fast-1;
        while(j< n) {
            if(i==j) {
                j++;
                continue;
            }
            slow = nums[i];
            fast = nums[j];
            if(lastSlow == slow) {
                i++;
                continue;
            }
            if(lastFast == fast) {
                j++;
                continue;
            }
            if((nums[j] - nums[i]) == k) {
                count++;
                lastSlow = nums[i];
                lastFast = nums[j];
                i++;
                j++;
            } else if((nums[j] - nums[i]) > k) {
                lastSlow = nums[i];
                i++;
            } else if((nums[j] - nums[i]) < k) {
                lastFast = nums[j];
                j++;
            }

        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,4,1,5}; int k =2;
//        int[] nums = {1,2,3,4,5}; int k =1;
//        int[] nums = {1,3,1,5,4}; int k =0;
        KDiffPair kDiffPair = new KDiffPair();
        int pairs = kDiffPair.findPairs(nums, k);
        System.out.println(pairs);
    }
}
