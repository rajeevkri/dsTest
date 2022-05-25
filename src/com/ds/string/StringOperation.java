package com.ds.string;

import java.util.HashMap;
import java.util.Map;

public class StringOperation {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int maxLength = 0;
        int length = s.length();

        Map<Character, Integer> map = new HashMap<>();
        while (end < length) {
            if (map.containsKey(s.charAt(end)) && map.get(s.charAt(end)) >= start) {
                start = map.get(s.charAt(end)) + 1;
            }
            maxLength = Math.max(maxLength, end - start + 1);
            map.put(s.charAt(end), end);
            end++;
        }

        return maxLength;
    }

    public int reverse(int x) {
        boolean isNegative = x < 0;
        String inp = String.valueOf(x);
        int l = inp.length();
        StringBuilder sb = new StringBuilder(inp);
        String out;
        sb = sb.reverse();
        if (isNegative) {
            out = "-" + sb.substring(0, l - 1);
        } else {
            out = sb.toString();
            ;
        }
        Long lo = Long.valueOf(out);
        if (lo < Integer.MIN_VALUE || lo > Integer.MAX_VALUE) {
            return 0;
        }
        return lo.intValue();
    }

    public static void main(String[] args) {
        StringOperation so = new StringOperation();
//        int rev = so.reverse(1534236469);
//        System.out.println(rev);
        boolean res = so.detectCapitalUse("USA");
        System.out.println(res);
    }

    public boolean isPalindrome(int x) {
        String xr = String.valueOf(x);
        int l = xr.length();
        int mid = l / 2;
        boolean isPalindrome = true;
        for (int i = 0; i < mid; i++) {
            if (xr.charAt(i) == xr.charAt(l - i - 1)) {
                continue;
            }
            isPalindrome = false;
            break;
        }
        return isPalindrome;
    }

    public boolean detectCapitalUse1(String word) {
        if (word.length() < 2) {
            return true;
        }
        int wordType = -1;
        char start = word.charAt(0);
        if (start >= 'a' && start <= 'z') {
            wordType = 2;
        }
        if (start >= 'A' && start <= 'Z') {
            char second = word.charAt(1);
            if (second >= 'a' && second <= 'z') {
                wordType = 3;
            } else if (second >= 'A' && second <= 'Z') {
                wordType = 1;
            }
        }
        if(wordType == -1) {
            return false;
        }
        if(wordType == 1) {
            for (int i =2; i<word.length(); i++) {
                if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                    continue;
                }
                return false;
            }
        }
        if(wordType == 2) {
            for (int i =1; i<word.length(); i++) {
                if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                    continue;
                }
                return false;
            }
        }
        if(wordType == 3) {
            for (int i =2; i<word.length(); i++) {
                if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    public boolean detectCapitalUse(String word) {
        int capitals = 0;
        for(char ch : word.toCharArray()) {
            if(Character.isUpperCase(ch))
                capitals++;
        }
        // case 1 and case 2
        if(capitals == word.length() || capitals == 0) return true;
        return capitals == 1 && Character.isUpperCase(word.charAt(0));  // case 3
    }

}
