package com.ds.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class RemoveInvalidBracket {

//    static boolean isValidString(String str)
//    {
//        int cnt = 0;
//        for (int i = 0; i < str.length(); i++)
//        {
//            if (str.charAt(i) == '(')
//                cnt++;
//            else if (str.charAt(i) == ')')
//                cnt--;
//            if (cnt < 0)
//                return false;
//        }
//        return (cnt == 0);
//    }
//
//    static void removeInvalidParenthesis(String str)
//    {
//        if (str.isEmpty())
//            return;
//
//        HashSet<String> visit = new HashSet<String>();
//
//        Queue<String> q = new LinkedList<>();
//        String temp;
//        boolean level = false;
//
//        q.add(str);
//        visit.add(str);
//        while (!q.isEmpty())
//        {
//            str = q.peek(); q.remove();
//            if (isValidString(str))
//            {
//                System.out.println(str);
//
//                level = true;
//            }
//            if (level)
//                continue;
//            for (int i = 0; i < str.length(); i++)
//            {
//                if (!isParenthesis(str.charAt(i)))
//                    continue;
//
//                temp = str.substring(0, i) + str.substring(i + 1);
//                if (!visit.contains(temp))
//                {
//                    q.add(temp);
//                    visit.add(temp);
//                }
//            }
//        }
//    }
}
