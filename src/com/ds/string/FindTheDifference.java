package com.ds.string;

import java.util.HashMap;
import java.util.HashSet;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        if(s.length() == t.length())
            return '0';
        HashMap<Character, Integer> cSet = new HashMap<>();
        char[] chArray = s.toCharArray();
        char[] chars = t.toCharArray();
        for (char c : chars) {
            if(cSet.containsKey(c)) {
                cSet.put(c, cSet.get(c) + 1);
            }else
            cSet.put(c, 1);
        }
        char ch = '0';
        for (char aChar : chArray) {
            if (cSet.containsKey(aChar)) {
//                ch = aChar;
//                break;
//            } else {
                int count = cSet.get(aChar) - 1;
                if (count ==0) {
                    cSet.remove(aChar);
                } else
                cSet.put(aChar, cSet.get(aChar) - 1);
            }
        }
        if(cSet.size() >0) {
            ch = cSet.keySet().stream().findFirst().get();
        }
        return ch;
    }

    public static void main(String[] args) {
        FindTheDifference fd = new FindTheDifference();
        char theDifference = fd.findTheDifference("a", "aa");
        System.out.println(theDifference);
    }
}
