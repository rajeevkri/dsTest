package com.ds.string;

public class AddDigits {
    public int addDigits(int num) {
        if(num == 0){
            return 0;
        } else if(num % 9 == 0) {
            return 9;
        }
        return num%9;
    }

    public static void main(String[] args) {
        AddDigits addDigits = new AddDigits();
        int sum = addDigits.addDigits(38);
        System.out.println(sum);
    }
}
