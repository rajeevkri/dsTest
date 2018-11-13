package com.test.greedy;

import java.util.Scanner;

/**
 * Rearranging arrays
You are given an array A containing N elements and you are required to do the following:

Remove all the repetitions of the number X from this array
Move all the remaining elements to the right
Fill the empty spots on the left side with 1
Write a program to print the rearranged array.

Input format

First line: T (number of test cases)
First line in each test case: N
Second line in each test case: N space-separated integers (denoting the array )
Third line in each test case: X
Output format

For each test case, print the rearranged array.

Constraints





Sample Input
2
5 
22 1 34 22 16
22
7
3 5 3 5 5 11 5
5
Sample Output
1 1 1 34 16
1 1 1 1 3 3 11



Explanation
For the first sample input, all the occurrences of the number 22 are removed from the slots. The remaining elements are moved to the right. The empty slots are moved to the left and filled with 1. Therefore, the answer is:

1 1 1 34 16

Note: Your code should be able to convert the sample input into the sample output. However, this is not enough to pass the challenge, because the code will be run on multiple test cases. Therefore, your code must solve this problem statement.

 * @author srajeev
 *
 */
public class RearrangeArray {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
*/
        //Scanner
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();                 // Reading input from STDIN
        // System.out.println();    // Writing output to STDOUT
        for(int i=0; i<n; i++) {
            int size = s.nextInt();
            int[] arr = new int[size];
            for(int j=0; j<size; j++) {
                arr[j] = s.nextInt();
            }
            int numberToRemove = s.nextInt();;
            int [] newArr = new int[size];
            int k = size -1;
            for(int j =size -1; j>=0; j--) {
                if(arr[j] != numberToRemove) {
                    newArr[k--] = arr[j];
                }
            }
            while(k>=0) {
                newArr[k--] = 1;
            }
            for(int j=0; j<size; j++) {
                System.out.print(newArr[j] + " ");
            }
            System.out.println();
        }

        

        // Write your code here

    }

}
