package BinarySearch;

import java.util.*;
import java.io.*;

public class p2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = n-1;
        int[] answer = new int[2];
        answer[0] = num[start];
        answer[1] = num[end];

        while (start < end) {
            if (num[start] + num[end] > 0) {
                if (isNearThan(answer[1] + answer[0], num[end] + num[start])) {
                    answer[0] = num[start];
                    answer[1] = num[end];
                }
                end--;
            } else if (num[start] + num[end] < 0) {
                if (isNearThan(answer[1] + answer[0], num[end] + num[start])) {
                    answer[0] = num[start];
                    answer[1] = num[end];
                }
                start++;
            } else {
                answer[0] = num[start];
                answer[1] = num[end];
                break;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }

    private static boolean isNearThan(int answer, int num) {
        return  Math.abs(answer) > Math.abs(num);
    }
}
