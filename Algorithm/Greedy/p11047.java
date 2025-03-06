package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }


        for (int i = n-1; i >= 0; i--) {
            if (coins[i] > goal) {
                continue;
            }

            int temp = goal / coins[i];
            answer += temp;
            goal -= temp * coins[i];

            if (goal == 0) {
                break;
            }
        }

        System.out.println(answer);
    }
}
