package chap05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p028_1167 {

    static class Edge {
        final int num;
        final int weight;

        Edge(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    static ArrayList<Edge>[] edges;
    static int[] distance;
    static boolean[] visited;

    static void bfs(int v) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Edge edge : edges[now]) {
                int num = edge.num;
                int weight = edge.weight;
                if (!visited[num]) {
                    visited[num] = true;
                    queue.offer(num);
                    distance[num] = distance[now] + weight;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());

        edges = new ArrayList[V + 1];
        distance = new int[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());

            while (true) {
                int num = Integer.parseInt(st.nextToken());

                if (num == -1) break;

                int weight = Integer.parseInt(st.nextToken());

                edges[v].add(new Edge(num, weight));
            }
        }

        bfs(1);

        int maxVertex = 1;

        for (int i = 2; i <= V; i++) {
            if (distance[i] > distance[maxVertex]) {
                maxVertex = i;
            }
        }

        Arrays.fill(distance, 0);
        Arrays.fill(visited, false);

        bfs(maxVertex);

        int ans = Arrays.stream(distance).max().getAsInt();

        System.out.println(ans);
    }
}
