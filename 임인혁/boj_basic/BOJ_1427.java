package 임인혁.boj_basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1427 {

    /*
        배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
        @Input
            * 첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
            * Example : 2143
        @OutPut
            * 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
            * Example : 4321
        @시간 제한
            * 2s
        @메모리 제한
            * 128 MB
    */
    public static void main(String[] args) {
        try {
            solution_3();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
        @Desc : 버블 정렬을 활용한 문제 풀이
            * 시간 복잡도 : O(n2) [ 버블 정렬의 평균 및 최악 시간 복잡도 ]
            * Memory Usage : 14328 KB
            * Time Usage : 108 ms
        @수도 코드
        1. sudo code
            1-1. N (정렬 해야할 수) 를 입력받는다.
            1-2. N을 split하여 배열화 한다.
            1-3. 배열을 내림차 순으로 정렬한다.
    */
    private static void solution_1() throws IOException {
        // stream 변수 정의
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1-1. N (정렬 해야할 수) 를 입력받는다.
        String n = br.readLine();
        // 1-2. N을 split하여 배열화 한다.
        String[] list = n.split("");

        int[] intList = new int[list.length];
        for (int i = 0; i < intList.length; i++) {
            intList[i] = Integer.parseInt(list[i]);
        }
        // 1-3. 배열을 내림차 순으로 정렬한다.
        for (int i = 0; i < intList.length; i++) {
            for (int j = i + 1; j < intList.length; j++) {
                int x = intList[i];
                int y = intList[j];
                if (x < y) {
                    intList[i] = y;
                    intList[j] = x;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : intList) {
            sb.append(i);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    /*
        @Desc : Java Collections.reverseOrder() [ Dual-Pivot Quicksort ] 를 활용한 문제 풀이
            * 시간 복잡도 : O(n log n) [ Dual-Pivot Quicksort 평균 및 최악 시간 복잡도 ]
            * Memory Usage : 14376 KB
            * Time Usage : 132 ms
        @수도 코드
        1. sudo code
            1-1. N (정렬 해야할 수) 를 입력받는다.
            1-2. N을 split하여 배열화 한다.
            1-3. 배열을 내림차 순으로 정렬한다.
    */
    private static void solution_2() throws IOException {
        // stream 변수 정의
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N (정렬 해야할 수) 를 입력받는다.
        String n = br.readLine();

        // 2. N을 split하여 배열화 한다.
        String[] list = n.split("");

        // 3. 배열을 내림차 순으로 정렬한다.
        Arrays.sort(list, Collections.reverseOrder());

        // 4. 정렬된 배열을 문자열로 변환하여 출력한다.
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    /*
        @Desc : 선택 정렬을 활용한 문제 풀이
            * 시간 복잡도 : O(n2) [ 선택 정렬의 평균 시간 복잡도 ]
            * Memory Usage : 14260 KB
            * Time Usage : 128 ms
        @수도 코드
        1. sudo code
            1-1. N (정렬 해야할 수) 를 입력받는다.
            1-2. N을 split하여 배열화 한다.
            1-3. 배열을 내림차 순으로 정렬한다.
    */
    private static void solution_3() throws IOException {
        // stream 변수 정의
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N (정렬 해야할 수) 를 입력받는다.
        String n = br.readLine();

        // 2. N을 split하여 배열화 한다.
        char[] list = n.toCharArray();

        // 3. 선택 정렬을 사용하여 배열을 내림차순으로 정렬한다.
        // 배열의 첫 번째 요소부터 마지막 요소까지 반복한다.
        for (int i = 0; i < list.length - 1; i++) {
            // i 번째 요소부터 끝까지의 부분 배열에서 가장 큰 요소의 인덱스를 찾는다.
            int maxIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] > list[maxIndex]) {
                    maxIndex = j;
                }
            }
            // 가장 큰 요소를 i 번째 요소와 교환한다.
            char temp = list[i];
            list[i] = list[maxIndex];
            list[maxIndex] = temp;
        }

        // 4. 정렬된 배열을 문자열로 변환하여 출력한다.
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
