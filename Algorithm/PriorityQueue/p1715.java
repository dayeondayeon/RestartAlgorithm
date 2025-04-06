package PriorityQueue;

import java.io.*;
import java.util.PriorityQueue;

public class p1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int sum = 0;
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        while (pq.size() > 1) {
            int first = pq.poll();
            first += pq.poll();

            sum += first;
            pq.add(first);
        }

        System.out.println(sum);
    }
}
