package chap04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p021_1517 {

    static long swapCount = 0;
    static int[] sorted;

    static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    static void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int index = low;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                sorted[index++] = arr[i++];
            } else {
                sorted[index++] = arr[j++];
                swapCount += (mid + 1 - i);
            }
        }

        while (i <= mid) {
            sorted[index++] = arr[i++];
        }
        while (j <= high) {
            sorted[index++] = arr[j++];
        }
        for (int k = low; k <= high; k++) {
            arr[k] = sorted[k];
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        sorted = new int[N];
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, 0, N - 1);

        System.out.println(swapCount);
    }
}
