package DP;

import java.util.*;

public class p1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] DP = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            int min = DP[i-1] + 1;

            if (i % 2 == 0) {
                min = Math.min(min, DP[i/2] + 1);
            }
            if (i % 3 == 0) {
                min = Math.min(min, DP[i/3] + 1);
            }
            DP[i] = min;
        }

        System.out.println(DP[n]);
    }
}