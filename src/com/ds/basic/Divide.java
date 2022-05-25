package com.ds.basic;

public class Divide {
    public int divide(int dividend, int divisor) {
        if(divisor ==1) {
            return dividend ;
        }
        if(divisor ==-1) {
            if(dividend == -2147483648) {
                return 2147483647;
            }
            return -1* dividend ;
        }
        boolean isNegative = divisor < 0;
        if(isNegative) {
            if(dividend < 0) {
                isNegative = false;
                dividend = -1 * dividend;
            }
            divisor = -1 * divisor;
        } else {
            if(dividend < 0) {
                isNegative = true;
                dividend = -1 * dividend;
            }
        }


        int count = 0;
        while(dividend >= divisor) {
            dividend = dividend - divisor;
            count ++;
        }
        return isNegative ? -1* count :count;
    }

    public static void main(String[] args) {
        Divide d = new Divide();
        int divide = d.divide(-2147483648, -1);
        System.out.println(divide);
    }
}
