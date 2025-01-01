package DP;

import java.util.*;
import java.io.*;

public class p1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] DP = new int[n+1];
        int[] num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        DP[0] = num[0];
        int max = DP[0];

        for (int i = 1; i < n; i++) {
            DP[i] = Math.max(DP[i-1] + num[i], num[i]);
            max = Math.max(DP[i], max);
        }

        System.out.println(max);
    }
}
