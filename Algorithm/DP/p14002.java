package DP;

import java.io.*;
import java.util.*;
public class p14002 {
    public static void main(String[] args) throws IOException{
        // D[i] : i번째 인덱스까지 읽었을 때 가장 긴 증가하는 부분수열의 길이
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        int[][] DP = new int[n][2];
        for (int i = 0; i < n; i++) {
            DP[i][0] = 1;
            DP[i][1] = -1;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0 ; j < i; j++) {
                if (nums[i] > nums[j] && DP[i][0] < DP[j][0] + 1) {
                    DP[i][0] = DP[j][0] + 1;
                    DP[i][1] = j;
                }
            }
        }

        int maxLen = 1;
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {
            if (DP[i][0] > maxLen) {
                maxLen = DP[i][0];
                maxIndex = i;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(maxLen + "\n");

        int index = maxIndex;
        List<Integer> answerList = new ArrayList<>();
        while (index != -1) {
            answerList.add(nums[index]);
            index = DP[index][1];
        }

        Collections.reverse(answerList);
        for (Integer i : answerList) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();
    }
}
