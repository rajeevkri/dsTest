package com.ds.array;

public class CountingBits {

    public int[] countBits(int n) {
        String s = Integer.toBinaryString(n);
        char[] chars = s.toCharArray();
        int l = chars.length;
        int[] bits = new int[l];
        for(int i =0; i< l; i++) {
            bits[i] = chars[i];
        }
        return bits;
    }

    public static void main(String[] args) {
        CountingBits cb = new CountingBits();
        int[] ints = cb.countBits(2);
        for (int i:ints) {
            System.out.println(i);
        }
    }
}
