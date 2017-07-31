package com.test.hackerrank;

import java.util.Arrays;

/*
 * 
 * Pangrams
Implementation Easy Strings Core CS
Use Question
Testcases: 13 (2 Sample)
A pangram is a word or sentence that contains every letter of the alphabet.
For example : the quick brown fox jumps over the lazy dog. Nicole wants to improve her typing speed for programming contests, and she thinks that practicing typing pangrams is the best way to do it.
Given N strings comprised of lowercase letters (a - z) and spaces, determine whether or not they are pangrams.
Complete the isPangram function, which takes an array of N strings (S0, S1, …, SN-1) as a parameter and returns a string of N binary characters. Each character i of the returned string should be a 1 if string Si is a pangram or 0 if it is not.
Input Format
The locked code in your editor assembles the following input and passes it to the isPangram function:
The first line contains an integer N, the number of strings. Each line i (where 0 ≤ i < N) of the N subsequent lines contains a string, Si.
Constraints
1 ≤ N ≤ 100
Each string Si (where 0 ≤ i < N) is composed of lowercase letters and spaces.
1 ≤ |Si| ≤ 105, where |Si| is the length of string Si.
Output Format
The isPangram function must return a binary string of length N in which each character i (where 0 ≤ i < N) denotes whether or not input string Si is a pangram.
Sample Input 1
4
we promptly judged antique ivory buckles for the next prize
we promptly judged antique ivory buckles for the prizes
the quick brown fox jumps over the lazy dog
the quick brown fox jump over the lazy dog
Sample Output 1
1010
Sample Input 2
4
cfchcfcvpalpqxenhbytcwazpxtthjumliiobcznbefnofyjfsrwfecxcbmoafes tnulqkvx
oxhctvhybtikkgeptqulzukfmmavacshugpouxoliggcomykdnfayayqutgwivwldrkp
gpecfrak zzaxrigltstcrdyhelhz rasrzibduaq cnpuommogatqem
hbybsegucruhxkebrvmrmwhweirx mbkluwhfapjtga liiylfphmzkq
Sample Output 2
0000
Explanation
Sample Case 1:
S0 = we promptly judged antique ivory buckles for the next prize
S1 = we promptly judged antique ivory buckles for the prizes
S2 = the quick brown fox jumps over the lazy dog
S3 = the quick brown fox jump over the lazy dog
Only S0 and S2 are pangrams.
Sample Case 2:
S0 = cfchcfcvpalpqxenhbytcwazpxtthjumliiobcznbefnofyjfsrwfecxcbmoafes tnulqkvx
S1 = oxhctvhybtikkgeptqulzukfmmavacshugpouxoliggcomykdnfayayqutgwivwldrkp
S2 = gpecfrak zzaxrigltstcrdyhelhz rasrzibduaq cnpuommogatqem
S3 = hbybsegucruhxkebrvmrmwhweirx mbkluwhfapjtga liiylfphmzkq
No string in the array is a pangram.
 */
public class Panagram {

	static String isPangram(String[] strings) {
	    StringBuilder sb = new StringBuilder();
	    for (String str: strings) {
	        int[] pan = new int[26];
	        Arrays.fill(pan, 0);
	        for (int i = 0; i < str.length(); i++) {
	            char ch = str.charAt(i);
	            if (ch >= 'a' && ch <= 'z') pan[ch-'a']++;
	        }
	        for (int i = 0; i < 26; i++) {
	            if (pan[i] == 0) {
	                sb.append("0");
	                break;
	            }
	            if (i == 25 && pan[i] != 0) sb.append("1");
	        }
	    }
	    return sb.toString();
	}  
}
