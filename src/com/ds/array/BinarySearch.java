package com.ds.array;

import java.util.Arrays;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        int l = nums.length;
        int res = search(nums, target, 0, l-1);
        return res;
    }

    public static int search(int[] nums, int target, int fromIndex, int toIndex) {
        int res = -1;
        if(fromIndex == toIndex || fromIndex+1 == toIndex) {
            if (nums[fromIndex] == target) {
                res = fromIndex;
            }
            if (nums[toIndex] == target) {
                res = toIndex;
            }

            return res;
        }
        int mid =fromIndex + ((toIndex - fromIndex)/2) ;

        if(nums[mid] == target) {
            res = mid;
        } else if(nums[mid] < target) {
            res = search(nums, target, mid, toIndex);
        } else{
            res = search(nums, target, fromIndex, mid);
        }
        return res;
    }

    public static void main(String[] args) {
        int [] nums = {-1,0,3,5,9,12};//[-1,0,3,5,9,12]
        int target = 9;
        int res = search(nums, target);
        System.out.println(res);
    }

    public int searchInsert(int[] nums, int target) {
        int ind = Arrays.binarySearch(nums, target);
        return ind >= 0?ind: Math.abs(ind) -1;
    }
}
