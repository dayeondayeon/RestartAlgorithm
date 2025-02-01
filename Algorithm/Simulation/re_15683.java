package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class re_15683 {
    private static final int[] dirX = { -1, 0, 1, 0};
    private static final int[] dirY = { 0, 1, 0, -1};
    private static int[][] board1;
    private static int[][] board2;
    private static int row, col, blindSpot;
    private static List<int[]> cameras;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        board1 = new int[row][col];
        board2 = new int[row][col];

        blindSpot = 0;
        cameras = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                board1[i][j] = Integer.parseInt(st.nextToken());
                if (board1[i][j] == 0) {
                    blindSpot++;
                    continue;
                }
                if (board1[i][j] < 6) {
                    cameras.add(new int[] {i, j});
                }
            }
        }

        // 4 ^ n승 구하기
        int num = 1;
        for (int i = 0; i < cameras.size(); i++) {
            num *= 4;
        }

        for (int n = 0; n < num; n++) {
            // n이 카메라 모든 방향을 내포하는 4진수이다. 따라서 매번 board2배열을 board1으로 초기화 시켜주기
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    board2[i][j] = board1[i][j];
                }
            }

            int temp = n;
            for (int[] camera : cameras) {
                int dir = temp % 4;
                temp /= 4;

                int x = camera[0];
                int y = camera[1];

                if (board1[x][y] == 1) { // 1번 카메라는 한 방향만, 그 방향에만 checkVisible처리!
                    checkVisible(x, y, dir);
                } else if (board1[x][y] == 2) {
                    checkVisible(x, y, dir);
                    checkVisible(x, y, dir + 2);
                } else if (board1[x][y] == 3) {
                    checkVisible(x, y, dir);
                    checkVisible(x, y, dir + 1);
                } else if (board1[x][y] == 4) {
                    checkVisible(x, y, dir);
                    checkVisible(x, y, dir + 1);
                    checkVisible(x, y, dir + 2);
                } else {
                    checkVisible(x, y, dir);
                    checkVisible(x, y, dir + 1);
                    checkVisible(x, y, dir + 2);
                    checkVisible(x, y, dir + 3);
                }
            }

            int count = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board2[i][j] == 0) {
                        count++;
                    }
                }
            }

            blindSpot = Math.min(blindSpot, count);
        }

        System.out.println(blindSpot);
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    private static void checkVisible(int x, int y, int dir) {
        dir %= 4;
        while (true) {
            x += dirX[dir];
            y += dirY[dir];
            if (!isValid(x, y) || board2[x][y] == 6)
                return;
            if (board2[x][y] != 0)
                continue;
            board2[x][y] = 7;
        }
    }

}
