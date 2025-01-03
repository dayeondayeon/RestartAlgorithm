package BackTracking;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class p15649 {
    private static boolean[] used;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        used = new boolean[n+1];
        findPermutation(m, n, new ArrayDeque<>());
        sc.close();
    }

    private static void findPermutation(int goalDepth, int n, Deque<Integer> list) {
        if (list.size() == goalDepth) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            list.addLast(i);
            findPermutation(goalDepth, n, list);
            list.removeLast();
            used[i] = false;
        }
    }
}
