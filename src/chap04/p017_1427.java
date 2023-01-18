package chap04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p017_1427 {

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] chArr = br.readLine().toCharArray();

        for (int i = 0; i < chArr.length; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < chArr.length; j++) {
                if (chArr[j] > chArr[maxIdx]) {
                    maxIdx = j;
                }
            }
            swap(chArr, i, maxIdx);
        }

        System.out.println(chArr);
    }
}
