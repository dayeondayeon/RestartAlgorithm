package BackTracking;

import java.util.Scanner;

public class p9663 {
    private static int[] cols;
    private static int[] slash; // /모양의 대각선 상 여부를 확인
    private static int[] reverseSlash; // \모양의 대각선 상 여부를 확인
    private static int n;
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        cols = new int[n];
        slash = new int[n*2-1];
        reverseSlash = new int[n*2-1];

        setQueen(0);
        System.out.println(answer);
    }

    // queen 한 줄에 하나씩 놓아야 함
    private static void setQueen(int row) {
        if (row == n) { // 마지막 줄까지 놓는데 성공했다면 배치 완료한것이므로 answer++
            answer++;
            return;
        }

        for (int c = 0; c < n; c++) {
            if (cols[c] != 0) {
                continue;
            }

            if (slash[row + c] != 0) {
                continue;
            }

            if (reverseSlash[row-c+n-1] != 0) {
                continue;
            }

            cols[c] = 1;
            slash[row+c] = 1;
            reverseSlash[row-c+n-1] = 1;
            setQueen(row+1);
            cols[c] = 0;
            slash[row+c] = 0;
            reverseSlash[row-c+n-1] = 0;
        }
        // 해당 열에 놓을 수 있는지를 판단
        // 대각선에 퀸 없는지 판단 -> / 모양은 x + y 가 같으면 같은 대각선상, \ 모양은 x - y가 같으면 같은 대각선

    }
}