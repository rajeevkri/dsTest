package com.test.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Delta encoding challenge
Problem statement
Given a list of numbers, e.g.:


25626 25757 24367 24267 16 100 2 7277
1
25626 25757 24367 24267 16 100 2 7277
Output a delta encoding for the sequence. In a delta encoding, the first element is reproduced as is. Each subsequent element is represented as the numeric difference from the element before it. E.g. for the sequence above, the delta encoding would be:


25626 131 -1390 -100 -24251 84 -98 7275
1
25626 131 -1390 -100 -24251 84 -98 7275
However, if a difference value does not fit in a single signed byte, i.e. -127 \le x \le 127, then, instead of the difference, we would like to use an escape token, printing it.

This will denote that the value following the escape token is a full four-byte difference value, rather than a one-byte different value.

For this exercise, we’ll declare -128 as the escape token.

Following the same example above, the final result would be:


25626 -128 131 -128 -1390 -100 -128 -24251 84 -98 -128 7275
1
25626 -128 131 -128 -1390 -100 -128 -24251 84 -98 -128 7275
 *
 */
public class DeltaEncodingChallenge {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	 
	        List<Integer> list = new ArrayList<>();
	        while (in.hasNext()) {
	            int num = in.nextInt();
	            list.add(num);
	        }
	 
	        StringBuilder result = new StringBuilder();
	        result.append(list.get(0)+" ");
	        for (int i=1; i<list.size(); i++) {
	            int diff = list.get(i) - list.get(i-1);
	            if (Math.abs(diff)>127) {
	                result.append("-128 ");
	            }
	            result.append(diff+" ");
	        }
	 
	        System.out.println(result);
	        in.close();
	    }
}
