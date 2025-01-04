package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] num = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] DP = new int[n+1];
        DP[1] = num[1];
        for (int i = 2; i <= n; i++) {
            DP[i] = DP[i-1] + num[i];
        }

        int[][] tests = new int[t][2];
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            tests[i][0] = Integer.parseInt(st.nextToken());
            tests[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int [] test : tests) {
            System.out.println(DP[test[1]] - DP[test[0]-1]);
        }
    }
}
