package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2294{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] DP = new int[10001];
        for (int coin : coins) {
            DP[coin] = 1;
        }

        for (int i = 1; i <= k; i++) {
            for (int coin : coins) {
                if (i > coin && i-coin > 0 && DP[i-coin] > 0) {
                    if (DP[i] == 0) {
                        DP[i] = DP[i-coin]+1;
                        continue;
                    }
                    DP[i] = Math.min(DP[i] , DP[i-coin] + 1);
                }
            }
        }

        if (DP[k] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(DP[k]);
        }
    }
}
