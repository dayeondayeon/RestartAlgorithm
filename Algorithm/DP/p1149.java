package DP;

import java.io.*;
import java.util.StringTokenizer;

public class p1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] cost = new int[n][3];
        int[][] DP = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int color = 0; color < 3; color++) {
                cost[i][color] = Integer.parseInt(st.nextToken());
            }
        }

        DP[0][0] = cost[0][0];
        DP[0][1] = cost[0][1];
        DP[0][2] = cost[0][2];

        for (int i = 1; i < n; i++) {
            DP[i][0] = Math.min(DP[i-1][1], DP[i-1][2]) + cost[i][0];
            DP[i][1] = Math.min(DP[i-1][2], DP[i-1][0]) + cost[i][1];
            DP[i][2] = Math.min(DP[i-1][0], DP[i-1][1]) + cost[i][2];
        }
        System.out.println(Math.min(DP[n-1][0], Math.min(DP[n-1][1], DP[n-1][2])));
    }
}
