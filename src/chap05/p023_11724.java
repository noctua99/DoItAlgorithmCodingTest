package chap05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p023_11724 {

    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    static void dfs(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int i : graph[v]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        /*for (int u : graph[v]) {
            if (!visit[u]) {
                visit[u] = true;
                dfs(u);
            }
        }*/
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        visited = new boolean[V + 1];
        graph = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        int count = 0;

        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
    }
}
