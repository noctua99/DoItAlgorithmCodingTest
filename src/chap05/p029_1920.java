package chap05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class p029_1920 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            if (Arrays.binarySearch(arr, num) >= 0) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.println(sb);
    }
}
