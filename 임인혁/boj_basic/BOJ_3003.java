package 임인혁.boj_basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_3003 {

    /*
        킹, 퀸, 룩, 비숍, 나이트, 폰
        동혁이는 오래된 창고를 뒤지다가 낡은 체스판과 피스를 발견했다.
        체스판의 먼지를 털어내고 걸레로 닦으니 그럭저럭 쓸만한 체스판이 되었다. 하지만, 검정색 피스는 모두 있었으나, 흰색 피스는 개수가 올바르지 않았다.
        체스는 총 16개의 피스를 사용하며, 킹 1개, 퀸 1개, 룩 2개, 비숍 2개, 나이트 2개, 폰 8개로 구성되어 있다.
        동혁이가 발견한 흰색 피스의 개수가 주어졌을 때, 몇 개를 더하거나 빼야 올바른 세트가 되는지 구하는 프로그램을 작성하시오.

        @Input
            * 첫째 줄에 동혁이가 찾은 흰색 킹, 퀸, 룩, 비숍, 나이트, 폰의 개수 (n)가 주어진다. 이 값은 0보다 크거나 같고 10보다 작거나 같은 정수이다.
            * Example : 0 1 2 2 2 7
        @OutPut
            * 첫째 줄에 입력에서 주어진 순서대로 몇 개의 피스를 더하거나 빼야 되는지를 출력한다.
              만약 수가 양수라면 동혁이는 그 개수 만큼 피스를 더해야 하는 것이고, 음수라면 제거해야 하는 것이다.
            * Example : 1 0 0 0 0 1
        @시간 제한
            * 1s
        @메모리 제한
            * 128 MB
    */
    public static void main(String[] args) {
        try {
            solution_1();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
        @Desc :
            * Memory Usage : 15980 KB
            * Time Usage : 124 ms
        @수도 코드
        1. sudo code
            1-1. 원래 존재해야 하는 수 배열 x를 선언해둔다. { 1 , 1 , 2 , 2 , 2 , 8 }
            1-2. 흰색 킹, 퀸, 룩, 비숍, 나이트, 폰의 개수 (y) 를 입력받는다.
            1-3. 원래 존재해야 하는 수 배열에서 입력받은 y을 하나씩 뺀다.
    */
    private static void solution_1() throws IOException {
        // stream 변수 정의
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        // 1-1. 원래 존재해야 하는 수 배열을 선언해둔다. { 1 , 1 , 2 , 2 , 2 , 8 }
        int[] x = new int[]{1, 1, 2, 2, 2, 8};

        // 1-2. 흰색 킹, 퀸, 룩, 비숍, 나이트, 폰의 개수 (n) 를 입력받는다.
        String y = br.readLine();
        String[] arr = y.split(" ");

        // 1-3. 원래 존재해야 하는 수 배열에서 입력받은 n을 하나씩 뺀다.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < x.length; i++) {
            int z = Integer.parseInt(arr[i]);
            int result = x[i] - z;
            sb.append(result + " ");
        }
        String result = sb.toString();
        System.out.print(result);
    }

    /*
        @Desc :
            * Memory Usage : 14284 KB
            * Time Usage : 128 ms
        @수도 코드
        1. sudo code
            1-1. 원래 존재해야 하는 수 배열 x를 선언해둔다. { 1 , 1 , 2 , 2 , 2 , 8 }
            1-2. 흰색 킹, 퀸, 룩, 비숍, 나이트, 폰의 개수 (y) 를 입력받는다.
            1-3. 원래 존재해야 하는 수 배열에서 입력받은 y을 하나씩 뺀다.
    */
    private static void solution_2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] correctCount = {1, 1, 2, 2, 2, 8};

        String[] input = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < correctCount.length; i++) {
            int foundCount = Integer.parseInt(input[i]);
            sb.append(correctCount[i] - foundCount).append(" ");
        }

        // 결과 출력
        System.out.println(sb.toString().trim());
    }
}
