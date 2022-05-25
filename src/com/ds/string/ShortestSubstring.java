package com.ds.string;

import java.util.function.Function;

public class ShortestSubstring {
    public static void main(String[] args) {
//        String input1 = "My name is Fran";
//        String input2 = "rim";
        String input1 = "rjivmklskd";
        String input2 = "rim";
        System.out.println(getShortestSubstring(input1, input2));
    }

    private static String getShortestSubstring(String mainString, String toBeSearched) {

        int mainStringLength = mainString.length();
        int toBeSearchedLength = toBeSearched.length();

        if (toBeSearchedLength > mainStringLength) {
            throw new IllegalArgumentException("search string cannot be larger than main string");
        }

        for (int j = 0; j < mainStringLength; j++) {
            for (int i = 0; i <= mainStringLength - toBeSearchedLength; i++) {
                String substring = mainString.substring(i, i + toBeSearchedLength);
                if (checkIfMatchFound(substring, toBeSearched)) {
                    return substring;
                }
            }
            toBeSearchedLength++;
        }

        return null;
    }

    private static boolean checkIfMatchFound(String substring, String toBeSearched) {
        char[] charArraySubstring = substring.toCharArray();
        char[] charArrayToBeSearched = toBeSearched.toCharArray();
        int count = 0;

        for (int i = 0; i < charArraySubstring.length; i++) {
            for (int j = 0; j < charArrayToBeSearched.length; j++) {
                if (String.valueOf(charArraySubstring[i]).equalsIgnoreCase(String.valueOf(charArrayToBeSearched[j]))) {
                    count++;
                }
            }
        }
        return count == charArrayToBeSearched.length;
    }

    public String func(Integer num, Function<Integer, String> lambda) {
        return lambda.apply(num);
    }
}
