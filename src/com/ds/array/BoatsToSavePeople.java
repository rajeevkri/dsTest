package com.ds.array;

import java.util.Arrays;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int ans = 0;

        while (i <= j) {
            ans++;
            if (people[i] + people[j] <= limit)
                i++;
            j--;
        }

        return ans;
    }

    public static void main(String[] args) {
        BoatsToSavePeople boatsToSavePeople = new BoatsToSavePeople();
//        int[] people = {1,2};
//        int[] people = {3,2,2,1};
//        int[] people = {3,5,3,4};
        int[] people = {5,1,4,2};
//        int limit = 3;
//        int limit = 5;
        int limit = 6;
        int count = boatsToSavePeople.numRescueBoats(people, limit);
        System.out.println(count);
    }
}
