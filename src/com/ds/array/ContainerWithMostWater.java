package com.ds.array;

public class ContainerWithMostWater {

    public int maxArea1(int[] height) {
        int maxArea = 0;
        if(height == null || height.length == 0 || height.length == 1 ) {
            return maxArea;
        }
        int l = height.length;
        for(int i = 0; i< l-1; i++) {
            for(int j = i; j < l; j++) {
                int area = (j-i) * Math.min(height[i], height[j]);
                if(area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int area = containerWithMostWater.maxArea(height);
        System.out.println("area = " + area);
    }

    public int maxArea(int[] height) {
        if(height == null || height.length == 0 || height.length == 1 ) {
            return 0;
        }
        int len = height.length;
        int l = 0;
        int r = len -1;
        int area = 0;

        while (l < r)
        {
            // Calculating the max area
            area = Math.max(area,
                    Math.min(height[l], height[r]) * (r - l));

            if (height[l] < height[r])
                l += 1;

            else
                r -= 1;
        }
        return area;
    }
}
