package chap05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p024_2023 {

    static int N;
    static int max;
    static StringBuilder sb = new StringBuilder();

    static boolean isPrime(int num) {
        for (int i = 2; i*i <=num ; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void dfs(int num, int depth) {
        if (depth == N) {
            if (isPrime(num)) {
                sb.append(num).append('\n');
            }
            return;
        }
        for (int i = 1; i <= 9; i += 2) {
            if (isPrime(num * 10 + i)) {
                dfs(num * 10 + i, depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        max = (int) Math.pow(10, N);

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

        System.out.println(sb);
    }
}
