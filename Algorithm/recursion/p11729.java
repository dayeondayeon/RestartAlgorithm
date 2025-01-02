package recursion;

import java.util.Scanner;

public class p11729 {
    private static final StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sb.append((int)(Math.pow(2, n) -1)).append("\n");
        hanoi(1, 3, n);
        System.out.println(sb);
        sc.close();
    }

    private static void hanoi(int from, int end, int n) {
        if (n == 1) {
            sb.append(from).append(' ').append(end).append("\n");
            return;
        }
        hanoi(from, 6-from-end, n-1);
        sb.append(from).append(' ').append(end).append("\n");
        hanoi(6-from-end, end, n-1);
    }

    /**
     * 함수의 정의 : hanoi(int start, int end, int n)
     * base condition : n == 1
     * 기둥 3개의 번호 합이 6
     * n-1개의 원판을 6 - a - b로 옮긴다.
     * */
}
