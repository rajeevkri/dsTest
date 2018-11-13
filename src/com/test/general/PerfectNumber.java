package com.test.general;

public class PerfectNumber {

	// Method to check number n is perfect number or not
	boolean isPerfect(long n) {
		// To store sum of divisors
		long sum = 1;

		// Find all divisors and add them
		for (long i = 2; i * i <= n; i++)
			if (n % i == 0)
				sum = sum + i + n / i;

		// If sum of divisors is equal to
		// n, then n is a perfect number
		if (sum == n && n != 1)
			return true;

		return false;
	}

	// Method to find GCD or HCF for two numbers
	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	// Driver method
	public static void main(String[] args) {
		int a = 98, b = 56;
		System.out.println("GCD of " + a + " and " + b + " is " + gcd(a, b));
	}
}
