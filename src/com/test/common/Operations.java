package com.test.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

import org.junit.experimental.max.MaxCore;

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

	class SuperStack extends Stack<Integer> {

		public void addAll(int value, int numberOfElem) {

			Queue<Integer> helperStack = new LinkedList<>();

			while (!this.empty()) {
				helperStack.add(this.pop());
			}
			while (!helperStack.isEmpty()) {
				int count = numberOfElem;
				int x = helperStack.poll();
				if (count > 0) {
					x = x + value;
				}
				this.push(x);
				count--;
			}
		}

		@Override
		public synchronized Integer peek() {

			return super.peek();
		}

		@Override
		public synchronized boolean add(Integer e) {
			return super.add(e);
		}

		@Override
		public synchronized Integer pop() {
			return super.pop();
		}
	}

	static void superStack(String[] operations) {
		SuperStack stack = new Operations().new SuperStack();
		for (String operation : operations) {
			String[] arr = operation.split(" ");
			if ("push".equals(arr[0])) {
				stack.push(Integer.valueOf(arr[1]));
				System.out.println(stack.peek());
			} else if ("pop".equals(arr[0])) {
				stack.pop();
				System.out.println(stack.isEmpty() ? "EMPTY" : stack.peek());
			} else if ("inc".equals(arr[0])) {
				stack.addAll(Integer.valueOf(arr[2]), Integer.valueOf(arr[1]));
				System.out.println(stack.peek());
			}
		}

	}

	public static void main(String[] args) {
		SuperStack stack = new Operations().new SuperStack();
		stack.push(4);
		stack.pop();
		stack.push(3);
		stack.push(5);
		stack.push(2);
		stack.addAll(1, 3);
		stack.peek();
	}

	static Map<String, Integer> datesMap = new HashMap<>();
	static Map<String, String> monthsMap = new HashMap<>();

	static {
		datesMap.put("1st", 1);
		datesMap.put("2nd", 2);
		datesMap.put("3rd", 3);
		for (int i = 4; i <= 20; i++) {
			datesMap.put(i + "th", i);
		}
		datesMap.put("21st", 21);
		datesMap.put("22nd", 22);
		datesMap.put("23rd", 23);
		for (int i = 24; i <= 30; i++) {
			datesMap.put(i + "th", i);
		}
		datesMap.put("31st", 31);
		monthsMap.put("Jan", "01");
		monthsMap.put("Feb", "02");
		monthsMap.put("Mar", "03");
		monthsMap.put("Apr", "04");
		monthsMap.put("May", "05");
		monthsMap.put("Jun", "06");
		monthsMap.put("Jul", "07");
		monthsMap.put("Aug", "08");
		monthsMap.put("Sep", "09");
		monthsMap.put("Oct", 10 + "");
		monthsMap.put("Nov", 11 + "");
		monthsMap.put("Dec", 12 + "");
	}

	static String[] reformatDate(String[] dates) {
		String[] formattedDate = new String[dates.length];
		int i = 0;
		for (String date : dates) {
			String[] split = date.split(" ");
			String temp = split[2] + "-" + monthsMap.get(split[1]) + "-";
			if (datesMap.get(split[0]) < 10) {
				temp += "0";
			}
			temp += datesMap.get(split[0]);
			formattedDate[i++] = temp;
		}
		return formattedDate;
	}

	// Function to check if two given pairs have any common element or not
	boolean noCommon(PairSum a, PairSum b)
	{
	    if (a.first == b.first || a.first == b.sec ||
	            a.sec == b.first || a.sec == b.sec)
	        return false;
	    return true;
	}
	 
	 
	// The function finds four elements with given sum X
	void findFourElements (int arr[], int n, int X)
	{
	    int i, j;
	 
	    // Create an auxiliary array to store all pair sums
	    int size = (n*(n-1))/2;
	    PairSum[] aux = new PairSum[size];
	 
	    /* Generate all possible pairs from A[] and store sums
	       of all possible pairs in aux[] */
	    int k = 0;
	    for (i = 0; i < n-1; i++)
	    {
	        for (j = i+1; j < n; j++)
	        {
	            aux[k].sum = arr[i] + arr[j];
	            aux[k].first = i;
	            aux[k].sec = j;
	            k++;
	        }
	    }
	 
	    // Sort the aux[] array using library function for sorting
	    Arrays.sort(aux);
	 
	    // Now start two index variables from two corners of array
	    // and move them toward each other.
	    i = 0;
	    j = size-1;
	    while (i < size && j >=0 )
	    {
	        if ((aux[i].sum + aux[j].sum == X) && noCommon(aux[i], aux[j]))
	        {
	            System.out.printf("%d, %d, %d, %d\n", arr[aux[i].first], arr[aux[i].sec],
	                                     arr[aux[j].first], arr[aux[j].sec]);
	            return;
	        }
	        else if (aux[i].sum + aux[j].sum < X)
	            i++;
	        else
	            j--;
	    }
	}
	 
}
