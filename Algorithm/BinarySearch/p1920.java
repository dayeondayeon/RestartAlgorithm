package BinarySearch;

import java.io.*;
import java.util.*;

public class p1920 {
    private static int[] sortedNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        sortedNum = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sortedNum[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        int[] targets = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sortedNum);
        for (int t : targets) {
            System.out.println(binSearch(t));
        }
    }

    private static int binSearch(int target) {
        int left = 0;
        int right = sortedNum.length-1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (sortedNum[mid] == target) {
                return 1;
            }
            else if (sortedNum[mid] < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        return 0;
    }
}
