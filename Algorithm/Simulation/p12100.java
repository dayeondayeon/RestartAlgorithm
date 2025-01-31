package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p12100 {
    private static int[][] map;
    private static int[][] copied;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        copied = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int index = 0; index < 1024; index++) {
            for (int j = 0; j < n; j++) {
                System.arraycopy(map[j], 0, copied[j], 0, n);
            }

            int brute = index;
            for (int i = 0; i < 5; i++) {
                int dir = brute % 4;
                brute /= 4;
                tilt(dir);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    max = Math.max(max, copied[i][j]);
                }
            }
        }

        System.out.println(max);
    }

    private static void rotate() {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                temp[i][j] = copied[i][j];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                copied[i][j] = temp[n-j-1][i];
    }

    private static void tilt(int dir) {
        while (dir-- > 0) {
            rotate();
        }
        for (int rowIndex = 0; rowIndex < n; rowIndex++) {
            int[] tilted = new int[n];
            int last = 0;

            for (int i = 0; i < n; i++) {
                if (copied[rowIndex][i] == 0) {
                    continue;
                }

                if (tilted[last] == 0) {
                    tilted[last] = copied[rowIndex][i];
                }
                else if (tilted[last] == copied[rowIndex][i]) {
                    tilted[last++] *= 2;
                }
                else {
                    tilted[++last] = copied[rowIndex][i];
                }
            }

            for (int j = 0; j < n; j++) {
                copied[rowIndex][j] = tilted[j];
            }

        }
    }

}
