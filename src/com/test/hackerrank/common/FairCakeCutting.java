package com.test.hackerrank.common;

import java.util.Scanner;

public class FairCakeCutting {

    static long howManyToInvite(long A, long B, long a) {
        // Return the number of people Leha should invite to his party
        long n = (a*B)/A;
        return n;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long A = in.nextLong();
        long B = in.nextLong();
        long a = in.nextLong();
        long b = howManyToInvite(A, B, a);
        System.out.println(b);
        in.close();
    }
}
