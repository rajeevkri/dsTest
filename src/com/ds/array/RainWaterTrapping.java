package com.ds.array;

public class RainWaterTrapping {
    public int trap(int[] height) {
        int l = height.length;
        int[] leftAux =new int[l];
        int[] rightAux =new int[l];
        int maxLeft = Integer.MIN_VALUE;
        for (int i=0; i<l; i++) {
            if(maxLeft < height[i]) {
                maxLeft = height[i];
            }
            leftAux[i] = maxLeft;
        }
        int maxRight = Integer.MIN_VALUE;
        for (int i=l; i>0; i--) {
            if(maxRight < height[i-1]) {
                maxRight = height[i];
            }
            rightAux[i-1] = maxRight;
        }
        int sum = 0;
        for(int i =0; i< l; i++) {
            int curr = Math.min(leftAux[i], rightAux[i]) - height[i];
            sum = sum + curr;
        }
        return sum;
    }
}
