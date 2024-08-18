package 서병범;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 2747번: 피보나치 수
 * <pre>
 *     <b>[문제]</b>
 *     피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다.
 *     그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
 *
 *     이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
 *
 *     n=17일때 까지 피보나치 수를 써보면 다음과 같다.
 *
 *     0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
 *
 *     n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
 *
 *     <b>[입력]</b>
 *     첫째 줄에 n이 주어진다. n은 45보다 작거나 같은 자연수이다.
 *     Example : 10
 *
 *     <b>[출력]</b>
 *     첫째 줄에 n번째 피보나치 수를 출력한다.
 *     Example : 55
 * </pre>
 * @see <a href="https://www.acmicpc.net/problem/2747">문제 보기</a>
 */
public class BOJ_2747 {

    public static void main(String[] args) throws IOException {
//        solution1();
        solution2();
    }

    /**
     * 메모리 : 14204 KB
     * 시간 : 100 ms
     * @throws IOException
     */
    public static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력을 받아 n값을 가져옴
        int n = Integer.parseInt(br.readLine());

        // n이 0인 경우는 예외처리
        if (n == 0) {
            System.out.println(0);
            return;
        }

        // 피보나치 수열을 계산하기 위한 배열 선언
        int[] fib = new int[n + 1];

        // 초기값 설정
        fib[0] = 0;
        fib[1] = 1;

        // DP로 피보나치 수열 계산
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        // n번째 피보나치 수 출력
        System.out.println(fib[n]);
    }



    /**
     * 백준 상위 등수 풀이
     * HashMap을 사용해 피보나치 수열의 계산된 값을 저장
     *
     * (1) 메모이제이션 :
     * 메모이제이션은 동일한 연산을 반복하지 않기 위해, 이미 계산된 값을 저장하고 재사용하는 기법
     * (기본적인 재귀 방식의 피보나치 수열 계산은 O(2^n)의 시간 복잡도를 가지지만, 메모이제이션을 사용하면 O(n)으로 최적화)
     *
     * (2) 재귀적 방식 사용:
     * 재귀적으로 fibonacci(n-1)과 fibonacci(n-2)를 호출하여 값을 계산하고, 그 값을 memo에 저장
     *
     * 메모리 :  11652 KB
     * 시간 :  68 ms
     *
     * @throws IOException
     */
    // 메모이제이션을 위한 맵, 피보나치 수열의 계산된 값을 저장
    private static Map<Long, Long> memo = new HashMap<>();
    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 값 읽기
        int N = Integer.parseInt(br.readLine());

        // 피보나치 수 계산 후 출력
//        System.out.println(fibonacci(N)); //아래 주석 참고
        bw.write(fibonacci(N) + "\n");

        // 자원 해제
        bw.flush();
        bw.close();
        br.close();
    }

    /*
    변경한 것 :
    System.out.println(fibonacci(N)); :
    간단한 출력 작업에 적합하며, 즉시 출력이 이루어집니다. 대량의 데이터를 다룰 때는 비효율적일 수 있습니다.

    ->

    bw.write(fibonacci(N) + "\n"); :
    대량의 출력이 필요한 경우, 성능을 최적화할 수 있는 방법입니다.
    BufferedWriter는 메모리에 데이터를 일시적으로 보관하는 버퍼를 사용하여 출력을 모아서 처리하기 때문에, 반복 작업에서 성능이 향상됩니다.
     */

    /**
     * 피보나치 수를 계산하는 메서드
     * @param n 계산할 피보나치 수열의 인덱스
     * @return n번째 피보나치 수
     */
    public static long fibonacci(long n) {
        // 기본 조건: n이 0 또는 1이면 그 값을 반환
        if (n <= 1) {
            return n;
        }
        // 이미 계산된 값이 존재하면 그 값을 반환
        else if (memo.containsKey(n)) {
            return memo.get(n);
        }
        // 계산되지 않은 경우, 재귀적으로 계산 후 메모이제이션
        else {
            long result = fibonacci(n - 1) + fibonacci(n - 2);
            memo.put(n, result);  // 계산된 값을 저장
            return result;
        }
    }



}
