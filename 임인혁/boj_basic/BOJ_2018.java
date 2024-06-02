package 임인혁.boj_basic;

import java.util.Scanner;

public class BOJ_2018 {

    /*
        @Two Pointer
            어떠한 자연수 N은, 몇 개의 연속된 자연수의 합으로 나타낼 수 있다.
            당신은 어떤 자연수 N(1 ≤ N ≤ 10,000,000)에 대해서, 이 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 알고 싶어한다.
            이때, 사용하는 자연수는 N이하여야 한다.
            예를 들어, 15를 나타내는 방법은 15, 7+8, 4+5+6, 1+2+3+4+5의 4가지가 있다.
            반면에 10을 나타내는 방법은 10, 1+2+3+4의 2가지가 있다.
            N을 입력받아 가지수를 출력하는 프로그램을 작성하시오.

        @Input
            * 첫 줄에 정수 N이 주어진다.
            * Example : 15
        @OutPut
            * 입력된 자연수 N이 몇 개의 연속된 자연수의 합으로 나타내지는지 가지수를 출력하시오
            * Example : 4
        @문제 제약
            * 1 ≤ N ≤ 10,000,000
        @시간 제한
            * 2s
        @메모리 제한
            * 32 MB
    */
    public static void main(String[] args) {
        solution();
    }

     /*
        @Desc : Two Pointer를 사용한 문제 풀이
            * Memory Usage : 17724 KB
            * Time Usage : 252 ms
        수도 코드
        1. N 변수 저장
        2. 사용 변수 초기화
            2-1. count = 1 : N과 동일한 변수의 경우를 고려하여 미리 +1
            2-2. start_index = 1 ;
            2-3. end_index = 1 ;
            2-4. sum = 1;
        3. Two Pointer
           while(end_index != N) {
               if (sum == N) count 증가 , end_index 증가 , sum값 변경
               else if (sum > N) sum값 변경, start_index 증가
               else if (sum < N) end_index 증가 sum 값 변경
           }
    */
    private static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;

        while (end_index != N) {
            if (sum == N) {
                count++;
                end_index++;
                sum = sum + end_index;
            } else if (sum > N) {
                sum = sum - start_index;
                start_index++;
            } else if (sum < N) {
                end_index++;
                sum = sum + end_index;
            }
        }
        System.out.println(count);
    }
}
