package chap03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p004_11660 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] sumArr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                sumArr[i][j] = sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            int partialSum = sumArr[y2][x2] - sumArr[y2][x1 - 1] - sumArr[y1 - 1][x2] + sumArr[y1 - 1][x1 - 1];
            sb.append(partialSum).append('\n');
        }

        System.out.println(sb);
    }
}
