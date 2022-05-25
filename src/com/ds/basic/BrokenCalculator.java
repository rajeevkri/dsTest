package com.ds.basic;

public class BrokenCalculator {
    public int brokenCalc(int startValue, int target) {
        int temp = startValue;
        int count = 0;
        while(temp != target) {
            if(temp <=(target+1)/2) {
                temp = temp*2;
            } else {
                temp = temp -1;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
//        BrokenCalculator bc = new BrokenCalculator();
//        int res = bc.brokenCalc(5, 8);
//        int res = bc.brokenCalc(2, 3);
//        int res = bc.brokenCalc(3, 10);
//        int res = bc.brokenCalc(1024, 1);
//        System.out.println(res);
//        String s1 =
    }
}
