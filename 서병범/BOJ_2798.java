package 서병범;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 2798번: 블랙잭
 * <pre>
 *     <b>[문제]</b>
 *     카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다. 카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임이다. 블랙잭은 카지노마다 다양한 규정이 있다.
 *
 *     한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.
 *
 *     김정인 버전의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다. 그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다. 그런 후에 딜러는 숫자 M을 크게 외친다.
 *
 *     이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다. 블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.
 *
 *     N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.
 *
 *     <b>[입력]</b>
 *     첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다.
 *     둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는 양의 정수이다.
 *     합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.
 *
 *     Example : 5 21
 *               5 6 7 8 9
 *
 *     <b>[출력]</b>
 *     첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.
 *
 *     Example : 21
 *
 * </pre>
 * @see <a href="https://www.acmicpc.net/problem/2798">문제 보기</a>
 */
public class BOJ_2798 {

    public static void main(String[] args) throws IOException {
//        solution1();
        solution2();
    }

    /**
     * 브루트포스(완전 탐색) 기법
     *
     * 1. 세 장의 카드를 선택하는 모든 경우의 수를 확인
     * 2. 각 경우의 합이 M을 넘지 않는지 확인
     * 3. M을 넘지 않는 경우 중에서 가장 큰 합 찾기
     *
     *
     * 메모리 : 14144 KB
     * 시간 : 100 ms
     * 시간복잡도 : O(N^3)
     * @throws IOException
     */
    public static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 입력 줄: 카드의 개수 N과 목표 숫자 M
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 두 번째 입력 줄: 각 카드에 적힌 숫자들
        int[] cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        // 최대 합을 저장할 변수
        int maxSum = 0;

        // 세 장의 카드를 고르는 모든 경우를 탐색
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    // 세 카드의 합 계산
                    int sum = cards[i] + cards[j] + cards[k];
                    // M을 넘지 않으면서 현재까지의 최대 합보다 크다면 갱신
                    if (sum <= M && sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
        }

        // 최종적으로 최대 합을 출력
        System.out.println(maxSum);
    }



    /**
     * 백준 상위 등수 풀이
     * : 재귀와 백트래킹을 이용
     * 조합과 가지치기를 통해 불필요한 연산을 줄여 시간 복잡도를 낮출 수 있다.
     * (연산 횟수가 브루트포스 방식보다 약 6배 정도 줄어듦)
     *
     * (1) 백트래킹 :
     * 재귀적으로 문제를 풀며, 해를 찾다가 유망하지 않은 경로가 발견되면 되돌아가 다른 경로를 탐색하는 방법
     * (불필요한 경로를 조기에 차단하여 탐색 범위를 줄이는 효과가 있다.)
     *
     * (2) 재귀적 방식 사용:
     * 재귀를 사용하면 문제를 더 작은 하위 문제로 분해해 코드가 간결하고 이해하기 쉬워진다.
     * 복잡한 반복문 대신 재귀 호출을 통해 문제의 구조를 자연스럽게 표현할 수 있다.
     *
     * 메모리 :  11596 KB
     * 시간 :  68 ms
     * 시간복잡도 : O(N^3)
     * N은 최대 100이므로, 최대 100C3 = 161,700번의 연산이 발생
     *
     * @throws IOException
     */
    static int N, M; // 카드의 개수 N과 목표 숫자 M
    static int[] arr; // 카드의 숫자를 저장할 배열
    static int maxSum;
    public static void solution2() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 카드 개수 N과 목표 숫자 M 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 카드 배열 초기화 및 입력
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // maxSum 초기화 (0으로 설정)
        maxSum = 0;

        // 블랙잭 조합 탐색 시작
        blackJack(0, 0, 0);  // 초기 값: 선택된 카드 0개, 시작 인덱스 0, 현재 합 0

        // 결과 출력
        System.out.println(maxSum);
    }


    /**
     * 블랙잭 문제 해결을 위한 재귀 함수
     * @param cnt 선택한 카드의 개수
     * @param start 다음 탐색을 시작할 인덱스
     * @param currentSum 현재까지 선택한 카드의 합
     */
    public static void blackJack(int cnt, int start, int currentSum) {
        // 3개의 카드를 선택한 경우
        if (cnt == 3) {
            // 현재 카드 조합의 합이 M보다 작거나 같으면 maxSum 갱신
            if (currentSum <= M) {
                maxSum = Math.max(maxSum, currentSum);  // 최대 합을 갱신
            }
            return;
        }

        // 카드를 선택하는 반복문 (start 인덱스부터 N까지)
        for (int i = start; i < N; i++) {
            // 현재 카드를 선택하고, 선택한 개수(cnt)를 1 증가시키며, 다음 탐색을 재귀적으로 호출
            blackJack(cnt + 1, i + 1, currentSum + arr[i]);
        }
    }


    /* 브루트포스 vs 재귀/백트래킹 방법

    브루트포스(Brute Force) 방법:

    브루트포스 방식은 모든 가능한 조합을 무조건 탐색하는 방법 : (3장의 카드를 선택하는 경우 모든 가능한 순열을 시도)
    이를 위해 중첩된 3중 for-loop를 사용하는 경우, 연산의 수는 다음과 같습니다:
        최대 연산 수 = 100 × 100 × 100 = 1,000,000번
    이 경우 모든 가능한 조합을 무조건 탐색하므로, 계산량이 매우 커질 수 있습니다.


    재귀와 백트래킹(Backtracking) 방법:

    재귀와 백트래킹은 모든 가능한 조합을 탐색하되, **가지치기(pruning)**를 통해 불필요한 경로를 제거하는 방식
    : (3장의 카드를 선택하는 경우 N에서 3개를 선택하는 '조합')

    3개의 카드를 선택하는 경우의 수는 조합 계산으로 다음과 같이 나타납니다:
        최대 연산 수 = (100×99×98) / (3×2×1) = 161,700번
    백트래킹을 사용하면, 조건을 만족하지 않거나 더 이상 탐색할 필요가 없는 경로를 조기에 차단하여 효율적으로 탐색할 수 있습니다.

    */



}
