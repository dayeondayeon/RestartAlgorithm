package BinarySearch;

import java.io.*;
import java.util.*;

public class p12015 {
    private static int[] num;
    private static List<Integer> lis;
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        lis = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for (int i : num) {
            if (lis.isEmpty()) {
                lis.add(i);
                continue;
            }

            if (lis.get(lis.size()-1) < i) {
                lis.add(i);
            } else  {
                int index = findLower(i);
                lis.set(index, i);
            }
        }

        System.out.println(lis.size());
    }

    // 숫자를 넣을 수 있는 가장 왼쪽 인덱스를 찾는 과정
    private static int findLower(int target) {
        int start = 0;
        int end = lis.size();

        // target == num[mid]라면, 우리는 가장 낮은걸 찾을거라 End를 띵겨와야 함.
        // 따라서 등호가 end = mid로 땡겨오는쪽에
        while (start < end) {
            int mid = (start + end) / 2;
            if (target <= lis.get(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }
}
