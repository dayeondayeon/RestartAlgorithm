package BackTracking;

import java.util.*;

public class p15650 {
    private static int n, m;
    private static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        used = new boolean[n+1];

        permutation(1, new ArrayDeque<>());
    }

    private static void permutation(int index, Deque<Integer> list) {
        if (list.size() == m) {
            for (Integer i : list) {
                if (used[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }

        for (int i = index; i <= n; i++) {
            if (used[i])
                continue;
            used[i] = true;
            list.addLast(i);
            permutation(i, list);
            list.removeLast();
            used[i] = false;
        }
    }
}
