package Simulation;

import java.util.*;
import java.io.*;

public class p15686 {
    private static List<int[]> chickens;
    private static List<int[]> houses;
    private static boolean[] isChosen;
    private static int m, answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        chickens = new ArrayList<>();
        houses = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int cell = Integer.parseInt(st.nextToken());
                if (cell == 0)
                    continue;

                if (cell == 1) {
                    houses.add(new int[] {i, j});
                    continue;
                }
                chickens.add(new int[] {i , j});
            }
        }

        isChosen = new boolean[chickens.size()];
        answer = Integer.MAX_VALUE;

        chooseChickens(0, 0);
        System.out.println(answer);
    }

    private static void chooseChickens(int depth, int index) {
        // Java 는 조합 라이브러리가 없다는 놀라운 사실
        if (depth == m) {
            // 다 뽑았으면 계산하기
            int piv = 0;
            int[] chickenSelected = new int[m];
            for (int i = 0; i < isChosen.length; i++) {
                if (isChosen[i]) {
                    chickenSelected[piv++] = i;
                }
            }
            calculateDistance(chickenSelected);
        }

        for (int i = index; i < chickens.size(); i++) {
            isChosen[i] = true;
            chooseChickens(depth+1, i+1);
            isChosen[i] = false;
        }
    }

    private static void calculateDistance(int[] chickenSelected) {
        int sum = 0;
        for (int[] house : houses) {
            int minDis = 2500;
            for (int i : chickenSelected) {
                minDis = Math.min(minDis, Math.abs(house[0] - chickens.get(i)[0]) + Math.abs(house[1] - chickens.get(i)[1]));
            }
            sum += minDis;
        }
        answer = Math.min(answer, sum);
    }

}
