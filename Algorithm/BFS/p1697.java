package BFS;

import java.util.*;

public class p1697 {
    private static final int[] visited = new int[100001];
    private static int bro;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int me = sc.nextInt();
        bro = sc.nextInt();

        Arrays.fill(visited, -1);
        BFS(me);

        System.out.println(visited[bro]);
    }

    private static void BFS(int me) {
        Queue<Integer> queue = new LinkedList<>();
        visited[me] = 0;
        queue.add(me);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            if (poll == bro) {
                return;
            }

            if (isValid(poll-1) && visited[poll-1] == -1) {
                visited[poll-1] = visited[poll] + 1;
                queue.add(poll-1);
            }

            if (isValid(poll+1) && visited[poll+1] == -1) {
                visited[poll+1] = visited[poll] + 1;
                queue.add(poll+1);
            }

            if (isValid(poll*2) && visited[poll*2] == -1) {
                visited[poll*2] = visited[poll] + 1;
                queue.add(poll*2);
            }
        }

    }

    private static boolean isValid(int i) {
        return i >= 0 && i <= 100000;
    }
}
