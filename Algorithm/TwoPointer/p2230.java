package TwoPointer;

import java.io.*;
import java.util.*;

public class p2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = 0;
        int answer = arr[n-1] - arr[0];

        while (end < n) {
            if (arr[end] - arr[start] >= m) {
                answer = Math.min(answer, arr[end] - arr[start]);
                start++;
            } else {
                end++;
            }
        }

        System.out.println(answer);
    }
}
