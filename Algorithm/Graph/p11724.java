package Graph;

import java.io.*;
import java.util.*;

public class p11724 {
    private static boolean[] visited;
    private static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int count = 0;

        graph = new ArrayList[v+1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[v+1];
        for (int i = 1; i <= v; i++) {
            if (!visited[i]) {
                DFS(i);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void DFS(int vertex) {
        if (visited[vertex]) {
            return;
        }

        visited[vertex] = true;
        for (Integer v : graph[vertex]) {
            if (!visited[v]) {
                DFS(v);
            }
        }
    }
}
