package com.ds.string;

import java.util.HashMap;
import java.util.HashSet;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int l = s1.length();
        int n = s2.length();
        if(n < l) {
            return false;
        }

        HashSet<Character> s1Data = new HashSet<>();
        HashSet<Character> s2Data = new HashSet<>();
        for(int i = 0; i<l;i++) {
            s1Data.add(s1.charAt(i));
        }
        int start = 0;
        for(int i = start; i<l;i++) {
            s2Data.add(s2.charAt(i));
        }

        while (start < (n - l)) {
            if(s1Data.equals(s2Data) ) {
                return true;
            } else {
                s2Data.remove(s2.charAt(start));
                s2Data.add(s2.charAt(start+l));
                start++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PermutationInString permutationInString = new PermutationInString();
        boolean isIncluded = permutationInString.checkInclusion("ab", "eidbaooo");
        System.out.println(isIncluded);
    }
    public int singleNumber(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int j : nums) {
            if (numSet.contains(j)) {
                numSet.remove(j);
            } else {
                numSet.add(j);
            }
        }
        Integer out = null;
        for (Integer num :numSet) {
            out = num;
        }
        return out;
    }
}
