package 서병범;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1062번: 가르침
 * <pre>
 *     <b>[문제]</b>
 *     남극에 사는 김지민 선생님은 학생들이 되도록이면 많은 단어를 읽을 수 있도록 하려고 한다.
 *     그러나 지구온난화로 인해 얼음이 녹아서 곧 학교가 무너지기 때문에, 김지민은 K개의 글자를 가르칠 시간 밖에 없다.
 *     김지민이 가르치고 난 후에는, 학생들은 그 K개의 글자로만 이루어진 단어만을 읽을 수 있다.
 *     김지민은 어떤 K개의 글자를 가르쳐야 학생들이 읽을 수 있는 단어의 개수가 최대가 되는지 고민에 빠졌다.
 *
 *     남극언어의 모든 단어는 "anta"로 시작되고, "tica"로 끝난다.
 *     남극언어에 단어는 N개 밖에 없다고 가정한다.
 *
 *     학생들이 읽을 수 있는 단어의 최댓값을 구하는 프로그램을 작성하시오.
 *
 *     <b>[입력]</b>
 *     첫째 줄에 단어의 개수 N과 K가 주어진다
 *     N은 50보다 작거나 같은 자연수이고, K는 26보다 작거나 같은 자연수 또는 0이다.
 *     둘째 줄부터 N개의 줄에 남극 언어의 단어가 주어진다.
 *     단어는 영어 소문자로만 이루어져 있고, 길이가 8보다 크거나 같고, 15보다 작거나 같다.
 *     모든 단어는 중복되지 않는다.
 *
 *     Example :
 *     3 6
 *     antarctica
 *     antahellotica
 *     antacartica
 *
 *     <b>[출력]</b>
 *     첫째 줄에 김지민이 K개의 글자를 가르칠 때, 학생들이 읽을 수 있는 단어 개수의 최댓값을 출력한다.
 *
 *     Example :
 *     2
 *
 * </pre>
 * @see <a href="https://www.acmicpc.net/problem/1062">문제 보기</a>
 */
public class BOJ_1062 {
    /*
    완전탐색 문제
     */


    /*
    DFS (깊이 우선 탐색) 문제 :
        - 개념: DFS는 그래프 탐색 알고리즘으로, 한 경로를 가능한 끝까지 탐색한 후에야 다른 경로로 돌아와 탐색을 진행합니다.
        - 사용 사례: 모든 가능한 상태, 경로, 또는 구성을 탐색해야 하는 문제에서 사용되며, 예를 들어 검색 문제, 미로 탐색, 퍼즐 문제 등에 적용됩니다.
     */
    public static void main(String[] args) throws IOException {
        solution1();
    }



