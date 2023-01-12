package chap03;

import java.io.*;
import java.util.*;

public class p010_11003 {

    static class Element {
        final int index;
        final int value;

        Element(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        Deque<Element> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            while (!deque.isEmpty() && deque.getLast().value > now) {
                deque.removeLast();
            }
            deque.addLast(new Element(i, now));
            if (deque.getFirst().index <= i - L) {
                deque.removeFirst();
            }
            sb.append(deque.getFirst().value).append(' ');
        }

        System.out.println(sb);
    }
}
