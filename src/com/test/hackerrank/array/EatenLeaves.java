package com.test.hackerrank.array;

import java.util.ArrayList;

/**
 * The caterpillar problem.
 * 
 * Input:
 * 
 * int[] caterPillar = {2,4,5} int totalLeaves = 10 Here, you will have fixed
 * size array with integer elements called catter pillars. For example: [2,4,5]
 * and you have integer value of totalLeaves. For example 10, so it will have
 * values from 1 to 10.
 * 
 * Now the question will be like, how many leaves will be left if it will be
 * eaten in a way where (Leaf % catterpillar == 0).
 * 
 * So for our example,
 * 
 * we have leaves [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * 
 * Caterpillar 2 can eat: 2, 4, 6, 8, 10
 * 
 * Caterpillar 4 can eat: 4, 8
 * 
 * Caterpillar 5 can eat: 5, 10
 * 
 * So the left leaves will be: 1,3,7,9
 * 
 * Total of 4 leaves will be left.
 * 
 * Here the naïve approach would be to loop over all the leaves and also loop
 * over all the caterpillars and discard those leaves that are divisible by it.
 * It will have 0 (n2) complexity.
 * 
 * Approach 1. Here the first improvement can be achieved, if you look at the
 * caterpillar array. Here you have [2,4,5]. The easiest catch is the discard
 * those caterpillars which are divisible by other. So which will make our
 * caterpillar array [2,4]. It is because the leaves that are eaten by 4 can
 * also be eaten by 2. So we do not need to loop over all the caterpillars. This
 * way we can save many iterations by reducing unnecessary caterpillar.
 * 
 * Below code is implementation of above approach.
 *
 */
public class EatenLeaves {
	public static void main(String args[]) {
		int inputArray[] = { 2, 4, 5, 10, 12 };
		System.out.println("Survived Leaves Count:" + returnCountLeaves(10, inputArray));
	}

	static int returnCountLeaves(int N, int[] A) {

		ArrayList<Integer> reduceArrayList = new ArrayList<Integer>();
		reduceArrayList.add(A[0]);
		boolean reduceFlag = false;

		for (int i = 1; i < A.length; i++) {
			reduceFlag = false;
			for (int j = 0; j < reduceArrayList.size(); j++) {
				if (A[i] % reduceArrayList.get(j) == 0) {
					reduceFlag = true;
					break;
				}
			}

			if (!reduceFlag) {
				reduceArrayList.add(A[i]);
			}
		}

		System.out.println("Reduced Caterpillars:" + reduceArrayList);

		int survivedLeaves = 0;
		for (int m = 1; m <= N; m++) {
			for (int j = 0; j < reduceArrayList.size(); j++) {
				if (m % reduceArrayList.get(j) == 0) {
					survivedLeaves++;
					break;
				}
			}
		}

		return N - survivedLeaves;
	}
}
