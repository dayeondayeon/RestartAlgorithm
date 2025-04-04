package Hash;

import java.io.*;
import java.util.*;

public class p1620_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalNum = Integer.parseInt(st.nextToken());
        int query = Integer.parseInt(st.nextToken());

        Map<String, Integer> pokemons = new HashMap<>();
        String[] pokemonName = new String[totalNum+1];

        for (int i = 1; i <= totalNum; i++) {
            String name = br.readLine();
            pokemons.put(name, i);
            pokemonName[i] = name;
        }

        for (int i = 0; i < query; i++) {
            String q = br.readLine();
            if (isNumeric(q)) {
                System.out.println(pokemonName[Integer.parseInt(q)]);
            } else {
                System.out.println(pokemons.get(q));
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
