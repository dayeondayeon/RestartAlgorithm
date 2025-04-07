package PriorityQueue;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        PriorityQueue<Integer> reward = new PriorityQueue<>();

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            reward.add(poll[1]);

            if (!reward.isEmpty() && reward.size() > poll[0]) {
                reward.poll();
            }
        }

        while (!reward.isEmpty()) {
            answer += reward.poll();
        }

        System.out.println(answer);
    }
}
