package recursion;

import java.util.Scanner;

public class p1629 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        System.out.println(POW(a, b, c));
        sc.close();
    }

    private static long POW(long a, long b, long c) {
        if (b == 1)
            return a % c;
        long val = POW(a, b/2, c); // 2k를 구한다고 가정하고 k값을 먼저 계산

        val = val * val % c; // k값을 가져왔으니 2k를 구하려면 val끼리 제곱 후 나머지 연산
        if (b % 2 == 0)
            return val;
        return val * a % c; // 홀수라면 a 한번 더 곱해주기
    }
}
