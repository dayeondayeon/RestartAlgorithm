package BFS;

import java.io.*;
import java.util.*;

public class p2178 {
    private static int[][] board;
    private static int[][] visited;
    private static int row, col;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        board = new int[row][col];
        visited = new int[row][col];

        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                board[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }

        BFS(0,0);
        System.out.println(visited[row-1][col-1]);
    }

    private static void BFS(int x, int y) {
        int[] dirX = {-1, 0, 1, 0}; //NESW
        int[] dirY = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = poll[0] + dirX[i];
                int nextY = poll[1] + dirY[i];

                if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                    continue;
                }

                if (visited[nextX][nextY] != 0 || board[nextX][nextY] == 0) {
                    continue;
                }

                queue.add(new int[] {nextX, nextY});
                visited[nextX][nextY] = visited[poll[0]][poll[1]] + 1;
            }
        }
    }
}
