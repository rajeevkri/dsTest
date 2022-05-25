package com.ds.string;

public class CommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null) {
            return null;
        }
        int l = strs.length;
        String commonPrefix = "";
        if(l == 0)
            return commonPrefix;
        char[] chArr = strs[0].toCharArray();
        outer:for(int i =0; i < chArr.length; i++) {
            char ch = chArr[i];
            for (int j =1; j <strs.length; j++) {
                String str = strs[j];
                if(str.length() < i+1 || str.charAt(i) != ch) {
                    break outer;
                }
            }
            commonPrefix = commonPrefix + ch;
        }
        return commonPrefix;
    }

    public static void main(String[] args) {
        CommonPrefix cp = new CommonPrefix();
        String [] strs = {"flower","flow","flight"};
        String commonPrefix = cp.longestCommonPrefix(strs);
        System.out.println(commonPrefix);
    }
}
