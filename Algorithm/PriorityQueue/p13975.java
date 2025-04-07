package PriorityQueue;

import java.io.*;
import java.util.*;

public class p13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++) {
            int count = Integer.parseInt(br.readLine());
            long sum = 0L;
            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < count; j++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            while (pq.size() > 1) {
                long first = pq.poll();
                long second = pq.poll();

                sum += (first + second);
                pq.add(first + second);
            }
            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
    }
}
