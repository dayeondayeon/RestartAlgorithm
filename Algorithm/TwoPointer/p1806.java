package TwoPointer;

import java.io.*;
import java.util.*;

public class p1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int standard = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        long sum = arr[0];
        int answer = n+1;

        while (start <= end) {
            if (sum >= standard) {
                answer = Math.min(answer, end - start + 1);
                sum -= arr[start];
                start++;
            } else {
                end++;
                if (end < n) {
                    sum += arr[end];
                } else {
                    break;
                }
            }
        }

        if (answer == n+1) {
            answer = 0;
        }
        System.out.println(answer);
    }
}
