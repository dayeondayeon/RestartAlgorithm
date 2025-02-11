package DP;

import java.util.Scanner;

public class p2225 {
    public static void main(String[] args) {
        int NUM = 1000000000;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        long[][] DP = new long[n+1][k+1];

        for (int i = 0; i <= n; i++) {
            DP[i][1] = 1L;
        }

        for (int j = 2; j <= k; j++) {
            for (int i = 0; i <= n; i++) {
                for (int t = 0; t <= i; t++) {
                    DP[i][j] += DP[t][j-1];
                }
                DP[i][j] = DP[i][j] % NUM;
            }
        }

        System.out.println(DP[n][k]);
    }
}
