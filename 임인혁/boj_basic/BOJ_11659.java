package 임인혁.boj_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_11659 {

    /*
        @합 배열 , 구간 합
        수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.

        @Input
            * 첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다.
              둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다.
              셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
            * Example : 5 3 \n 5 4 3 2 1 \n 1 3 \n 2 4 \n 5 5
        @OutPut
            * 총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
            * Example : 12 \n 9 \n 1
        @문제 제약
            * 1 ≤ N ≤ 100,000
            * 1 ≤ M ≤ 100,000
            * 1 ≤ i ≤ j ≤ N
        @시간 제한
            * 0.5s
    */
    public static void main(String[] args) throws IOException {
        soulution_good_1();
    }

    // 시간 초과 Fail
    // 질의 횟수가 100,000의 경우 질의 1번에 100,000의 계산 진행
    private static void soulution_bad() {
        Scanner sc = new Scanner(System.in);
        // 1. 수의 개 수
        int numCount = sc.nextInt();

        // 2. 합을 구해야하는 횟 수
        int outCount = sc.nextInt();

        // 3. 숫자 할당
        int[] numArr = new int[numCount];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = sc.nextInt();
        }

        while (outCount != 0) {
            int startRange = sc.nextInt() - 1;
            int endRange = sc.nextInt() - 1;
            int result = 0;

            while (startRange <= endRange) {
                result += numArr[endRange];
                endRange--;
            }
            System.out.println(result);
            outCount--;
        }
    }

    /*
        @Desc : 구간 합을 사용한 문제 풀이
            * 합 배열 공식 : S[i] = S[i-1] + A[i]
            * 구간 합 공식 : S[j] - S[i-1]
            * Memory Usage : 257996 KB
            * Time Usage : 2484 ms
    */
    private static void soulution_good_1() {
        Scanner sc = new Scanner(System.in);
        // 1. 수의 개 수
        int numCount = sc.nextInt();
        // 2. 합을 구해야하는 횟 수
        int outCount = sc.nextInt();

        // 3. 합배열 생성
        int[] S = new int[numCount + 1];
        for (int i = 0; i < S.length; i++) {
            if (i != 0) {
                // S[i] = S[i-1] + A[i]
                S[i] = S[i - 1] + sc.nextInt();
            }
        }

        System.out.println(Arrays.toString(S));

        while (outCount != 0) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            // S[j] - S[i-1]
            int result = S[j] - S[i - 1];
            System.out.println(result);
            outCount--;
        }
    }

    /*
        @Desc : 구간 합을 사용한 문제 풀이
            * 합 배열 공식 : S[i] = S[i-1] + A[i]
            * 구간 합 공식 : S[j] - S[i-1]
            * Memory Usage : 60108 KB
            * Time Usage : 1520 ms
    */
    private static void soulution_good_2() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        // 1. 수의 개 수
        int numCount = Integer.parseInt(stringTokenizer.nextToken());
        // 2. 합을 구해야하는 횟 수
        int outCount = Integer.parseInt(stringTokenizer.nextToken());

        // 3. 합배열 생성
        long[] S = new long[numCount + 1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= numCount; i++) {
            // S[i] = S[i-1] + A[i]
            S[i] = S[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        // 4. 구간 합 출력
        while (outCount != 0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            // S[j] - S[i-1]
            System.out.println(S[j] - S[i - 1]);
            outCount--;
        }

    }
}
