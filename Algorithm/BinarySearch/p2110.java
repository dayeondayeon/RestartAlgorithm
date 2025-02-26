package BinarySearch;

import java.io.*;
import java.util.*;

public class p2110 {
    private static int[] house;
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);
        int start = 0;
        int end = house[n-1] - house[0] + 1;
        // 0, 100000000 이렇게 2군데에 놓으면 +1 해서 구간 안구하면 99999999라는 잘못된 값 나온다..

        int answer = 0;

        while (start < end) {
            int mid = (start + end) / 2;
            if (count(mid) >= m) {
                answer = Math.max(answer, mid);
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }

        System.out.println(answer);
    }

    private static int count(int distance) {
        int answer = 1;
        int start = house[0];

        for (int i = 1; i < n; i++) {
            if (start + distance <= house[i]) {
                start = house[i]; // 갱신을 house로 해야한다!
                answer++;
            }
        }

        return answer;
    }
}
