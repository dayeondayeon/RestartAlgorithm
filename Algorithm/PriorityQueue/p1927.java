package PriorityQueue;

import java.io.*;

public class p1927 {
    private static int[] heap = new int[100005];
    private static int size = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                if (size == 0) {
                    bw.write("0");
                    bw.newLine();
                } else {
                    bw.write(pop()+"\n");
                }
            } else {
                push(input);
            }
        }

        bw.flush();
        bw.close();
    }

    static void push(int x) {
        if (size >= 100005) {
            return;
        }
        heap[++size] = x;

        int i = size;
        while (i > 1 && heap[i / 2] > heap[i]) {
            int temp = heap[i];

            heap[i] = heap[i/2];
            heap[i/2] = temp;
            i /= 2;
        }
    }

    static int pop() {
        int target = heap[1]; // root
        heap[1] = heap[size];
        heap[size--] = 0;

        int i = 1;
        while (i * 2 <= size) {
            int left = i * 2;
            int right = left + 1;
            int min = left;

            if (right <= size && heap[right] < heap[left]) {
                min = right;
            }

            if (heap[i] <= heap[min]) {
                break;
            }

            int temp = heap[i];
            heap[i] = heap[min];
            heap[min] = temp;

            i = min;
        }
        return target;
    }

    static int peek() {
        return heap[1];
    }
}
