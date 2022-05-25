package com.ds.array;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayOperations {

    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder outp = new StringBuilder("");
        for (String s1 : split) {
            char[] cStr = s1.toCharArray();
            reverseString(cStr);
            String joinedString = String.valueOf(cStr);
            outp.append(joinedString).append(" ");
        }

        return outp.toString().trim();
    }
    public static boolean sol(int[] arr, int start,int count){
        if(start>=arr.length || start<0)
            return false;
        if(arr[start]==0){
            return true;
        }
        if(count>=arr.length)
            return false;
        int jump= arr[start];
        boolean c1 = sol(arr, start+jump, count+1);
        if(c1==true)
            return true;
        boolean c2 = sol(arr, start-jump, count+1);
        if(c2==true)
            return true;
        return false;
    }

    public boolean canReach(int[] arr, int start) {
        boolean[] visited  = new boolean[arr.length];
        return canReach(arr, start, visited);
    }

    private boolean canReach(int[] arr, int start, boolean[] visited) {
        if(start>=arr.length || start<0)
            return false;
        if(arr[start]==0){
            return true;
        }
        if(visited[start])
            return false;
        visited[start] = true;
        int jump= arr[start];
        boolean isLeft =  canReach(arr, start-jump, visited);
        boolean isRight =  canReach(arr, start+jump, visited);
        return  isLeft || isRight;
    }

    public static int longestConsecutive(int[] arr) {
            Set<Integer> allNumSet = new HashSet<>();
            for(int i : arr) {
                allNumSet.add(i);
            }

            int maxLength = 1;

            for(Integer i: allNumSet) {
                int currentLength = 1;
                if(! allNumSet.contains(i-1)) {
                    int x= i +1;
                    while(allNumSet.contains(x)) {
                        currentLength++;
                        x++;
                    }
                    if(currentLength > maxLength) maxLength = currentLength;
                }
            }

            return maxLength;
        }

    public int longestConsecutive1(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public void reverseString(char[] s) {
        int l = s.length;
        int start = 0;
        int end = l - 1;
        while (start < end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }

    public void moveZeroes(int[] nums) {
        int l = nums.length;
        if (l == 1) {
            return;
        }
        int slow = 0;
        int fast = 1;
        while (fast < l) {
            if (nums[slow] != 0) {
                fast++;
                slow++;
            } else if (nums[slow] == 0 && nums[fast] != 0) {
                nums[slow] = nums[fast];
                nums[fast] = 0;
                fast++;
                slow++;
            } else if (nums[slow] == 0 && nums[fast] == 0) {
                fast++;
            }

        }
    }

    //Replace Elements with Greatest Element on Right Side
    public int[] replaceElementsWithGreatest(int[] arr) {
        int maxFromRight = -1;
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            int temp = maxFromRight;
            if (arr[i] > maxFromRight)
                maxFromRight = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
//        int[] arr = {7, 5, 6, 3, 4, 1, 2, 9, 11};
        ArrayOperations arrayOperations = new ArrayOperations();
//        int[] res = arrayOperations.replaceElementsWithNextGreat(arr);
//        for (int i = 0; i < res.length; i++) {
//            System.out.print(res[i] + " ");
//        }
        int[] arr = {1,7,9,5,4,1,2};
        boolean isMountain = arrayOperations.validMountainArray(arr);
        System.out.println(isMountain);
    }


    /**
     * <p>Replace element of an Array with nearest bigger number at right side of the Array in O(n)
     * <br>For example if the input Array is
     * <br>7, 5, 6, 3, 4, 1, 2, 9, 11
     * <br>output array should be
     * <br>9, 6, 9, 4, 9, 2, 9, 11, 11</p>
     *
     * @param arr
     * @return
     */
    public int[] replaceElementsWithNextGreat(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] >= st.peek())  //try to find > a[i] element
                st.pop();
            if (st.isEmpty())
                result[i] = arr[i];  //nothing > a[i] to right  (or use a[i] instead of INF)
            else
                result[i] = st.peek();    //this was > a[i] to right
            st.push(arr[i]);
        }
        return result;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> list = new HashSet<>();
        int n= nums.length;
        for(int i=0; i< n; i++) {
            list.add(i);
        }
        for(int i=0; i<n; i++) {
            list.remove(nums[i]);
        }
        return new ArrayList<Integer>(list);
    }

    public boolean validMountainArray(int[] arr) {
        if(arr.length ==1) return false;
        boolean isMountain = true;
        boolean isIncreasing = true;
        int last = arr[0];
        for(int i=1; i< arr.length; i++) {
            if(isIncreasing) {
                if(arr[i] > last) {
                    last = arr[i];
                    if(i == arr.length -1) {
                        isMountain = false;
                        break;
                    }
                    continue;
                } else if (arr[i] == last) {
                    isMountain = false;
                    break;
                } else {
                    if(i ==1) {
                        isMountain = false;
                        break;
                    }
                    last = arr[i];
                    isIncreasing = false;
                }
            } else {
                if(arr[i] >= last) {
                    isMountain = false;
                    break;
                }
                last = arr[i];
            }
        }
        return isMountain;
    }

    public boolean validMountainArray1(int[] A) {

        if(A.length < 3) return false;

        int n = A.length, L = 0, R = n-1;
        while(L < n-1) {
            if(A[L] < A[L+1]) L++;
            else break;
        }

        if(L == n-1) return false; // only strictly increasing -> 0 1 2 5 6 8 9

        while(R > 0) {
            if(A[R] < A[R-1]) R--;
            else break;
        }

        if(R == 0) return false; // only strictly decreasing -> 9 6 5 3 2 1 0

        return L == R;
    }
}
