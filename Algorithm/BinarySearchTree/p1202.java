package BinarySearchTree;

import java.util.*;
import java.io.*;
public class p1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int jewels = Integer.parseInt(st.nextToken());
        int bags = Integer.parseInt(st.nextToken());
        long sum = 0L;

        /**
         * 가격 높은 보석을 담을 수 있는 가방 중 가장 작은 가방에 담기
         * 보석은 가격 순으로 정렬
         * 가방은 treeSet
         */

        TreeMap<Integer, List<Integer>> jewelMap = new TreeMap<>(Collections.reverseOrder());
        // price, weight
        TreeMap<Integer, Integer> bagMap = new TreeMap<>();

        for (int i = 0; i < jewels; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewelMap.putIfAbsent(price, new ArrayList<>());
            jewelMap.get(price).add(weight);
        }

        for (int i = 0; i < bags; i++) {
            int bag = Integer.parseInt(br.readLine());
            bagMap.putIfAbsent(bag, 0);
            bagMap.put(bag, bagMap.get(bag) + 1);
        }

        for (Integer jewel : jewelMap.keySet()) {
            for (Integer weight : jewelMap.get(jewel)) {
                NavigableMap<Integer, Integer> tempMap = bagMap.tailMap(weight, true);
                if (tempMap.isEmpty()) {
                    continue;
                }

                if (bagMap.get(tempMap.firstKey()) == 1) {
                    bagMap.remove(tempMap.firstKey());
                } else {
                    bagMap.put(tempMap.firstKey(), bagMap.get(tempMap.firstKey()) - 1);
                }
                sum += jewel;
            }
        }

        System.out.println(sum);
    }
}
