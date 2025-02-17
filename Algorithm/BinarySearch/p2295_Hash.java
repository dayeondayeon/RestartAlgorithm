package BinarySearch;

import java.io.*;
import java.util.*;

public class p2295_Hash {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        int[] num = new int[n];
        Set<Integer> two = new HashSet<>();

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(num);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                two.add(num[i] + num[j]);
            }
        }

        for (int i = n-1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (two.contains(num[i] - num[j])) {
                    answer = Math.max(answer, num[i]);
                }
            }
        }

        System.out.println(answer);
    }
}
