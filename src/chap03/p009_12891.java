package chap03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p009_12891 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int lenDNA = Integer.parseInt(st.nextToken());  // 민호가 임의로 만든 DNA 문자열 길이
        int lenP = Integer.parseInt(st.nextToken());    // 비밀번호로 사용할 부분문자열의 길이

        char[] DNA = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        int countA = Integer.parseInt(st.nextToken());
        int countC = Integer.parseInt(st.nextToken());
        int countG = Integer.parseInt(st.nextToken());
        int countT = Integer.parseInt(st.nextToken());

        int countPW = 0;
        for (int i = 0; i < lenP; i++) {
            switch (DNA[i]) {
                case 'A':
                    countA--;
                    break;
                case 'C':
                    countC--;
                    break;
                case 'G':
                    countG--;
                    break;
                case 'T':
                    countT--;
                    break;
            }
        }
        if (countA <= 0 && countC <= 0 && countG <= 0 && countT <= 0) {
            countPW++;
        }
        for (int i = 0; i < lenDNA - lenP; i++) {
            switch (DNA[i]) {
                case 'A':
                    countA++;
                    break;
                case 'C':
                    countC++;
                    break;
                case 'G':
                    countG++;
                    break;
                case 'T':
                    countT++;
                    break;
            }
            switch (DNA[i + lenP]) {
                case 'A':
                    countA--;
                    break;
                case 'C':
                    countC--;
                    break;
                case 'G':
                    countG--;
                    break;
                case 'T':
                    countT--;
                    break;
            }
            if (countA <= 0 && countC <= 0 && countG <= 0 && countT <= 0) {
                countPW++;
            }
        }

        System.out.println(countPW);
    }
}
