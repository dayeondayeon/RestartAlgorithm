package DP;

import java.io.*;

public class p15989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int max = 3;
        int[] request = new int[t];
        for (int i = 0; i < t; i++) {
            request[i] = Integer.parseInt(br.readLine());
            max = Math.max(request[i], max);
        }

        int[] DP = new int[max+1];
        DP[0] = DP[1] = 1;
        DP[2] = 2;

        for (int i = 3; i <= max; i++) {
            DP[i] = DP[i-1] + DP[i-2] - DP[i-3];
            if (i % 3 == 0) {
                DP[i] += 1;
            }
        }

        for (int req : request) {
            System.out.println(DP[req]);
        }
    }
}
