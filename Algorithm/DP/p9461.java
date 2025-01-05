package DP;

import java.util.Scanner;

public class p9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        int[] testCase = new int[test];
        for (int i = 0; i < test; i++) {
            testCase[i] = sc.nextInt();
        }

        long[] DP = new long[101];
        DP[1] = DP[2] = 1L;

        for (int i = 3; i <= 100; i++) {
            DP[i] = DP[i-2] + DP[i-3];
        }

        for (int i : testCase) {
            System.out.println(DP[i]);
        }
    }
}
