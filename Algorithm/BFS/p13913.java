package BFS;

import java.util.*;

public class p13913 {
    private static int[] before;
    private static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int me = sc.nextInt();
        int target = sc.nextInt();

        before = new int[100001];
        Arrays.fill(before, -1);
        visited = new int[100001];
        Arrays.fill(visited, -1);

        BFS(me, target);
        System.out.println(visited[target]);
        int count = visited[target];
        int temp = target;
        Deque<Integer> stack = new ArrayDeque<>();

        while (count > 0) {
            stack.push(before[temp]);
            temp = before[temp];
            count--;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.poll() + " ");
        }
        System.out.print(target);
    }

    private static void BFS(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        before[start] = 0;
        queue.add(start);
        visited[start] = 0;

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            if (isValid(now * 2) && visited[now*2] == -1) {
                before[now*2] = now;
                visited[now*2] = visited[now] + 1;
                queue.add(now*2);
            }

            if (isValid(now - 1) && visited[now-1] == -1) {
                before[now-1] = now;
                visited[now-1] = visited[now] + 1;
                queue.add(now-1);
            }

            if (isValid(now+1) && visited[now+1] == -1) {
                before[now+1] = now;
                visited[now+1] = visited[now] + 1;
                queue.add(now+1);
            }
        }
    }

    private static boolean isValid(int num) {
        return num >= 0 && num <= 100000;
    }
}
