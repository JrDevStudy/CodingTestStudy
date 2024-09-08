package 서병범;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 14888번: 연산자 끼워넣기
 * <pre>
 *     <b>[문제]</b>
 *     N개의 수로 이루어진 수열 A1, A2, ..., AN이 주어진다. 또, 수와 수 사이에 끼워넣을 수 있는 N-1개의 연산자가 주어진다. 연산자는 덧셈(+), 뺄셈(-), 곱셈(×), 나눗셈(÷)으로만 이루어져 있다.
 *
 *     우리는 수와 수 사이에 연산자를 하나씩 넣어서, 수식을 하나 만들 수 있다. 이때, 주어진 수의 순서를 바꾸면 안 된다.
 *
 *     예를 들어, 6개의 수로 이루어진 수열이 1, 2, 3, 4, 5, 6이고, 주어진 연산자가 덧셈(+) 2개, 뺄셈(-) 1개, 곱셈(×) 1개, 나눗셈(÷) 1개인 경우에는 총 60가지의 식을 만들 수 있다.
 *
 *     예를 들어, 아래와 같은 식을 만들 수 있다.
 *     1+2+3-4×5÷6
 *     1÷2+3+4-5×6
 *     1+2÷3×4-5+6
 *     1÷2×3-4+5+6
 *
 *     식의 계산은 연산자 우선 순위를 무시하고 앞에서부터 진행해야 한다.
 *     또, 나눗셈은 정수 나눗셈으로 몫만 취한다.
 *     음수를 양수로 나눌 때는 C++14의 기준을 따른다. 즉, 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것과 같다.
 *
 *     이에 따라서, 위의 식 4개의 결과를 계산해보면 아래와 같다.
 *     1+2+3-4×5÷6 = 1
 *     1÷2+3+4-5×6 = 12
 *     1+2÷3×4-5+6 = 5
 *     1÷2×3-4+5+6 = 7
 *
 *     N개의 수와 N-1개의 연산자가 주어졌을 때, 만들 수 있는 식의 결과가 최대인 것과 최소인 것을 구하는 프로그램을 작성하시오.
 *
 *     <b>[입력]</b>
 *     첫째 줄에 수의 개수 N(2 ≤ N ≤ 11)가 주어진다.
 *     둘째 줄에는 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 100)
 *     셋째 줄에는 합이 N-1인 4개의 정수가 주어지는데, 차례대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수이다.
 *
 *     Example :
 *     2
 *     5 6
 *     0 0 1 0
 *
 *     <b>[출력]</b>
 *     첫째 줄에 만들 수 있는 식의 결과의 최댓값을, 둘째 줄에는 최솟값을 출력한다. 연산자를 어떻게 끼워넣어도 항상 -10억보다 크거나 같고, 10억보다 작거나 같은 결과가 나오는 입력만 주어진다.
 *     또한, 앞에서부터 계산했을 때, 중간에 계산되는 식의 결과도 항상 -10억보다 크거나 같고, 10억보다 작거나 같다.
 *
 *     Example :
 *     30
 *     30
 *
 * </pre>
 * @see <a href="https://www.acmicpc.net/problem/14888">문제 보기</a>
 */
public class BOJ_14888 {
    /*
    재귀탐색 문제
     */


    public static void main(String[] args) throws IOException {
        solution1();
    }



    /**
     * 모든 연산자 조합을 탐색하여 최대값과 최소값을 구하기
     *
     * DFS 탐색 및 백트래킹
     *  - DFS 탐색: 연산자를 끼워넣을 수 있는 모든 가능한 경우의 수를 탐색하기 위해 DFS(깊이 우선 탐색)를 사용합니다.
     *  - 백트래킹: 연산자 배열을 조작할 때, 현재 선택한 연산자를 사용한 후 다시 복구하여 다른 경로도 탐색할 수 있도록 합니다. 이를 통해 모든 경우를 탐색할 수 있습니다.
     *
     * 시간 복잡도: 최악의 경우 모든 연산자 조합을 탐색해야하므로, O(4^(N-1))
     *      - 각 연산자마다 선택지가 4개이고, N−1번의 연산을 수행
     *
     * 공간 복잡도: O(N)
     *      - 깊이가 N인 재귀 호출 스택을 사용
     *
     * 메모리 : 16884 KB
     * 시간 : 108 ms
     */
    static int N; // 숫자의 개수
    static int[] numbers; // 주어진 숫자 배열
    static int[] operators; // 연산자 배열 (+, -, *, / 순서)
    static int maxValue = Integer.MIN_VALUE; // 가능한 최댓값 초기화
    static int minValue = Integer.MAX_VALUE; // 가능한 최솟값 초기화
    public static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        operators = new int[4];

        // 숫자 입력 받기
        String[] numStr = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(numStr[i]);
        }

        // 연산자 개수 입력 받기
        String[] opStr = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(opStr[i]);
        }

        // DFS를 이용하여 연산자 끼워넣기 시작
        dfs(1, numbers[0]);

        System.out.println(maxValue);
        System.out.println(minValue);
    }


    /**
     * 주어진 숫자와 연산자를 이용하여 가능한 모든 수식을 생성해보고, 그 중 최대값과 최소값을 찾는 DFS 메서드.
     *
     * @param idx 현재 탐색 중인 숫자의 인덱스 (1부터 시작)
     * @param current 현재까지 계산된 값
     *
     * 이 메서드는 주어진 연산자들을 사용하여 모든 가능한 연산 순서를 탐색합니다.
     * 각 연산자를 하나씩 사용하면서 재귀적으로 다음 숫자와 연산을 수행하며,
     * 모든 숫자를 다 사용했을 때 최종 결과를 통해 최댓값과 최솟값을 갱신합니다.
     * 연산자가 중복되지 않도록 사용된 연산자는 즉시 개수를 감소시키며,
     * 재귀 호출이 끝나면 원래 상태로 복구(백트래킹)하여 다른 연산 순서를 탐색합니다.
     */
    public static void dfs(int idx, int current) {
        // 모든 숫자를 다 사용한 경우, 최댓값과 최솟값 갱신
        if (idx == N) {
            maxValue = Math.max(maxValue, current);
            minValue = Math.min(minValue, current);
            return;
        }

        // 각 연산자에 대해 가능한 연산을 시도
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) { // 남은 연산자가 있는 경우
                operators[i]--; // 해당 연산자를 사용

                switch (i) {
                    case 0:
                        dfs(idx + 1, current + numbers[idx]); // 덧셈 연산
                        break;
                    case 1:
                        dfs(idx + 1, current - numbers[idx]); // 뺄셈 연산
                        break;
                    case 2:
                        dfs(idx + 1, current * numbers[idx]); // 곱셈 연산
                        break;
                    case 3:
                        dfs(idx + 1, current / numbers[idx]); // 나눗셈 연산
                        break;
                }

                operators[i]++; // 백트래킹: 연산자 개수 복구
            }
        }
    }
}
