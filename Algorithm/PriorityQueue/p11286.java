package PriorityQueue;

import java.io.*;
import java.util.*;
public class p11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            }
            return Math.abs(o1) - Math.abs(o2);
        });

        for (int i = 0; i < n; i++) {
            int op = Integer.parseInt(br.readLine());
            if (op == 0) {
                if (pq.isEmpty()) {
                    bw.write("0");
                    bw.newLine();
                } else {
                    bw.write(pq.poll() + "\n");
                }
            } else {
                pq.add(op);
            }
        }

        bw.flush();
        bw.close();
    }
}
