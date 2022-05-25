package com.ds.basic;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        String digits = "123456789";
        List<Integer> res = new ArrayList<>();
        int nl = String.valueOf(low).length();
        int nh = String.valueOf(high).length();

        for(int i = nl; i <= nh; i++){
            for(int j = 0; j < 10 - i; j++){
                int num = Integer.parseInt(digits.substring(j, j + i));
                if(num >= low && num <= high) res.add(num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SequentialDigits sd = new SequentialDigits();
        List<Integer> list = sd.sequentialDigits(1000, 13000);
        list.forEach(l -> System.out.println(l));

    }

    public List<Integer> sequentialDigitsSlow(int low, int high) {
        List<Integer> res = new ArrayList<>();
        String lowStr = String.valueOf(low);
        int n = lowStr.length();
        int currMax = 0;
        Integer st = 0;
        int last = 1;
        int increment = 0;
        for(int i=0; i<n; i++) {
            st = st *10 + last++;
            currMax = currMax *10 + 9;
            increment = increment * 10 +1;
        }
        Integer temp =st;
        while (true) {
            if(temp > high || temp > currMax) {
                break;
            }

            if(temp >= low) {
                res.add(temp);
            }
            int rem = temp % 10;
            if (rem == 9) {
                break;
            }
            temp = temp + increment;
        }
        while(currMax < high) {
            currMax = currMax *10 +9;
            st = st * 10 + last++;
            increment = increment * 10 +1;
            temp =st;
            while (true) {
                if(temp > high || temp > currMax) {
                    break;
                }
                if(temp > low) {
                    res.add(temp);
                }
                int rem = temp % 10;
                if (rem == 9) {
                    break;
                }
                temp = temp + increment;
            }
        }

        return res;
    }
}
