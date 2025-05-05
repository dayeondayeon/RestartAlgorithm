package DP;

import java.util.*;
import java.io.*;
public class p12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] DP = new int[n+1][k+1];
        // DP[i][j] : i번째 물건까지 j의 무게일 때 가치의 최대

        int[][] values = new int[n+1][2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            values[i][0] = Integer.parseInt(st.nextToken()); // weight
            values[i][1] = Integer.parseInt(st.nextToken()); // value

            if (values[i][0] <= k) {
                DP[i][values[i][0]] = values[i][1];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                 DP[i][j] = DP[i-1][j];
                if (j >= values[i][0]) {
                    DP[i][j] = Math.max(DP[i-1][j], DP[i-1][j-values[i][0]] + values[i][1]);
                }
            }
        }


        System.out.println(DP[n][k]);
    }
}
