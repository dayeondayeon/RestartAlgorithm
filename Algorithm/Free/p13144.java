package Free;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long answer = 0L;
        int start = 0;

        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int end = 0; end < n; end++) {
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);

            while (map.getOrDefault(arr[end], 0) > 1) {
                map.put(arr[start], map.get(arr[start])-1);
                if (map.get(arr[start]) == 0) {
                    map.remove(arr[start]);
                }
                start++;
            }
            answer += (end - start + 1);
        }
        System.out.println(answer);
    }
}