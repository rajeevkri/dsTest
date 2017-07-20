package com.test.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Operations {
	static String[] braces(String[] values) {
		int n = values.length;
		String[] arr = new String[n];

		for (int i = 0; i < n; i++) {
			String value = values[i];
			boolean isBalanced = parenthesisBalanced(value.toCharArray());

			if (isBalanced)
				arr[i] = "YES";
			else
				arr[i] = "NO";
		}
		return arr;
	}

	/**
	 * Check if given array has balanced parenthesis
	 * 
	 * @param exp
	 * @return
	 */
	static boolean parenthesisBalanced(char exp[]) {
		Stack<Character> st = new Stack<>();

		for (int i = 0; i < exp.length; i++) {

			if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[')
				st.push(exp[i]);

			if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']') {

				if (st.isEmpty()) {
					return false;
				}

				else if (!isMatchingPair(st.pop(), exp[i])) {
					return false;
				}
			}

		}

		if (st.isEmpty())
			return true; /* balanced */
		else { /* not balanced */
			return false;
		}
	}

	static boolean isMatchingPair(char character1, char character2) {
		if (character1 == '(' && character2 == ')')
			return true;
		else if (character1 == '{' && character2 == '}')
			return true;
		else if (character1 == '[' && character2 == ']')
			return true;
		else
			return false;
	}

	public <T> List<T> intersection(List<T> list1, List<T> list2) {
		List<T> list = new ArrayList<T>();

		for (T t : list1) {
			if (list2.contains(t)) {
				list.add(t);
			}
		}

		return list;
	}

	/**
	 * permutation function
	 * 
	 * @param str
	 *            string to calculate permutation for
	 * @param l
	 *            starting index
	 * @param r
	 *            end index
	 */
	public void permute(String str, int l, int r) {
		if (l == r)
			System.out.println(str);
		else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	/**
	 * Swap Characters at position
	 * 
	 * @param a
	 *            string value
	 * @param i
	 *            position 1
	 * @param j
	 *            position 2
	 * @return swapped string
	 */
	public String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	List<String> permute(char[] input) {
		Map<Character, Integer> countMap = new TreeMap<>();

		return null;
	}

	static int[] getMaxElementIndices(int[] a, int[] rotate) {
		int length = a.length;
		int maxElementIndex = getMaxElementIndex(a);
		int[] maxElemIndices = new int[rotate.length];
		int i = 0;
		for (int r : rotate) {
			int indexAfterRotation = findIndexAfterRotations(maxElementIndex, r, length);
			maxElemIndices[i++] = indexAfterRotation;
		}
		return maxElemIndices;
	}

	static int findIndexAfterRotations(int initialIndex, int numberOfRotation, int arrayLength) {
		int temp = initialIndex - numberOfRotation;

		while (temp < 0) {
			temp = arrayLength + temp;
		}
		return temp;

	}

	static int getMaxElementIndex(int[] a) {
		int max = a[0];
		int index = 0;
		int length = a.length;
		for (int i = 1; i < length; i++) {
			if (max < a[i]) {
				max = a[i];
				index = i;
			}
		}
		return index;
	}

	/*
	 * Complete the function below.
	 */

	static String[] twins(String[] a, String[] b) {
		int length = a.length;
		String[] results = new String[length];
		for (int i = 0; i < length; i++) {
			boolean isTwin = isTwin(a[i], b[i]);
			if (isTwin) {
				results[i] = "Yes";
			} else {
				results[i] = "No";
			}
		}
		return results;
	}

	static boolean isTwin(String a, String b) {
		int n = a.length();
		int x = b.length();
		if (n != x) {
			return false;
		}
		List<Character> cOddListFirst = new ArrayList<>();
		List<Character> cEvenListFirst = new ArrayList<>();
		List<Character> cOddListSecond = new ArrayList<>();
		List<Character> cEvenListSecond = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0)// even index
			{
				cEvenListFirst.add(a.charAt(i));
				cEvenListSecond.add(b.charAt(i));
			} else // odd index
			{
				cOddListFirst.add(a.charAt(i));
				cOddListSecond.add(b.charAt(i));
			}
		}
		cOddListFirst.removeAll(cOddListSecond);
		cEvenListFirst.removeAll(cEvenListSecond);
		if (cOddListFirst.size() == 0 && cEvenListFirst.size() == 0) {
			return true;
		}
		return false;
	}

}
