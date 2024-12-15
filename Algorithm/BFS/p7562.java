package BFS;

import java.util.*;
import java.io.*;
public class p7562 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++) {
            int size = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] now = new int[2];
            now[0] = Integer.parseInt(st.nextToken());
            now[1] = Integer.parseInt(st.nextToken());

            int[] target = new int[2];
            st = new StringTokenizer(br.readLine());
            target[0] = Integer.parseInt(st.nextToken());
            target[1] = Integer.parseInt(st.nextToken());


            System.out.println(BFS(size, now, target));
        }

    }

    private static int BFS(int size, int[] now, int[] target) {
        int[] dirX = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dirY = {-2, -1, 1, 2, 2, 1, -1, -2};

        int[][] visited = new int[size][size];
        Queue<int[]> queue = new LinkedList<>();
        visited[now[0]][now[1]] = 1;
        queue.add(now);

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nextX = poll[0] + dirX[i];
                int nextY = poll[1] + dirY[i];

                if (nextX < 0 || nextY < 0 || nextX >= size || nextY >= size) {
                    continue;
                }

                if (visited[nextX][nextY] != 0) {
                    continue;
                }

                queue.add(new int[] {nextX, nextY});
                visited[nextX][nextY] = visited[poll[0]][poll[1]] + 1;
            }
        }

        return visited[target[0]][target[1]] - 1;
    }
}
