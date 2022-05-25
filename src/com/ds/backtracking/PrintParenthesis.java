package com.ds.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintParenthesis {
    public static void main (String[] args)
    {
        int n = 3;
        PrintParenthesis parenthesis = new PrintParenthesis();
        List<String> list = parenthesis.generateParenthesis( n);
        list.forEach(System.out::println);
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n > 0) {
            char[] str = new char[2 * n];
            generateParenthesis(n, str, 0, 0, 0, list);
        }
        return list;
    }

    private void generateParenthesis(int n, char[] str, int pos, int open, int close, List<String> list) {
        if(close == n) {
            String out = String.copyValueOf(str);
            list.add(out);
        } else {
            if(open > close) {
                str[pos] = ')';
                generateParenthesis(n, str, pos + 1, open, close +1, list);
            }
            if (open < n) {
                str[pos] = '(';
                generateParenthesis(n, str, pos + 1, open + 1, close, list);
            }
        }
    }
}
