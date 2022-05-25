package com.ds.string;

import java.util.Arrays;

public class SmallestString {

    public String getSmallestString(int n, int k) {
        char[] ca = new char[n];
        Arrays.fill(ca, 'a');
        k -= n;
        for (int i = n - 1; i >= 0 && k > 0; --i) {
            ca[i] += Math.min(25, k);
            k -= Math.min(k, 25);
        }
        return String.valueOf(ca);

    }

    public String getSmallestStringSlow(int n, int k) {
        int [] arr = new int[n];
        Arrays.fill(arr, 1);
        int temp = k - n;
        String res = "";
        for(int i = n-1; i>=0; i--) {
            int rem = temp - 25;
            if(temp < 25 ) {
                arr[i] = arr[i] + temp;
                break;
            } else {
                arr[i] = arr[i] + 25;
                temp = rem;
            }
        }

        for(int i = n-1; i>=0; i--) {
            res = getCharacter(arr[i] - 1) + res;
        }
        return (res);
    }

    public Character getCharacter(int i) {
        Character ch = Character.valueOf((char) ('a' + i));
        return ch;
    }

    public static void main(String[] args) {
//        Character ch = Character.valueOf((char) ('a' + 25));
//        System.out.println(ch);
        SmallestString ss = new SmallestString();
//        String res = ss.getSmallestString(5, 73);
//        String res = ss.getSmallestString(3, 27);
        String res = ss.getSmallestString(5, 42);

        System.out.println(res);
    }
}
;