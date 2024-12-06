package BFS;

import java.io.*;
import java.util.*;

public class p4179 {
    private static int row, col;
    private static char[][] map;
    private static int[][] fireTime;
    private static int[][] escapeTime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new char[row][col];
        fireTime = new int[row][col];
        escapeTime = new int[row][col];

        int[] jh = new int[2];
        List<int[]> fires = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            Arrays.fill(fireTime[i], -1);
            Arrays.fill(escapeTime[i] , -1);
        }

        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = line.charAt(j);

                if (map[i][j] == 'J') {
                    jh[0] = i;
                    jh[1] = j;
                    continue;
                }

                if (map[i][j] == 'F') {
                    fires.add(new int[] {i, j});
                }
            }
        }

        fireBFS(fires);
        int answer = jhBFS(jh);

        if (answer == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(answer);
        }
    }

    private static int jhBFS(int[] pos) {
        int answer = Integer.MAX_VALUE;
        int[] dirX = {-1, 0, 1, 0};
        int[] dirY = {0, -1, 0, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(pos);
        escapeTime[pos[0]][pos[1]] = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = poll[0] + dirX[i];
                int nextY = poll[1] + dirY[i];

                if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                    answer = Math.min(answer, escapeTime[poll[0]][poll[1]] + 1);
                    continue;
                }

                if (fireTime[nextX][nextY] != -1 && fireTime[nextX][nextY] <= escapeTime[poll[0]][poll[1]] + 1) {
                    continue;
                }

                if (map[nextX][nextY] == '#' || map[nextX][nextY] == 'F' || escapeTime[nextX][nextY] != -1) {
                    continue;
                }

                queue.add(new int[] {nextX, nextY});
                escapeTime[nextX][nextY] = escapeTime[poll[0]][poll[1]] + 1;
            }
        }
        return answer;
    }

    private static void fireBFS(List<int[]> fires) {
        int[] dirX = {-1, 0, 1, 0};
        int[] dirY = {0, -1, 0, 1};
        Queue<int[]> queue = new LinkedList<>(fires);
        for (int[] fire : fires) {
            fireTime[fire[0]][fire[1]] = 0;
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = poll[0] + dirX[i];
                int nextY = poll[1] + dirY[i];

                if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                    continue;
                }

                if (map[nextX][nextY] == '#' || map[nextX][nextY] == 'F' || fireTime[nextX][nextY] != -1) {
                    continue;
                }

                queue.add(new int[] {nextX, nextY});
                fireTime[nextX][nextY] = fireTime[poll[0]][poll[1]] + 1;
            }
        }
    }
}
