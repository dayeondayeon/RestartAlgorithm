package DP;

/*
* 2차원 DP...
* DP[i][j] = 첫 번째 문자열의 i번째 읽고 두 번째 문자열이 j번쨰 일때 공통 최장 부분수열길이
* first & second 두 문자열의 마지막 글자가 같다면
*   D[i-1][j-1] + 1 / D[i-1][j] + 1 / D[i][j-1] + 1 이렇게 3가지 중 MAX
* first & second 두 문자열의 마지막 글자가 다르다면
*   D[i-1][j], D[i][j-1] 둘 중 하나
* 2차원 배열에서 보면, 구하려는 칸의 왼쪽, 위쪽 칸들만 필요로한다.
* 따라서 왼쪽 -> 오른쪽 방향으로
*/
import java.io.*;
public class p9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();

        int m = first.length();
        int n = second.length();

        int[][] DP = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (first.charAt(i) == second.charAt(0)) {
                DP[i][0] = 1;
            } else if (i != 0) {
                DP[i][0] = DP[i-1][0];
            }
        }

        for (int j = 0; j < n; j++) {
            if (first.charAt(0) == second.charAt(j)) {
                DP[0][j] = 1;
            } else if (j != 0) {
                DP[0][j] = DP[0][j-1];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (first.charAt(i) == second.charAt(j)) {
                    DP[i][j] = DP[i-1][j-1] + 1;
                }
                DP[i][j] = Math.max(DP[i][j], Math.max(DP[i-1][j], DP[i][j-1]));
            }
        }

        System.out.println(DP[m-1][n-1]);
    }
}
