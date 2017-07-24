package com.test.common;

public class PairSum implements Comparable<PairSum> {

	int first; // index (int A[]) of first element in pair
	int sec; // index of second element in pair
	int sum; // sum of the pair

	@Override
	public int compareTo(PairSum o) {
		return this.sum - o.sum;
	}

}
