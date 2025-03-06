package Free;

import java.io.*;
import java.util.*;

public class p1477 {
    private static List<Integer> spots;
    private static int more;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int current = Integer.parseInt(st.nextToken());
        more = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());

        spots = new ArrayList<>();
        spots.add(0);
        spots.add(len);

        if (current > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < current; i++) {
                spots.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(spots);
        }

        int left = 0;
        int right = len;
        int answer = len;

        while (left < right) {
            int mid = (left + right) / 2;
            if (mid == 0) {
                break;
            }
            if (isAfford(mid)) {
                answer = Math.min(answer, mid);
                right = mid; // isAfford = true : 간격을 더 적게 만들 수 있다는 뜻
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean isAfford(int distance) {
        int start = 0;
        int tempMore = more;
        for (Integer spot : spots) {
            if (spot - start > distance) {
                if (tempMore >= (spot-start-1) / distance) {
                    tempMore -= (spot-start-1) / distance;
                } else {
                    return false;
                }
            }
            start = spot;
        }

        return tempMore >= 0;
    }
}
