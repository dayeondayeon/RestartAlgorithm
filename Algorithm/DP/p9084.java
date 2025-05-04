package DP;

import java.io.*;
import java.util.*;

public class p9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for (int t = 0; t < test; t++) {
            int coin = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coins = new int[coin];

            for (int i = 0; i < coin; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(coins);
            int goal = Integer.parseInt(br.readLine());

            int[][] DP = new int[coin][goal+1];
            for (int i = 0; i < coin; i++) {
                DP[i][0] = 1;
            }

            for (int i = 0; i < coin; i++) {
                for (int j = 1; j <= goal; j++) {
                    if (i > 0) {
                        DP[i][j] += DP[i-1][j];
                    }
                    if (j >= coins[i]) {
                        DP[i][j] += DP[i][j-coins[i]];
                    }
                }
            }

            System.out.println(DP[coin-1][goal]);
        }
    }
}

/*
* 1, 2원으로 5원
* 1 1 1 1 1 =>
* 1 1 1 2
* 1 2 2
*
* DP [1] = 1
* DP [2] =
* */