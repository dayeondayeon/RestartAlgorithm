package Free;

import java.io.*;
import java.util.*;

public class p2169 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] DP = new int[n][m];
        DP[0][0] = map[0][0];
        for (int j = 1; j < m; j++) {
            DP[0][j] = DP[0][j-1] + map[0][j];
        }

        for (int r = 1; r < n; r++) {
            int[] left = new int[m];
            left[0] = DP[r-1][0] + map[r][0];

            // left
            for (int c = 1; c < m; c++) {
                left[c] = Math.max(DP[r-1][c], left[c-1]) + map[r][c];
            }

            int[] right = new int[m];
            right[m-1] = DP[r-1][m-1] + map[r][m-1];
            // right
            for (int j = m-2; j >= 0; j--) {
                right[j] = Math.max(DP[r-1][j], right[j+1]) + map[r][j];
            }

            for (int j = 0; j < m; j++) {
                DP[r][j] = Math.max(left[j], right[j]);
            }
        }

        System.out.println(DP[n-1][m-1]);
    }
}
