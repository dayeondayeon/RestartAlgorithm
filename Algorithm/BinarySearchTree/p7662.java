package BinarySearchTree;

import java.io.*;
import java.util.*;

public class p7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringTokenizer st;
        TreeMap<Integer, Integer> treeMap;

        for (int i = 0; i < test; i++) {
            int operation = Integer.parseInt(br.readLine());
            treeMap = new TreeMap<>();
            for (int j = 0; j < operation; j++) {
                st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int val = Integer.parseInt(st.nextToken());

                if ("I".equals(op)) {
                    treeMap.putIfAbsent(val, 0);
                    treeMap.put(val, treeMap.get(val) + 1);
                    continue;
                }


                if (treeMap.isEmpty()) {
                    continue;
                }

                int target;
                if (val == 1) { // 최대값 지우기
                    target = treeMap.lastKey(); // 최대값
                } else {
                    target = treeMap.firstKey();
                }

                if (treeMap.get(target) == 1) {
                    treeMap.remove(target);
                }
                else {
                    treeMap.put(target, treeMap.get(target) - 1);
                }
            }

            if (treeMap.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(treeMap.lastKey() + " " + treeMap.firstKey());
            }
        }
    }
}
