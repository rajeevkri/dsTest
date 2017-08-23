package com.test.hackerrank.dp;

import java.util.Scanner;

public class CoinChanging {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // total of coin
        int m = in.nextInt(); // count of coin
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        long [][] dp = new long[m+1][n+1];
        for(int i=0; i<= m;i++) {
            dp[i][0] = 1;
        }
        for(int i =1; i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        
        System.out.println(dp[m][n]);
    }
}
