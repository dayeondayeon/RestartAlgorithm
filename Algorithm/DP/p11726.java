package DP;

import java.util.Scanner;

public class p11726 {
    public static void main(String[] args) {
        int mod = 10007;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] DP = new int[n+1];
        DP[0] = 1;
        DP[1] = 1;

        for (int i = 2; i <= n; i++) {
            DP[i] = (DP[i-1] + DP[i-2]) % mod;
        }

        System.out.println(DP[n]);
    }
}
