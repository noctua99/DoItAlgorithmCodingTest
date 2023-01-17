package chap03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class p016_1377 {

    static class Number {
        final int value;
        final int index;

        Number(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Number[] numbers = new Number[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = new Number(
                    Integer.parseInt(br.readLine()), i
            );
        }

        Arrays.sort(numbers, Comparator.comparingInt(o -> o.value));

        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            maxDiff = Math.max(numbers[i].index - i, maxDiff);
        }

        System.out.println(maxDiff + 1);
    }
}
