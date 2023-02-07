package chap05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p026_1260 {

    static int V;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int v) {
        visit[v] = true;
        sb.append(v).append(' ');
        for (int i : graph[v]) {
            if (!visit[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int v) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(v);
        visit[v] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(' ');
            for (int i : graph[now]) {
                if (!visit[i]) {
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());       // 정점의 개수
        int E = Integer.parseInt(st.nextToken());   // 간선의 개수
        int v = Integer.parseInt(st.nextToken());   // 탐색을 시작할 정점의 번호

        graph = new ArrayList[V + 1];
        visit = new boolean[V + 1];

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

        for (int i = 1; i <= V; i++) {
            graph[i].sort(Integer::compareTo);
        }

        dfs(v);
        sb.append('\n');
        Arrays.fill(visit, false);
        bfs(v);

        System.out.println(sb);
    }
}
