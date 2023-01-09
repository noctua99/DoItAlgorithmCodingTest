package chap03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p005_10986 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] sumArr = new long[N];
        long[] count = new long[M];

        st = new StringTokenizer(br.readLine());
        sumArr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            sumArr[i] = sumArr[i - 1] + Integer.parseInt(st.nextToken());
        }

        long ans = 0;

        for (int i = 0; i < N; i++) {
            int remainder = (int) (sumArr[i] % M);
            if (remainder == 0) ans++;
            count[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            if (count[i] > 1) {
                ans += (count[i] * (count[i] - 1) / 2);
            }
        }

        System.out.println(ans);
    }
}
