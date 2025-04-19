package BinarySearch;

import java.io.*;
import java.util.*;

public class p3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] time = new int[n];

        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(time);

        long start = getAnswer(time, m);

        System.out.println(start);
    }

    private static long getAnswer(int[] time, int m) {
        long start = 0L;
        long end = 1000000_000000_000000L;

        // mid초 안에 가능한지 찾는 문제
        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0L;

            // 그 시간동안 심사 가능한 최대 인원
            for (int t : time) {
                sum += (mid / t);
                if (sum >= m) {
                    break;
                }
            }

            if (sum >= m) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
