package Simulation;

import java.util.*;
import java.io.*;

public class p15683 {
    // dir : NESW 순서로 0,1,2,3
    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0, -1};

    private static int[][] map;
    private static int[][] temp;
    private static int row, col;
    private static List<int[]> cameras;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        temp = new int[row][col];
        cameras = new ArrayList<>();

        // 문제에 cctv가 아예 없다는 조건이 없음. 그렇기때문에 아예 없는 경우도 생각해야 해서 empty 변수 필요
        int empty = 0;

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 0) {
                    empty++;
                    continue;
                }

                if (map[i][j] != 6) {
                    cameras.add(new int[]{i, j});
                }
            }
        }

        int max = (int) Math.pow(4, cameras.size());
        for (int i = 0; i < max; i++) {
            copyMap();
            int temp = i;

            for (int[] camera : cameras) {
                int dir = temp % 4;
                temp /= 4;

                int x = camera[0];
                int y = camera[1];

                if (map[x][y] == 1) {
                    findCanMonitor(x, y, dir);
                } else if (map[x][y] == 2) {
                    findCanMonitor(x, y, dir);
                    findCanMonitor(x, y, dir + 2);
                } else if (map[x][y] == 3) {
                    findCanMonitor(x, y, dir);
                    findCanMonitor(x, y, dir + 1);
                } else if (map[x][y] == 4) {
                    findCanMonitor(x, y, dir);
                    findCanMonitor(x, y, dir + 1);
                    findCanMonitor(x, y, dir + 2);
                } else {
                    findCanMonitor(x, y, dir);
                    findCanMonitor(x, y, dir + 1);
                    findCanMonitor(x, y, dir + 2);
                    findCanMonitor(x, y, dir + 3);
                }
            }

            empty = Math.min(empty, findUnmonitoredSpace());
        }

        System.out.println(empty);
    }

    private static int findUnmonitoredSpace() {
        int val = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (temp[i][j] == 0) {
                    val++;
                }
            }
        }
        return val;
    }

    private static void copyMap() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp[i][j] = map[i][j];
            }
        }
    }

    private static void findCanMonitor(int x, int y, int dir) {
        dir %= 4;
        while (true) {
            x += dirX[dir];
            y += dirY[dir];

            if (!isValid(x, y) || map[x][y] == 6) {
                return;
            }

            if (temp[x][y] != 0) {
                continue;
            }

            temp[x][y] = 7;
        }
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

}
