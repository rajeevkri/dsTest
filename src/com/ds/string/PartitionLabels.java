package com.ds.string;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        if(s == null || s.length() ==0) {
            return null;
        }
        List<Integer> output = new ArrayList<>();

        int [] last_indices = new int[26];
        for(int i =0 ; i<s.length(); i++) {
            last_indices[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;
        for(int i =0; i<s.length(); i++) {
            end = Math.max(end, last_indices[s.charAt(i) - 'a']);
            if( i == end) {
                output.add(end - start +1);
                start = end+1;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";

        PartitionLabels partitionLabels = new PartitionLabels();
        List<Integer> partitionLabelsList = partitionLabels.partitionLabels(s);
        partitionLabelsList.forEach(System.out::println);
    }
}
