package com.test.dp;

public class LongestCommonSubsequence {
	public int lcs(char[] s1, char[] s2) {
		int [][]T = new int[s1.length + 1 ][s2.length + 1];
		int max = 0;
		for(int i=1; i< s1.length + 1 ; i++) {
			for (int j=1; j < s2.length + 1; j++) {
				if(s1[i-1] == s2[j-1]) {
					T[i][j] = T[i-1][j-1] + 1;
				} else {
					T[i][j] = Math.max(T[i-1][j], T[i][j-1]);
				}
				if(T[i][j] > max){
                    max = T[i][j];
                }
			}
		}
		return max;
	}
	
	public static void main(String args[]){
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String str1 = "ABCDGHLQR";
        String str2 = "AEDPHR";
        
        int result = lcs.lcs(str1.toCharArray(), str2.toCharArray());
        System.out.print(result);
    }
}
