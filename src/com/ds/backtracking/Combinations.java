package com.ds.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<>();
        if(k >0)
            combinations(n, k, output);
        return output;
    }

    private void combinations(int n, int k, List<List<Integer>> output) {
        Queue<List<Integer>> q = new LinkedList<>();
        for(int i =1; i<=n; i++) {
            List<Integer> l =  new ArrayList<>();
            l.add(i);
            q.add(l);
        }
        while (!q.isEmpty()) {
            List<Integer> list = q.poll();
            int size = list.size();
            if(size == k) {
                output.add(list);
            } else {
                Integer last = list.get(size - 1);
                for (int i= last +1; i<=n; i++) {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(i);
                    q.add(newList);
                }
            }
        }
    }
}
