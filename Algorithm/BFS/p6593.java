package BFS;

import java.util.*;
import java.io.*;

public class p6593 {
    private static char[][][] floor;
    private static int[][][] visited;

    private static int layer, row, col;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            layer = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());

            if (layer == 0 && row == 0 && col == 0) {
                break;
            }

            floor = new char[layer][row][col];
            visited = new int[layer][row][col];

            int[] start = new int[3];
            int[] end = new int[3];

            for (int l = 0; l < layer; l++) {
                for (int i = 0; i < row; i++) {
                    String temp = br.readLine();
                    for (int j = 0; j < col; j++) {
                        floor[l][i][j] = temp.charAt(j);
                        if (floor[l][i][j] == 'S') {
                            start = new int[] {l, i, j};
                        }

                        if (floor[l][i][j] == 'E') {
                            end = new int[] {l, i, j};
                        }
                    }
                }
                br.readLine();
            }
            BFS(start);

            if (visited[end[0]][end[1]][end[2]] == 0) {
                System.out.println("Trapped!");
            } else {
                System.out.printf("Escaped in %d minute(s).", visited[end[0]][end[1]][end[2]]-1);
                System.out.println();
            }
        }

    }

    private static void BFS(int[] start) {
        int[] dirZ = {0, 0, 0, 0, -1, 1};
        int[] dirX = {0, 0, 1, -1, 0, 0};
        int[] dirY = {1, -1, 0, 0, 0, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]][start[2]] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nextZ = poll[0] + dirZ[i];
                int nextX = poll[1] + dirX[i];
                int nextY = poll[2] + dirY[i];

                if (!isValid(nextZ, nextX, nextY)) {
                    continue;
                }

                if (floor[nextZ][nextX][nextY] == '#' || visited[nextZ][nextX][nextY] != 0) {
                    continue;
                }

                visited[nextZ][nextX][nextY] = visited[poll[0]][poll[1]][poll[2]] + 1;
                queue.add(new int[] {nextZ, nextX, nextY});
            }
        }
    }

    private static boolean isValid(int z, int x, int y) {
        return z >= 0 && z < layer && x >= 0 && x < row && y >= 0 && y < col;
    }
}
