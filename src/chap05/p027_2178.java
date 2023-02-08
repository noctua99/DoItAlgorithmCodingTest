package chap05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class p027_2178 {

    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int findShortestRoute() {
        int count = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});

        while (true) {
            int size = queue.size();
            while (size-- > 0) {
                int[] temp = queue.poll();
                visit[temp[1]][temp[0]] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = temp[0] + dx[i];
                    int ny = temp[1] + dy[i];
                    if (ny == (N - 1) && nx == (M - 1)) return count + 1;
                    if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                        if (map[ny][nx] == 1 && !visit[ny][nx]) {
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
            count++;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        int ans = findShortestRoute();

        System.out.println(ans);
    }
}