    /**
     * Bitmasking 사용
     * 필수 문자 "a", "n", "t", "i", "c"를 제외한 나머지 문자들 중 K-5개의 문자를 선택하여 최대 단어 수를 계산.
     *
     * 시간 복잡도: O(N×M) ~ 최대 O(N×M×2^21)
     *      - N은 단어의 개수, 𝑀은 최대 단어 길이. 최대 21개의 문자에서 조합을 찾기 위해 모든 경우의 수를 탐색
     * 공간 복잡도: O(N+L)
     *      - N개의 단어를 저장, L은 재귀의 깊이
     *
     * 메모리 : 14140 KB
     * 시간 : 100 ms
     */
    static int N, K, maxWords;
    static int[] words;
    static int allLettersMask;
    public static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]); // 단어의 개수
        K = Integer.parseInt(firstLine[1]); // 가르칠 수 있는 글자의 개수

        // K가 5보다 작으면 필수 글자 (a, n, t, i, c)를 배우지 못하므로 단어를 읽을 수 없음
        if (K < 5) {
            System.out.println(0);
            return;
        }

        words = new int[N]; // 각 단어를 비트마스크로 표현하여 저장할 배열
        allLettersMask = 0; // 필수 글자 (a, n, t, i, c)를 비트마스크로 표현

        String essential = "antic"; // 필수 글자
        for (char c : essential.toCharArray()) {
            allLettersMask |= (1 << (c - 'a')); // 필수 글자를 비트마스크에 추가
        }

        // 각 단어를 읽어와서, 필수 글자 이후의 글자를 비트마스크로 변환
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            int bitMask = 0;
            for (int j = 4; j < word.length() - 4; j++) { // "anta"와 "tica"를 제외한 글자들만 비트마스크로 변환
                bitMask |= (1 << (word.charAt(j) - 'a'));
            }
            words[i] = bitMask; // 단어를 비트마스크로 저장
        }

        maxWords = 0; // 최대 읽을 수 있는 단어 개수 초기화
        dfs(0, 0, allLettersMask); // DFS 탐색 시작
        System.out.println(maxWords); // 결과 출력
    }


    /**
     * DFS를 이용하여 배울 수 있는 글자의 조합을 탐색하고, 최대 읽을 수 있는 단어의 개수를 계산하는 메서드.
     *
     * @param start 현재 탐색 중인 알파벳의 인덱스 (0부터 시작, a~z)
     * @param depth 현재까지 선택한 글자의 개수
     * @param learnedMask 현재까지 배운 글자들을 비트마스크로 표현한 값
     *
     * 이 메서드는 DFS를 통해 배울 수 있는 글자의 조합을 탐색합니다.
     * K-5개의 글자를 선택할 때까지 재귀적으로 탐색하며,
     * 각 조합에 대해 현재 선택한 글자로 읽을 수 있는 단어의 개수를 계산합니다.
     * learnedMask는 현재 배운 글자들을 비트마스크로 표현한 값으로,
     * 이 값을 이용해 특정 단어를 읽을 수 있는지 확인합니다.
     *
     * 글자가 K-5개 선택된 경우, 읽을 수 있는 단어 개수를 계산하고, 최대값을 갱신합니다.
     * 아직 K-5개를 선택하지 않은 경우, 다음 글자를 선택하여 재귀적으로 탐색을 계속합니다.
     */
    private static void dfs(int start, int depth, int learnedMask) {
        // 선택한 글자 개수가 K-5개에 도달하면 읽을 수 있는 단어 개수 계산
        if (depth == K - 5) {
            int count = 0;
            for (int wordMask : words) {
                // 현재 선택한 글자로 모든 단어를 읽을 수 있는지 확인
                if ((wordMask & learnedMask) == wordMask) {
                    count++;
                }
            }
            // 최대 읽을 수 있는 단어 개수 갱신
            maxWords = Math.max(maxWords, count);
            return;
        }

        // 아직 K-5개의 글자를 선택하지 않았으면, 추가로 글자를 선택
        for (int i = start; i < 26; i++) {
            if ((learnedMask & (1 << i)) == 0) { // 아직 선택되지 않은 글자라면
                dfs(i + 1, depth + 1, learnedMask | (1 << i)); // 글자 선택 후 재귀 호출
            }
        }
    }

    /*
    비트마스킹(Bitmasking) :

        - 개념: 비트마스킹은 비트를 사용해 요소나 상태의 집합을 표현하는 방법입니다. 정수의 각 비트는 특정 요소가 집합에 포함되어 있는지(1) 아닌지(0)를 나타낼 수 있습니다.
        - 사용 사례: 주로 부분집합이나 조합을 다루는 문제에서 사용되며, 각 비트는 특정 요소의 포함 여부를 나타냅니다.

        예시:
        세 개의 요소 𝐴,𝐵,𝐶가 있다고 가정해보면, 비트마스크를 사용해 다음과 같이 어떤 부분집합도 표현할 수 있습니다
            - 000 (모든 요소 미포함)
            - 001 (오직 𝐶만 포함)
            - 011 (오직 𝐵와 𝐶만 포함)
            - 111 (모든 요소 포함)
        특정 요소가 부분집합에 포함되어 있는지 확인하거나, 요소를 추가 또는 제거하고, 모든 부분집합을 순회하는 등의 연산을 비트 연산을 통해 효율적으로 수행할 수 있습니다.
     */

}
