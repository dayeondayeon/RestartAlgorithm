package BinarySearch;

import java.util.*;
import java.io.*;

public class p7453 {
    private static int n;
    private static int[] CD;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        long answer = 0L;

        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] AB = new int[n*n];
        CD = new int[n*n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[index] = A[i] + B[j];
                CD[index] = C[i] + D[j];
                index++;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        for (int i : AB) {
            answer += count(i * -1);
        }

        System.out.println(answer);
    }

    private static int count(int target) {
        // most Left
        int left = 0;
        int right = n * n;
        while (left < right) {
            int mid = (left + right) / 2;
            if (CD[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int start = left;

        // mostRight
        left = 0;
        right = n * n;

        while (left < right) {
            int mid = (left + right) / 2;
            if (CD[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return  right - start;
    }

}
