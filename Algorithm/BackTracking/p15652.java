package BackTracking;

import java.util.*;

public class p15652 {
    private static StringBuilder sb;
    private static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sb = new StringBuilder();

        find(0, 1, new ArrayDeque<>());
        System.out.println(sb);
    }

    private static void find(int depth, int index, Deque<Integer> list) {
        if (depth == m) {
            for (Integer i : list) {
                sb.append(i).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i = index; i <= n; i++) {
            list.add(i);
            find(depth+1, i, list);
            list.removeLast();
        }
    }
}
