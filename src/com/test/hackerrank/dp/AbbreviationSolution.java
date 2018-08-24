package com.test.hackerrank.dp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * You can perform the following operations on the string, :

Capitalize zero or more of 's lowercase letters.
Delete all of the remaining lowercase letters in .
Given two strings,  and , determine if it's possible to make  equal to  as described. If so, print YES on a new line. Otherwise, print NO.

For example, given  and , in  we can convert  and delete  to match . If  and , matching is not possible because letters may only be capitalized or discarded, not changed.

Function Description

Complete the function  in the editor below. It must return either  or .

abbreviation has the following parameter(s):

a: the string to modify
b: the string to match
Input Format

The first line contains a single integer , the number of queries.

Each of the next  pairs of lines is as follows: 
- The first line of each query contains a single string, . 
- The second line of each query contains a single string, .

Constraints

String  consists only of uppercase and lowercase English letters, ascii[A-Za-z].
String  consists only of uppercase English letters, ascii[A-Z].
Output Format

For each query, print YES on a new line if it's possible to make string  equal to string . Otherwise, print NO.

Sample Input

1
daBcd
ABC
Sample Output

YES
 * 
 * 
 * @author srajeev
 *
 */
public class AbbreviationSolution {
	// Complete the abbreviation function below.
	static String abbreviation(String a, String b) {
		int i = 0, j = 0;
		boolean temp = false;
		char[] inputA = a.toCharArray();
		char[] inputB = b.toCharArray();
		while (i < a.length() && j < b.length()) {
			if (inputA[i] == inputB[j] || Character.toUpperCase(inputA[i]) == inputB[j]) {
				temp = true;
				i++;
				j++;
			} else {
				i++;
				temp = false;
			}
		}
		if (j < b.length()) {
			return "NO";
		}
		if (j == b.length() && temp) {
			return "YES";
		}
		return "NO";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String a = scanner.nextLine();

			String b = scanner.nextLine();

			String result = abbreviation(a, b);

			System.out.println(result);
			// bufferedWriter.write(result);
			// bufferedWriter.newLine();
		}

		// bufferedWriter.close();

		scanner.close();
	}
}
