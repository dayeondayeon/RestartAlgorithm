package DP;
import java.io.*;

public class p9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        int[] index = new int[test];
        for (int i = 0; i < test; i++) {
            index[i] = Integer.parseInt(br.readLine());
        }

        int[] DP = new int[11];
        DP[0] = DP[1] = 1;
        DP[2] = 2;

        for (int i = 3; i < 11; i++) {
            DP[i] = DP[i-1] + DP[i-2] + DP[i-3];
        }

        for (int i : index) {
            System.out.println(DP[i]);
        }
    }
}
