package com.ds.array;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target >= matrix[mid][0]
                    && target <= matrix[mid][n - 1]) {
                return binarySearch1D(matrix[mid], target, n);
            }

            if (target < matrix[mid][0]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return false;
    }
    static boolean binarySearch1D(int arr[], int K, int N)
    {
        int low = 0;
        int high = N - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == K) {
                return true;
            }

            if (arr[mid] < K) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int [][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int n = arr.length;
        int m = arr[0].length;
        System.out.println("m = " + m  + " n = " + n);
    }
}
