package DP;

import java.io.*;
import java.util.StringTokenizer;

public class p11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int[] DP = new int[n];
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            DP[i] = num[i];
            answer = Math.max(answer, num[i]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (num[i] > num[j] && DP[i] < DP[j] + num[i]) {
                    DP[i] = DP[j] + num[i];
                    answer = Math.max(answer, DP[i]);
                }
            }
        }

        System.out.println(answer);
    }
}
