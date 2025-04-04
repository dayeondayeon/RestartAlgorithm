package Hash;

import java.util.*;
import java.io.*;

public class p7785 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> people = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] record = br.readLine().split(" ");

            if ("enter".equals(record[1])) {
                people.add(record[0]);
            } else {
                people.remove(record[0]);
            }
        }

        List<String> list = new ArrayList<>(people);
        list.sort(Collections.reverseOrder());
        for (String name : list) {
            System.out.println(name);
        }
    }
}
