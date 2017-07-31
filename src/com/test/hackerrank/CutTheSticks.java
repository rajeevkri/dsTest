package com.test.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Cut the Sticks
Implementation Easy Algorithms Data Structures Core CS
Use Question
Testcases: 11 (2 Sample)
Given an array, lengths, of N stick lengths (where each length is a positive integer), a cut operation reduces the length of each stick in the array by the length of the array’s shortest stick. A stick can only be cut if it has a length ≥ 1.
Complete the cutSticks function in your editor, It has 1 parameters:
An integer array of stick lengths, lengths (as well as the size of the array where required by the language).
Your function must perform cut operations on lengths until every stick length is reduced to 0 and return an integer array, where ithelement of the array denotes the individual sticks cut during the ith operation.
Input Format
The following input from stdin is handled for you by the locked stub code in your editor:
The first line contains an integer, N, the length of lengths. The N subsequent lines describe the elements in lengths.
Constraints
1 ≤ N ≤ 103
1 ≤ lengths[i] ≤ 103, where 0 ≤ i ≤ N−1
Output Format
Your function must return an integer array, where ith element of the array denotes the individual sticks cut during the ith operation. This is printed to stdout by the locked stub code in your editor.
Sample Input 1
6
5
4
4
2
2
8
Sample Output 1
6
4
2
1
Sample Input 2
8
1
2
3
4
3
3
2
1
Sample Output 2
8
6
4
1
Explanation
Sample Case 1:
|lengths| = 6, lengths = {5, 4, 4, 2, 2, 8}
Cut Operation 1: The smallest length in lengths is 2, so the cut length for this cut operation is 2. After cutting (reducing) each stick inlengths by 2, lengths1 = {3, 2, 2, 0, 0, 6} and we print 6 (the number of sticks cut during the cut operation) on a new line.
Cut Operation 2: The smallest length in lengths1 = {3, 2, 2, 0, 0, 6} is 2, so the cut length for this cut operation is 2. After cutting (reducing) each stick in lengths1 by 2, lengths2 = {1, 0, 0, 0, 0, 4} and we print 4 (the number of sticks cut during the cut operation) on a new line.
Cut Operation 3: The smallest length in lengths2 = {1, 0, 0, 0, 0, 4} is 1, so the cut length for this cut operation is 1. After cutting (reducing) each stick in lengths2 by 1, lengths3 = {0, 0, 0, 0, 0, 3} and we print 2 (the number of sticks cut during the cut operation) on a new line.
Cut Operation 3: The smallest length in lengths3 = {0, 0, 0, 0, 0, 3} is 3, so the cut length for this cut operation is 3. After cutting (reducing) each stick in lengths3 by 3, lengths4 = {0, 0, 0, 0, 0, 0} and we print 1 (the number of sticks cut during the cut operation) on a new line.
At this point, there are no more sticks to be cut and we cease performing cut operations.
Sample Case 2:
lengths       cut length   count cuts  
1 2 3 4 3 3 2 1 1 8
1 2 3 2 2 1 1 6
1 2 1 1 1 4
_ 1 _ _ 1 1
_ _ DONE DONE
 *
 */
public class CutTheSticks {

	static int[] cutSticks(int[] lengths) {
	    int n = lengths.length;
	    Arrays.sort(lengths);
	    List<Integer> ans = new ArrayList<>();
	    for (int i = 0; i < n; i++) {
	        if (lengths[i] == 0) continue;
	        else {
	            ans.add(n-i);
	            int temp = lengths[i];
	            for (int j = i; j < n; j++) {
	                lengths[j] -= temp;
	            }
	        }
	    }
	    int[] res = new int[ans.size()];
	    for (int i = 0; i < ans.size(); i++) res[i] = ans.get(i);
	    return res;
	}   
}
