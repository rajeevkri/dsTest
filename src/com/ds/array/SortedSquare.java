package com.ds.array;

public class SortedSquare {

    public static void main(String[] args) {
        SortedSquare sortedSquare = new SortedSquare();
        int[] nums ={-4,-1,0,3,10};
        int[] output = sortedSquare.sortedSquares(nums);
        System.out.println(output);
    }
    public int[] sortedSquares(int[] nums) {
        int l = nums.length;
        int[] output = new int[l];
        int firstPositive = findFirstPositive(nums);
        if(firstPositive == 0) {
            for(int i =0;i <l;i++) {
                output[i] = nums[i] * nums[i];
            }
        }
        if(firstPositive == l-1) {
            for(int i =0;i <l;i++) {
                output[l-i-1] = nums[i] * nums[i];
            }
        }
        int index = 0;
        output[index++] = nums[firstPositive] * nums[firstPositive];
        int fIndex = firstPositive - 1;
        int lIndex = firstPositive + 1;
        while (fIndex >= 0 && lIndex <= l-1) {
            if(index >= l) {
                break;
            }
            int lSqur = (fIndex>=0) ?nums[fIndex] * nums[fIndex] : -1;
            int rSqur = (lIndex<= l-1) ?nums[lIndex] * nums[lIndex]:-1;
            if(lSqur== -1 ) output[index++] = rSqur;
            else if(rSqur== -1) output[index++] = lSqur;
            else if(lSqur <= rSqur) {
                output[index++] = lSqur;
                fIndex--;
            }
            else if(lSqur >= rSqur) {
                output[index++] = rSqur;
                if(fIndex>0) fIndex--;
            }
        }

        return output;
    }

    private int findFirstPositive(int[] nums) {
        int first = -1;
        for(int i =0;i <nums.length;i++) {
            if(nums[i] >= 0) {
                first = i;
                break;
            }
        }
        return first;
    }
}
