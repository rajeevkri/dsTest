package com.ds.string;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        char[] chArr = columnTitle.toCharArray();
        int n = chArr.length;
        int total = 0;
        for(int i=0; i<n; i++) {
            int x = chArr[i] - 'A' + 1;
            total = total * 26 + x;
        }
        return total;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber es = new ExcelSheetColumnNumber();
        int zy = es.titleToNumber("ZY");
        System.out.println(zy);
    }
}
