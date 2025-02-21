package BackTracking;

import java.util.*;

public class p15651 {
    private static int n, m;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        n = sc.nextInt();
        m = sc.nextInt();
        permutation(new ArrayDeque<>(), 0);

        System.out.println(sb);
        sc.close();
    }

    private static void permutation(Deque<Integer> list, int depth) {
        if (depth == m) {
            for (Integer i : list) {
                sb.append(i);
                sb.append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            list.addLast(i);
            permutation(list, depth+1);
            list.removeLast();
        }
    }
}
