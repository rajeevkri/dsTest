package com.ds.backtracking;

import java.util.*;

public class Permutation {

    public List<List<Integer>> permute(int [] nums) {
        int n = nums.length;
        List<List<Integer>> output = new ArrayList<>();
        int[] arr = new int[n];
        permute(nums, n, arr, 0, output);
        return output;
    }

    private void permute(int[] nums, int n, int[] arr, int pos, List<List<Integer>> output) {
        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> l =  new ArrayList<>();
        q.add(l);

        while (!q.isEmpty()) {
            List<Integer> list = q.poll();
            if (list.size() == n)  {
                output.add(list);
            } else {
                for (int i=0; i<n; i++) {
                    if(! list.contains(nums[i])) {
                        List<Integer> newList = new ArrayList<>(list);
                        newList.add(nums[i]);
                        q.add(newList);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        Permutation perm = new Permutation();
        List<List<Integer>> permute = perm.permute(nums);
        permute.forEach(p -> {
            p.forEach(System.out::println);
            System.out.println("==============");
        });
    }
}
