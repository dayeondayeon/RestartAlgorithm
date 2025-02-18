package BackTracking;

import java.io.*;
import java.util.*;

public class p6603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int testCase = Integer.parseInt(st.nextToken());
            if (testCase == 0) {
                break;
            }

            int[] num = new int[testCase];
            boolean[] used = new boolean[testCase];

            for (int i = 0; i < testCase; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            backTracking(0, 0, num, used);
            System.out.println();
        }
    }

    private static void backTracking(int current, int index, int[] num, boolean[] used) {
        if (current == 6) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < num.length; i++) {
                if (used[i]) {
                    sb.append(num[i]).append(' ');
                }
            }
            System.out.println(sb);
            return;
        }

        for (int i = index; i < num.length; i++) {
            if (used[i])
                continue;
            used[i] = true;
            backTracking(current+1, i, num, used);
            used[i] = false;
        }
    }
}
