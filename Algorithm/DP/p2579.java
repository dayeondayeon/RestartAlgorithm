package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n+1];
        int[][] DP = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        // DP[i][j] : 현재 칸(i) 포함 j개의 계단을 연속해서 밟고 i번째에 도달했을 때 최대 점수 합

        DP[1][1] = stairs[1];
        DP[1][2] = 0;

        if (n >= 2) {
            DP[2][1] = stairs[2];
            DP[2][2] = stairs[1] + stairs[2];
        }

        for (int i = 3; i <= n; i++) {
            DP[i][1] = Math.max(DP[i-2][1], DP[i-2][2]) + stairs[i];
            DP[i][2] = DP[i-1][1] + stairs[i];
        }

        System.out.println(Math.max(DP[n][1], DP[n][2]));
    }
}
