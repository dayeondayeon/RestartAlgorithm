package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1926 {
    static int row, col;
    static int[][] board;
    static boolean[][] visited;
    static int[] dirX = { -1, 0, 1, 0}; // NESW
    static int[] dirY = { 0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        board = new int[row][col];
        visited = new boolean[row][col];
        int picture = 0;
        int answer = 0;

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j] || board[i][j] != 1) {
                    continue;
                }
                answer = Math.max(answer, BFS(i, j));
                picture++;
            }
        }

        System.out.println(picture);
        System.out.println(answer);
    }

    private static int BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[] {x, y});
        int count = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dirX[i];
                int ny = poll[1] + dirY[i];

                if (nx < 0 || nx >= row || ny < 0 || ny >= col)
                    continue;

                if (visited[nx][ny] || board[nx][ny] == 0)
                    continue;

                visited[nx][ny] = true;
                queue.add(new int[] {nx, ny});
                count++;
            }
        }

        return count;
    }
}
