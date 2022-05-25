package com.ds.array.heap;

import java.util.*;
import java.util.stream.IntStream;

public class HeapOperations {
    public static int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        // int m = points[0].length;
        int[][] out = new int[k][2];
        long[] distance = new long[n];
        for(int i = 0; i<n; i++) {
            int x = points[i][0]; int y = points[i][1];
            distance[i] = (long) x * x + (long) y * y;
        }
        Arrays.sort(distance);
        long kthElem = distance[k-1];
        int j = 0;
        for(int i = 0; i<n; i++) {
            int x = points[i][0]; int y = points[i][1];
            long dist = (long) x * x + (long) y * y;
            if(dist <= kthElem) {
                out[j][0] = x;out[j][1] = y;j++;
                System.out.println("[" + x + ", " + y + "]");
            }
        }
        return out;
    }
    public static void main (String[] args)
    {
//        int points[][] = { { 3, 3 },
//                { 5, -1 },
//                { -2, 4 } };
//        int points[][] = { { 1, 3 },{ -2, 2 } };
//        int K = 1;
//
//        kClosest(points, K);
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums, 4));
    }


    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);


        return nums[nums.length - k + 1];
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for(int key : map.keySet()){
            queue.add(key);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < k; i++){
            ans.add(queue.poll());
        }

        int[] result = new int [ans.size()];

        for(int i =0; i < ans.size(); i++)
            result[i]= ans.get(i);

        return result;

    }
}
