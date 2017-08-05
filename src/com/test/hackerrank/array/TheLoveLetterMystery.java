package com.test.hackerrank.array;

public class TheLoveLetterMystery {

	public static int getMystery(String word) {
		char[] wordArr = word.toCharArray();

		int count = 0;
		int j = word.length() - 1;

		for (int i = 0; i < wordArr.length / 2; i++, j--) {
			count += Math.abs((int) (wordArr[i] - wordArr[j]));
		}

		return count;
	}
}
