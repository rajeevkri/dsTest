package com.ds.array;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        //scan from right to left find fist element which is less than its right element - that is p
        int p = -1;
        int q = -1;
        for(int i =n-2; i>=0; i--) {
            if(nums[i] < nums[i+1]) {
                p = i;
                break;
            }
        }
        //If no element found reverse the array
        if(p == -1) {
            int m = 0;
            int m1 = n-1;
            while (m<m1) {
                int t = nums[m];
                nums[m] = nums[m1];
                nums[m1] = t;
                m++; m1--;
            }
            return;
        }
        //else scan from right to left, find the first element that is greater than p
        for(int i =n-1; i>p; i--) {
            if(nums[i] > nums[p]) {
                q = i;
                break;
            }
        }
        //swap p and q
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
        //reverse elements [p+1, nums.length]
        int i = p+1;
        int j = n-1;
        while (i<j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }
}
