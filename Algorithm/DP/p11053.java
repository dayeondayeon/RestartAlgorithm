package DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] DP = new int[n];
        Arrays.fill(DP, 1);
        int answer = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (num[i] > num[j] && DP[i] <= DP[j]) {
                    DP[i] = DP[j] + 1;
                    answer = Math.max(DP[i], answer);
                }
            }
        }
        System.out.println(answer);
    }
}
