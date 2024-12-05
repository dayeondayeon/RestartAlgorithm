package BFS;

import java.io.*;
import java.util.*;

public class p7576 {
    private static int[][] board;
    private static List<int[]> tomatoes;

    private static int row, col, tomatoCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        board = new int[row][col];
        tomatoes = new ArrayList<>();

        tomatoCount = 0;

        for (int i = 0; i < row; i++) {
            String[] lines = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                board[i][j] = Integer.parseInt(lines[j]);
                if (board[i][j] == 0) {
                    tomatoCount++;
                }
                if (board[i][j] == 1) {
                    tomatoes.add(new int[] {i, j});
                }
            }
        }

        if (tomatoes.size() == row * col) {
            System.out.println(0);
            return;
        }


        BFS();


        if (tomatoCount != 0) {
            System.out.println(-1);
            return;
        }

        int answer = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                answer = Math.max(answer, board[i][j]);
            }
        }

        System.out.println(answer-1);
    }

    private static void BFS() {
        int[] dirX = { -1, 0, 1, 0}; // NESW
        int[] dirY = {0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>(tomatoes);

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = poll[0] + dirX[i];
                int nextY = poll[1] + dirY[i];

                if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                    continue;
                }

                if (board[nextX][nextY] == 0) {
                    queue.add(new int[] {nextX, nextY});
                    board[nextX][nextY] = board[poll[0]][poll[1]] + 1;
                    tomatoCount--;
                }
            }
        }
    }
}
