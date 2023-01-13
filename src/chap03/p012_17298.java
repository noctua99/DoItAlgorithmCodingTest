package chap03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class p012_17298 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        int[] res = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            left.push(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();

        int idx = N - 1;
        while (!left.isEmpty()) {
            if (right.isEmpty()) {
                right.push(left.pop());
                res[idx--] = -1;
            } else {
                if (left.peek() < right.peek()) {
                    res[idx--] = right.peek();
                    right.push(left.pop());
                } else {
                    right.pop();
                }
            }
        }

        Arrays.stream(res).forEach(num->sb.append(num).append(' '));

        System.out.println(sb);
    }
}
