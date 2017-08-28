package com.test.leetcode;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * For example, Given s = "Hello World", return 5.
 * 
 * @author rajeevsingh
 *
 */
public class LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
		if(s== null || s.length() == 0) {
			return 0;
		}
		s = s.trim();
		int l = s.lastIndexOf(" ");
		if(l < 0) {
			return s.length();
		}
		return s.length() - l -1;
	}
	
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello world"));
	}
}
