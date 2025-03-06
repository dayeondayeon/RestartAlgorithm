package Greedy;

import java.util.*;
import java.io.*;

public class p1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int time = 0;
        int answer = 0;

        /**
         * 가능한 회의 중에 가장 먼저 끝나는 회의 선택
         * 현재 시간이 T라고 할 때, 시작 시간이 T이상인 여러 회의 중 가장 먼저 끝나는 회의를 택하는 것이 최적해이다.
         * */

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            pq.add(new int[] {
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            });
        }

        while (!pq.isEmpty()) {
            int[] meeting = pq.poll();
            if (time > meeting[0]) {
                continue;
            }

            time = meeting[1];
            answer++;
        }

        System.out.println(answer);
    }
}
