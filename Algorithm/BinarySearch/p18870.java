package BinarySearch;

import java.io.*;
import java.util.*;

public class p18870 {
    private static int[] num;
    private static int[] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        temp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            temp[i] = num[i];
        }

        temp = removeDuplicated();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : num) {
            bw.write(binSearch(i, temp) + " ");
        }
        bw.flush();

        bw.close();
        br.close();
    }

    private static int binSearch(int target, int[] num) {
        int start = 0;
        int end = num.length-1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (num[mid] == target) {
                return mid;
            } else if (num[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    private static int[] removeDuplicated() {
        Arrays.sort(temp);
        List<Integer> list = new ArrayList<>();
        list.add(temp[0]);
        int prev = temp[0];

        for (int i = 1; i < temp.length; i++) {
            if (prev == temp[i]) {
                continue;
            }
            list.add(temp[i]);
            prev = temp[i];
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
