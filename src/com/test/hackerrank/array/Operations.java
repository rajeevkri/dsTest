package com.test.hackerrank.array;

public class Operations {
	static int[] mergeArrays(int[] a, int[] b) {

        int aLength = a.length;
        int bLength = b.length;
        int []m = new int[aLength + bLength];
        int i=0, j=0;
        int k=0;
        while(i<aLength && j<bLength) {
            if(a[i] <= b[j]) {
                m[k++] = a[i++];
            } else {
                m[k++] = b[j++];
            }
        }
        if(i<aLength) {
            while(i<aLength) {
                m[k++] = a[i++];
            }
        }
        if(j < bLength) {
            while(j < bLength) {
                m[k++] = b[j++];
            }
        }
        return m;
    }
	public static void main(String[] args) {
		
	}
}
