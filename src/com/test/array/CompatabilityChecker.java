package com.test.array;

/**
 * 
 * Two friends Kohli and Dhoni want to test their friendship to check how
 * compatible they are. Given a list of n movies numbered 1,2,3....n and asked
 * both of them to rank the movies. Design an algorithm to find compatibility
 * difference between them.
 * 
 * Compatibility difference is the number of mis-matches in the relative
 * rankings of the same movie given by them i.e. if Kohli ranks Movie 3 before
 * Movie 2 and Dhoni ranks Movie 2 before Movie 3 then its a relative ranking
 * mis-match Compatibility difference is the maximum number of mis-matches
 * 
 * Sample Input
 * 
 * 5 31245 32415 Sample Output
 * 
 * 2 Explanation
 * 
 * Movies are 1,2,3,4,5. Kohli ranks them 3,1,2,4,5, Dhoni ranks them 3,2,4,1,5.
 * Compatibility difference is 2 because Kohli ranks movie 1 before 2,4 but
 * Dhoni ranks it after.
 * 
 * 
 * @author rajeevsingh
 *
 */
public class CompatabilityChecker {
	public static int solve(int arr1[], int arr2[], int n) {
		int relativeDifference = 0;
		for (int i = 0; i < n; i++)
		{
			if (arr1[i] != arr2[i])
			{
				int j = i + 1;
				while (arr1[i] != arr2[j])
				{
					j++;
				}
				while (j != i)
				{
					swap(arr2, j, j - 1);
					j--;
					relativeDifference++;
				}

			}
		}
		return relativeDifference;
	}

	private static void swap(int[] arr, int i, int index) {
		int a = arr[index];
		arr[index] = arr[i];
		arr[i] = a;
	}
	
	public static void main(String[] args) {
		int[] arr1 = { 3, 1, 2, 4, 5 };
		int[] arr2 = { 3, 2, 4, 1, 5 };
		int n = 5;
		System.out.println(solve(arr1, arr2, n));
	}
}
