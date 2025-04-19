package Graph;

import java.util.*;
import java.io.*;

public class p1260 {
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

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

        for (int i = 1; i <= v; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[v+1];
        DFS(start);
        System.out.println();
        visited = new boolean[v+1];
        BFS(start);
    }

    private static void DFS(int start) {
        if (visited[start]) {
            return;
        }
        visited[start] = true;
        System.out.print(start + " ");
        for (Integer v : graph[start]) {
            if (!visited[v]) {
                DFS(v);
            }
        }
    }

    private static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (Integer v : graph[current]) {
                if (!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                }
            }
        }

    }
}
