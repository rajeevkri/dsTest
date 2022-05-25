package com.ds.basic;

public class DoubleOperation {

    public double myPow(double x, int n) {
        double res = 1;
        if(n == -2147483648) {
            res = x;
            n = n +1;
        }
        boolean isNegative = n <0;
        if(isNegative) n = -1 * n;
        while(n>0) {
            if((n&1) == 1){
                // this mean y is odd
                res = res * x;
            }
            n = n >>1;
            x = x * x;
        }

        if(isNegative) {
            res = 1/res;
        }
        return res;
    }

    public static void main(String[] args) {
        DoubleOperation dop = new DoubleOperation();
        dop.myPow(2.00, -2147483648);
        //2.00000
        //-2147483648

    }

    static int power(int x, int y)
    {
        int res = 1;

        while (y > 0)
        {
            // If y is odd,
            // multiply
            // x with result
            if ((y & 1) == 1)
                res = res * x;

            // y must be even now
            y = y >> 1; // y = y/2
            x = x * x; // Change x to x^2
        }
        return res;
    }
}
