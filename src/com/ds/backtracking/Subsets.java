package com.ds.backtracking;

import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
//        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> empty = new ArrayList<>();
        output.add(empty);
        int n = nums.length;
        for(int i = 1; i <= n; i++) {
            subsets(nums, i, output);
        }

        return output;
    }

    private void subsets(int[] nums, int size, List<List<Integer>> output) {
        Queue<List<Integer>> queue = new LinkedList<>();
        Integer l =output.size();

        for(int i=0; i< l; i++) {
            List<Integer> list = output.get(i);
            if(list.size() == (size -1 )) {
                queue.add(list);
            }
        }
        while (!queue.isEmpty()) {
            List<Integer> list = queue.poll();
            if(list.size() == size) {
                output.add(list);
            } else {
                Integer last = Integer.MIN_VALUE;
                if(list.size() > 0) {
                    last = list.get(list.size() - 1);
                }
                for(int i =0; i<nums.length; i++) {
                    if (nums[i] > last) {
                        List<Integer> newList = new ArrayList<>(list);
                        newList.add(nums[i]);
                        queue.add(newList);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Subsets subsets = new Subsets();
        List<List<Integer>> lists = subsets.subsets(nums);

        lists.forEach(p -> {
            p.forEach(System.out::println);
            System.out.println("==============");
        });
    }
}
