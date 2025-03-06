package Greedy;

import java.io.*;
import java.util.Arrays;

public class p2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 1;
        int[] ropes = new int[n];
        int answer = -1;


        for (int i = 0; i < n; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);

        for (int i = n-1; i >= 0; i--) {
            answer = Math.max(answer, count * ropes[i]);
            count++;
        }

        System.out.println(answer);
    }
}
