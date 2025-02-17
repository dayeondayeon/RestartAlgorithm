package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p2295 {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        int[] num = new int[n];
        int[] two = new int[n*n];

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                two[index++] = num[i] + num[j];
            }
        }

        Arrays.sort(two); // 이거 빠뜨리지 말기!!! 정렬 무조건 필요
        for (int i = n-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (Arrays.binarySearch(two, num[i] - num[j]) >= 0) {
                    answer = Math.max(answer, num[i]);
                }
            }
        }

        System.out.println(answer);
    }
}
