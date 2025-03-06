package Free;

import java.io.*;
import java.util.*;

public class p12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());

        List<int[]> products = new ArrayList<>();
        int[] DP = new int[maxWeight+1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            products.add(new int[] {
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            });
        }

        // 뒤에서부터 갱신해야 하는 이유?
        // 같은 물건을 여러 번 선택하는 경우를 방지하기 위해!
        for (int[] product : products) {
            for (int i = maxWeight; i >= product[0]; i--) {
                DP[i] = Math.max(DP[i], DP[i-product[0]] + product[1]);
            }
        }

        System.out.println(DP[maxWeight]);
    }
}
