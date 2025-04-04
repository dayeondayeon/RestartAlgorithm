package Hash;

import java.io.*;
import java.util.*;
public class p1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalNum = Integer.parseInt(st.nextToken());
        int query = Integer.parseInt(st.nextToken());

        Map<String, Integer> pokemonNames = new HashMap<>();
        Map<Integer, String> pokemonValues = new HashMap<>();

        for (int i = 1; i <= totalNum; i++) {
            String name = br.readLine();
            pokemonNames.put(name, i);
            pokemonValues.put(i, name);
        }

        for (int i = 0; i < query; i++) {
            String q = br.readLine();
            if (isNumeric(q)) {
                System.out.println(pokemonValues.get(Integer.parseInt(q)));
            } else {
                System.out.println(pokemonNames.get(q));
            }
        }
    }

    private static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }

        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
