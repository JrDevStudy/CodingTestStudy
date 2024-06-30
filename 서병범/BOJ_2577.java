package 서병범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2577 {



    /*
    세 개의 자연수 A, B, C가 주어질 때 A × B × C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
    예를 들어 A = 150, B = 266, C = 427 이라면 A × B × C = 150 × 266 × 427 = 17037300 이 되고, 계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.

    @Input
         * 첫째 줄에 A, 둘째 줄에 B, 셋째 줄에 C가 주어진다. A, B, C는 모두 100보다 크거나 같고, 1,000보다 작은 자연수이다.
         * Example :    150
                        266
                        427
    @OutPut
         * 첫째 줄에는 A × B × C의 결과에 0 이 몇 번 쓰였는지 출력한다.
           마찬가지로 둘째 줄부터 열 번째 줄까지 A × B × C의 결과에 1부터 9까지의 숫자가 각각 몇 번 쓰였는지 차례로 한 줄에 하나씩 출력한다.
         * Example :    3
                        1
                        0
                        2
                        0
                        0
                        0
                        2
                        0
                        0

    @link https://www.acmicpc.net/problem/2577
    */


    public static void main(String[] args) throws IOException {

//        solution1();
        solution2();
    }


    /* 사용한 핵심 키워드
    charAt(int index) : 문자열에서 지정된 인덱스에 있는 문자를 반환
    예를 들어, 문자열 "12345"에서 charAt(0)은 '1', charAt(1)은 '2'를 반환합니다.
     */
    public static void solution1() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // result를 담을 배열 생성 0~9
        int[] arr = new int[10];

        //bufferedreader는 무조건 문자열로 받아오기때문에 정수형이나 실수형 변수에 저장하기 위해서는 입력과 형변환을 해줘야한다.
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int total = A * B * C;

        String str = String.valueOf(total);

        //각 자리 수의 개수 계산(해당 문자가 나타내는 숫자의 개수를 증가)
        for (int i = 0; i < str.length(); i++) {
            arr[(str.charAt(i) - 48)]++; //'0'의 ASCII 값은 48 (str.charAt(i) - '0' 과 같음)
        }

        //결과 출력
        for (int v : arr) {
            System.out.println(v);
        }
    }



    /* 2번째 방법
    * 나머지 연산 사용 (문자열 변환을 사용하지 않은 방식)
     */
    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // result를 담을 배열 생성 0~9
        int[] count = new int[10];

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int total = A * B * C;

        // 숫자를 나누어 각 자리수를 계산하는 방식
        while (total > 0) {
            count[total % 10]++;
            total /= 10;
        }

        for (int v : count) {
            System.out.println(v);
        }
    }

}
