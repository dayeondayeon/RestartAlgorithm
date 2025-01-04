package BackTracking;

import java.io.*;
import java.util.*;

// 매 순간 수를 더할지 더하지 않을지 결정
// n개의 원소를 가진 수열에서 부분수열은 2^n -> 그 원소 포함 || 포함 x 이 2가지 케이스를 n개의 원소에 곱하기 때문..!
// 따라서 해당 원소를 넣는경우 , 안 넣는 경우 2가지 케이스에 대해 계속 재귀를 돌리면 된다.
public class p1182 {
    private static int n, s, answer = 0;
    private static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        count(0, 0);
        System.out.println(answer);
    }

    private static void count(int index, int sum) {
        if (index == n) {
            if (sum == s) {
                answer++;
                return;
            }
        }
        count(index+1, sum); // 더하지 않은 경우
        count(index+1, sum + num[index]); // 더한 경우
    }
}
