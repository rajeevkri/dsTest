package com.ds.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StringPermutaion {
    public static void main(String[] args)
    {
        String str = "ABC";
        StringPermutaion permutation = new StringPermutaion();
        List<String> stringList = permutation.permute(str);
    }

    private List<String> permute(String str) {
        ArrayList<String> list = new ArrayList<String>();
        Queue<String> q = new LinkedList<>();
        return list;
    }
}
