package recursion;

import java.io.*;
import java.util.StringTokenizer;

public class p1074 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        System.out.println(recurseSquare(n, r, c));
    }

    private static int recurseSquare(int n, int r, int c) {
        // 2^n * 2^n 배열에서 r,c를 방문하는 순서를 반환하는 함수
        if (n == 0) {
            return 0;
        }
        int half = (int)(Math.pow(2, n-1));// 4등분 했을 때 몇번째 사각형이냐 따라서 칸 수 더해줘야 한다(8*8 사이즈에서 3영역에 있는 칸을 구하는 거라면 32를 더해주듯)
        if (r < half && c < half) return recurseSquare(n-1, r, c);
        if (r < half && c >= half) return half * half + recurseSquare(n-1, r, c-half);
        if (r >= half && c < half) return half * half * 2 + recurseSquare(n-1, r-half, c);
        return half * half * 3 + recurseSquare(n-1, r-half, c-half);
    }
}
