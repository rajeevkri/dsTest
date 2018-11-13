package com.test.hackerrank.stack;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmartIDE {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();
		while (sc.hasNextLine()) {
			sb.append(sc.nextLine());
			sb.append("\n");
		}
		sc.close();
		String finalStr = sb.toString();
		Pattern x = Pattern.compile("(//[^\\n]*)|(/\\*.*?\\*/)", Pattern.MULTILINE | Pattern.DOTALL);

		Matcher matcher = x.matcher(finalStr);
		while (matcher.find()) {
			String result = matcher.group();
			sc = new Scanner(result);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine().trim());
			}

			sc.close();
		}

		
	}

}
