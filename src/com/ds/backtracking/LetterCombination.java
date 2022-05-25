package com.ds.backtracking;

import javax.swing.text.AbstractDocument;
import java.util.*;

public class LetterCombination {
    public List<String> letterCombinations(String digits) {
        if(digits == null || "".equals(digits)) {
            return Collections.emptyList();
        }
        String[] table
                = { "0","1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        int n = digits.length();
        ArrayList<String> list
                = letterCombinationsUtil(digits, n, table);

        return  list;
    }

    public ArrayList<String> letterCombinationsUtil(String digits, int n, String[] table) {
        ArrayList<String> list = new ArrayList<String>();
        Queue<String> q = new LinkedList<>();
        q.add("");
        while(!q.isEmpty()) {
            String s = q.remove();
            if(s.length() == n) {
                list.add(s);
            } else {
                Character ch = digits.charAt(s.length());
                int d = Character.getNumericValue(ch);
                String letter = table[d];
                for (int i =0; i< letter.length(); i++) {
                    q.add(s + letter.charAt(i));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LetterCombination lc = new LetterCombination();
        List<String> l = lc.letterCombinations("");
        lc.prinList(l);
    }

    public void prinList(List<String> list) {
        // Print the contents of the list
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }


    public void findSmallestSubstringWithAllCharactersFromGivenString(String s, String s1) {
//        String s = "xyyzyzyx";
//        String s1 = "xyz";
        String finalString = "";
        Map<Character, Integer> hm = new HashMap<>();
        if (s1 != null && s != null && s.length() > s1.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (hm.get(s1.charAt(i)) != null) {
                    int k = hm.get(s1.charAt(i)) + 1;
                    hm.put(s1.charAt(i), k);
                } else
                    hm.put(s1.charAt(i), 1);
            }
            Map<Character, Integer> t = new HashMap<>();
            int start = -1;
            for (int j = 0; j < s.length(); j++) {
                if (hm.get(s.charAt(j)) != null) {
                    if (t.get(s.charAt(j)) != null) {
                        if (t.get(s.charAt(j)) != hm.get(s.charAt(j))) {
                            int k = t.get(s.charAt(j)) + 1;
                            t.put(s.charAt(j), k);
                        }
                    } else {
                        t.put(s.charAt(j), 1);
                        if (start == -1) {
                            if (j + s1.length() > s.length()) {
                                break;
                            }
                            start = j;
                        }
                    }
                    if (hm.equals(t)) {
                        t = new HashMap<>();
                        if (finalString.length() < s.substring(start, j + 1).length()) ;
                        {
                            finalString = s.substring(start, j + 1);
                        }
                        j = start;
                        start = -1;
                    }
                }
            }

        }
    }
}
