package chap03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p006_2018 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int count = 1;

        int start = 1;
        int end = 1;
        while (end <= N) {
            if (sum < N) {
                sum += end;
                end++;
            } else {
                if (sum == N) count++;
                sum -= start;
                start++;
            }
        }

        System.out.println(count);
    }
}
