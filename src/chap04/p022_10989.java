package chap04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class p022_10989 {

    static void radixSort(String[] arr, int maxRadix) {
        Queue<String>[] radixQueue = new Queue[10];
        for (int i = 0; i < 10; i++) {
            radixQueue[i] = new ArrayDeque<>();
        }

        while (maxRadix-- > 0) {
            for (String data : arr) {
                radixQueue[(data.charAt(maxRadix) - '0')].offer(data);
            }

            int index = 0;
            for (Queue<String> q : radixQueue) {
                while (!q.isEmpty()) {
                    arr[index++] = q.poll();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        int maxRadix = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
            maxRadix = Math.max(arr[i].length(), maxRadix);
        }

        radixSort(arr, maxRadix);

        StringBuilder sb = new StringBuilder();

        Arrays.stream(arr).forEach(data -> sb.append(data).append('\n'));

        System.out.println(sb);
    }
}
