package BFS;

import java.util.*;
import java.io.*;

public class p3197 {
    private static int row, col;
    private static Queue<int[]> water;
    private static Queue<int[]> swan;
    private static final int[] dirX = {1, 0, -1, 0};
    private static final int[] dirY = { 0, 1, 0, -1};
    private static boolean[][] swanVisited;
    private static char[][] lake;

    private static final int[] startSwan = new int[2];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        lake = new char[row][col];
        swanVisited = new boolean[row][col];

        water = new LinkedList<>();
        swan = new LinkedList<>();

        int count = 0;

        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                lake[i][j] = line.charAt(j);
                if (lake[i][j] == 'L') {
                    startSwan[0] = i;
                    startSwan[1] = j;
                }
                if (lake[i][j] != 'X') {
                    water.add(new int[] { i, j });
                }
            }
        }

        swan.add(startSwan);
        swanVisited[startSwan[0]][startSwan[1]] = true;

        while (!swanMeet()) {
            melt();
            count++;
        }

        System.out.println(count);
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    private static boolean swanMeet() {
        Queue<int[]> next = new LinkedList<>();

        // 하루동안의 변화에 대한 탐색
        while (!swan.isEmpty()) {
            int[] poll = swan.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dirX[i];
                int ny = poll[1] + dirY[i];

                if (!isValid(nx, ny) || swanVisited[nx][ny]) {
                    continue;
                }

                swanVisited[nx][ny] = true;

                if (lake[nx][ny] == 'L') {
                    return true;
                } else if (lake[nx][ny] == 'X') { // 다음 탐색 대상 칸(얼음이므로)
                    next.add(new int[] {nx, ny});
                } else {
                    swan.add(new int[] {nx, ny});
                }
            }
        }

        swan = next;
        return false;
    }

    private static void melt() {
        int waterSize = water.size();
        // waterSize 가 필요한 이유는 water.add()를 밑에서 하기 때문에 water.isEmpty()라고 하면 계속 녹이고 탐색하고를 반복한다.
        // 하루에 녹는양은 딱 melt 시작 시점에 water 개수까지만 루프를 돌려야 하므로 waterSize 계산할 필요가 있다.

        for (int w = 0; w < waterSize; w++) {
            int[] current = water.poll();

            for (int i= 0; i < 4; i++) {
                int nextX = current[0] + dirX[i];
                int nextY = current[1] + dirY[i];

                if (!isValid(nextX, nextY)) {
                    continue;
                }

                if (lake[nextX][nextY] == 'X') {
                    lake[nextX][nextY] = '.';
                    water.add(new int[] {nextX, nextY});
                }
            }
        }
    }
}
