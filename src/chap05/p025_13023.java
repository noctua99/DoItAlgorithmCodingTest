package chap05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p025_13023 {

    static int V, E;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean exist;

    static void dfs(int now, int depth) {
        if (depth == 5 || exist) {
            exist = true;
            return;
        }
        visited[now] = true;
        for (int v : graph[now]) {
            if (!visited[v]) {
                dfs(v, depth + 1);
            }
        }
        visited[now] = false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V];
        visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        for (int i = 0; i < V; i++) {
            dfs(i, 1);
            if (exist) {
                break;
            }
        }

        System.out.println(exist ? 1 : 0);
    }
}
