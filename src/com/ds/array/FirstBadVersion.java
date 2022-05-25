package com.ds.array;

public class FirstBadVersion {
    public static boolean isBadVersion(int mid) {
        return mid>=2;
    }
    public static int firstBadVersion(int n) {

        int res = firstBadVersion(n, 1, n, -1);
        return res;
    }

    public static int firstBadVersion(int n, int from, int to, int lastIndex) {
        if(to <= from) {
            if(isBadVersion(to)) {
                return to;
            }
        }
        int mid = ((to- from)/2) + from;
        boolean isBad = isBadVersion(mid);
        if(from == mid) {
            if(isBad) {
                return mid;
            }
            if(lastIndex != -1) {
                return lastIndex;
            }
            if(isBadVersion(to)) {
                return to;
            }
        }
        int res = -1;


        if(isBad) {
            lastIndex = mid;
            //mid = mid / 2;
            res = firstBadVersion(n, from, mid, lastIndex);
        } else {
            if(lastIndex != -1) {
                res = firstBadVersion(n, mid, lastIndex, lastIndex);
            } else {
                res = firstBadVersion(n, mid, to, lastIndex);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = firstBadVersion(2);
        System.out.println(res);
    }
}
