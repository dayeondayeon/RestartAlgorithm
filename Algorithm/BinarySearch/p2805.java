package BinarySearch;

import java.util.*;
import java.io.*;

public class p2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] tree = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);
        int result = getResult(n, tree, m);

        System.out.println(result);
    }

    private static int getResult(int n, int[] tree, int m) {
        int start = 0;
        int end = tree[n-1];

        while (start <= end) {
            int mid = (start + end) / 2;
            long sum = 0L;
            for (int i = 0; i < n; i++) {
                if (tree[i] > mid) {
                    sum += (tree[i] - mid);
                }
            }

            if (sum >= m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}
