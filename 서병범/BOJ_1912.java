package 서병범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1912번: 연속합
 * <pre>
 *     <b>[문제]</b>
 *     n개의 정수로 이루어진 임의의 수열이 주어진다.
 *     우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.
 *     단, 수는 한 개 이상 선택해야 한다.
 *
 *     예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자.
 *     여기서 정답은 12+21인 33이 정답이 된다.
 *
 *     <b>[입력]</b>
 *     첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다.
 *     수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.
 *
 *     Example :
 *     10
 *     10 -4 3 1 5 6 -35 12 21 -1
 *
 *     <b>[출력]</b>
 *     첫째 줄에 답을 출력한다.
 *     Example :
 *     33
 *
 * </pre>
 * @see <a href="https://www.acmicpc.net/problem/1912">문제 보기</a>
 */
public class BOJ_1912 {

    public static void main(String[] args) throws IOException {
//        solution1();
        solution2();
    }

    /**
     * 카데인 알고리즘
     * : 카데인 알고리즘은 배열을 한 번 순회하면서 최대 부분합을 효율적으로 계산
     * 각 단계에서 현재까지의 부분합을 갱신하며, 현재까지의 최대값을 유지하는 방식
     *
     * 시간 복잡도: O(n) - 배열을 한 번 순회하며 최대 부분합을 계산
     * 공간 복잡도: O(1) - 추가적인 배열이나 리스트를 사용하지 않고, 고정된 몇 개의 변수를 사용
     *
     * 메모리 : 24224 KB
     * 시간 : 240 ms
     * @throws IOException
     */
    public static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxSum = arr[0]; // 최대 연속합
        int currentSum = arr[0]; // 현재까지의 연속합

        for (int i = 1; i < n; i++) {
            // currentSum은 현재 원소부터 시작할지, 기존의 currentSum에 현재 원소를 더할지를 선택
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            // maxSum은 현재까지의 최대 연속합을 유지
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
    }



    /**
     * 백준 상위 등수 풀이
     *
     * 메모이제이션은 이전까지 탐색했던 값과 현재 위치의 값을 비교하여 큰 값을 저장
     * Bottom-Up
     *
     * DP(Dynamic Program) 배열 :
     * DP 배열을 통해 중복 계산을 피하면서 최대값을 갱신.
     *
     * 메모리 :  23612 KB
     * 시간 :  192 ms
     *
     * @throws IOException
     */
    public static void solution2() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        /*
         * dp[0]은 첫 원소로 이전에 더이상 탐색할 것이 없기 때문에
         * arr[0] 자체 값이 되므로 arr[0]으로 초기화 해준다.
         * max또한 첫 번째 원소로 초기화 해준다.
         */
        dp[0] = arr[0];
        int max = arr[0];

        for (int i = 1; i < N; i++) {
            // (이전 dp + 현재 arr값) 과 현재 arr값 중 큰 것을 dp에 저장
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            // 최댓값 갱신
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    /*
    용어는 Dynamic Program이지만 사실 핵심은 메모제이션에 있다.
    DP관련 문제 풀이들은 이전에 계산한 내용을 '기억'해두고 다음 계산에 지속적으로 이용한다.
    일반적으로 풀이방식에 따라 bottem-up, top-down을 구분하는데 큰 의미는 없다고 생각한다.
    트리처럼 recursion(반복)을 이용한 풀이는 보통 top-down으로, 배열에 대해 index 0부터 차근차근 풀어나가는 방식을 bottom-up으로 생각하는 경우가 많다

    dp의 가장 간단한 예시는 피보나치 수열이다
    피보나치 수열의 경우 모든 항목을 일일이 계산하지 않는다.
    f(1)을 한번 계산해두면, f(2)를 구할때 계산했던 f(1)을 메모제이션 했다가 사용한다.
    결국은 일종의 점화식이다.
     */


}
