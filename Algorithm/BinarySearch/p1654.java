package BinarySearch;

import java.util.*;
import java.io.*;

public class p1654 {
    private static long[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        num = new long[n];
        for (int i = 0; i < n; i++) {
            num[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(num);

        long start = 1;
        long end = (1L << 31) - 1; // 2^31 - 1

        while (start < end) {
            long mid = (start + end +1) / 2;
            if (cut(mid) >= m) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }

    private static long cut(long len) {
        long count = 0L;
        for (long i : num) {
            count += i / len;
        }
        return count;
    }
}
