package com.test.hackerrank;

import java.util.Arrays;

/**
 * Minimum Area
medium Algorithms Greedy Brute Force Core CS
Use Question
Testcases: 10 (3 Sample)
You are given n points in 2D plane, with integers coordinates, (x[0], y[0]), (x[1], y[1]), (x[2], y[2]), …, (x[n - 1], y[n - 1]). Here x[i] is thex-coordinate of the ith point and y[i] is the y-coordinate of the ith point.
Your task is to draw a square by choosing any four points (may or may not from the set of n given points), such that the following three constraints are satisfied:
The x-coordinates and y-coordinates of the points should be integers only.
The sides of the square should be parallel to coordinate axis.
At least k of the given n points should lie strictly inside the square drawn. By strictly inside, we mean that any point on the sides of the square is not considered to be inside the square.
Complete the function minArea, which has three parameters:
An array, x, of n integers denoting the x-coordinates of the n points.
An array, y, of n integers denoting the y-coordinates of the n points.
A positive integer k.
The function should return the possible minimum area of the square satisfying all the three constraints.
Input Format
The locked code in the editor reads the input and passes to the function.
The first line of the input is an integer, n, the total number of points.
Each of the next n subsequent lines contains an integer x[i] denoting the x-coordinate of the ith point.
The next line is the value of integer n.
Each of the next n subsequent lines contains an integer y[i] denoting the y-coordinate of the ith point.
The last of the input contains the value of the integer, k.
Constraints
2 ≤ n ≤ 100
-109 ≤ x[i], y[i] ≤ 109, where 0 ≤ i ≤ n - 1
1 ≤ k ≤ n
Output Format
The locked code in the editor prints the return value of the function.
The function should return the possible minimum area of the square satisfying all the three constraints.
Sample Input 0
2
0
2
2
0
4
2
Sample Output 0
36
Explanation 0
The given points are:
(0, 0)
(2, 4)
Now we can choose following four points:
(-1, -1)
(-1, 5)
(5, 5)
(5, -1)
Thus we draw a square of side six, satisfying the three constraints given in the problem statement and the area of the square is possible minimum.
￼
So, the function returns 36, as the area of the square is side x side (6 x 6 = 36).
Sample Input 1
2
0
3
2
0
7
2
Sample Output 1
81
Explanation 1
The given points are:
(0, 0)
(2, 7)
Now we can choose following four points:
(-1, -1)
(-1, 8)
(8, 8)
(8, -1)
Thus we draw a square of side nine, satisfying the three constraints given in the problem statement and the area of the square is possible minimum. So the function returns 81 (9 x 9).
Angry Children
easy Implementation Algorithms Greedy Brute Force Core CS
Use Question
Testcases: 6 (2 Sample)
Bill Gates is on one of his philanthropic journeys to a village in Utopia. He has N packets of candy and would like to distribute one packet to each of the K children in the village. Each packet may contain a different number of candy pieces. To avoid any fighting among the children, he would like to pick K out of N packets, such that unfairness is minimized.
Suppose the K packets have (x1, x2, x3,….xk) candy pieces in them, where xi denotes the number of candies in the ith packet. We defineunfairness as
max(x1,x2,…xk) - min(x1,x2,…xk)
where max denotes the highest value present in the argument list, and min denotes the lowest. Can you figure out the subset with minimum unfairness?
Input Format The first line contains an integer K. The second line contains an integer which represents the size of the array arr. The following lines comprise the elements of the arrayarr. Each of these lines contains an integer that denotes the candy in the ith packet.
Output Format A single integer which will be the minimum unfairness.
Constraints 1<=N<=105 1<=K<=N 0<= number of candies in any packet <=109
Sample Input #1
3
7
10
100
300
200
1000
20
30
Sample Output #1
20
Explanation #1 Here K = 3. We can choose packets that contain 10,20,30 candies. The unfairness is
max(10,20,30) - min(10,20,30) = 30 - 10 = 20
Sample Input #2
4
10
1
2
3
4
10
20
30
40
100
200
Sample Output #2
3
Explanation #2 Here K = 4. We can choose the packets that contain 1,2,3,4 candies. The unfairness is
max(1,2,3,4) - min(1,2,3,4) = 4 - 1 = 3

 *
 */
public class MinimumArea {
	static int minUnfairness(int k, int[] arr) {
	    //actually find the min of arr[i+k-1]-arr[i]
	    Arrays.sort(arr);
	    int n = arr.length;
	    int min = arr[n-1];
	    for (int i = 0; i < n-k+1; i++) {
	        min = Math.min(min, arr[i+k-1]-arr[i]);
	    }
	    return min;
	}   

}
