package BinarySearch;
import java.util.*;
import java.io.*;
/**
 * 특정 숫자를 배열에 넣을때, 그 배열의 오름차 순이 유지되도록 한다고 생각해보자
 * 그러면 가장 작은 위치가 해당 숫자의 시작점, 가장 큰 위치가 해당 숫자의 마지막 위치이다.
 * 큰 위치 - 작은 위치가 배열에 있는 해당 원소의 개수이다.
 * 큰 위치 == 작은 위치라면, 해당 원소가 배열에 존재하지 않는 것
 * */

public class p10816 {
    private static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        int m = Integer.parseInt(br.readLine());
        int[] targets = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int target : targets) {
            bw.write(binSearch(target) + " ");
        }

        bw.flush();

        br.close();
        bw.close();
    }

    private static int binSearch(int target) {

        // 가장 왼쪽 시작점 구하기
        int start = 0;
        int end = num.length;

        while (start < end) {
            int mid = (start + end) / 2;
            if (num[mid] >= target) {
                end = mid;
                // mid가 target이 들어갈 수 있는 가장 왼쪽 위치가 될 수 있음
                // num[mid] == target인 경우에도!
            } else if (num[mid] < target) {
                start = mid + 1;
            }
        }

        int left = start;

        // 가장 오른쪽 구하기
        start = 0;
        end = num.length;

        while (start < end) {
            int mid = (start + end) / 2;
            if (num[mid] > target) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        int right = end;

        return right - left;
    }
}
