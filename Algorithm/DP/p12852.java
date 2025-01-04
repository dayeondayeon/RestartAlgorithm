package DP;

import java.util.Scanner;

public class p12852 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] pre = new int[n+1];
        int[] DP = new int[n+1];

        DP[0] = 0;
        DP[1] = 0;

        for (int i = 2; i <= n; i++) {
            pre[i] = i-1;
            DP[i] = DP[i-1] + 1;

            if (i % 2 == 0) {
                if (DP[i/2] + 1 < DP[i]) {
                    pre[i] = i/2;
                    DP[i] = DP[i/2] + 1;
                }
            }

            if (i % 3 == 0) {
                if (DP[i/3] + 1 < DP[i]) {
                    pre[i] = i/3;
                    DP[i] = DP[i/3] + 1;
                }
            }
        }

        System.out.println(DP[n]);
        System.out.print(n + " ");
        int index = n;
        while (index != 1) {
            System.out.print(pre[index] + " ");
            index = pre[index];
        }
    }
}
