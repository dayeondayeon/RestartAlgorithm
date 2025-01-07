package DP;

import java.io.*;
import java.util.*;
public class p1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer>[] DP = new ArrayList[n];
        List<Integer>[] num = new ArrayList[n];
        num[0] = new ArrayList<>();
        num[0].add(Integer.parseInt(br.readLine()));

        if (n == 1) {
            System.out.println(num[0].get(0));
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        num[1] = new ArrayList<>();
        DP[1] = new ArrayList<>();

        num[1].add(Integer.parseInt(st.nextToken()));
        num[1].add(Integer.parseInt(st.nextToken()));
        DP[1].add(num[0].get(0) + num[1].get(0));
        DP[1].add(num[0].get(0) + num[1].get(1));

        for (int i = 2; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            num[i] = new ArrayList<>();
            DP[i] = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                num[i].add(Integer.parseInt(st.nextToken()));
            }

            DP[i].add(DP[i-1].get(0) + num[i].get(0));

            for (int j = 1; j < i; j++) {
                DP[i].add(Math.max(DP[i-1].get(j-1), DP[i-1].get(j)) + num[i].get(j));
            }

            DP[i].add(DP[i-1].get(i-1) + num[i].get(i));
        }

        DP[n - 1].sort(Collections.reverseOrder());
        System.out.println(DP[n-1].get(0));
    }
}
