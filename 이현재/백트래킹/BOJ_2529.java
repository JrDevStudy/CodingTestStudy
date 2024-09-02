package 이현재.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2529 {

    static int k; // 부등호 개수
    static boolean[] visited = new boolean[10]; // 숫자 방문 유무
    static char[] arr; // 부등호를 담아두는 배열
    static List<String> list =  new ArrayList<>(); // 가능한 모든 숫자 조합

    /**
     * 부등호 - 192 ms
     *
     * <pre>
     *     <b>문제</b>
     *     두 종류의 부등호 기호 ‘<’와 ‘>’가 k개 나열된 순서열 A가 있다.
     *     우리는 이 부등호 기호 앞뒤에 서로 다른 한 자릿수 숫자를 넣어서 모든 부등호 관계를 만족시키려고 한다.
     *     예를 들어, 제시된 부등호 순서열 A가 다음과 같다고 하자.
     *
     *     A ⇒ < < < > < < > < >
     *
     *     부등호 기호 앞뒤에 넣을 수 있는 숫자는 0부터 9까지의 정수이며 선택된 숫자는 모두 달라야 한다.
     *     아래는 부등호 순서열 A를 만족시키는 한 예이다.
     *
     *     3 < 4 < 5 < 6 > 1 < 2 < 8 > 7 < 9 > 0
     *
     *     이 상황에서 부등호 기호를 제거한 뒤, 숫자를 모두 붙이면 하나의 수를 만들 수 있는데 이 수를 주어진 부등호 관계를 만족시키는 정수라고 한다.
     *     그런데 주어진 부등호 관계를 만족하는 정수는 하나 이상 존재한다.
     *     예를 들어 3456128790 뿐만 아니라 5689023174도 아래와 같이 부등호 관계 A를 만족시킨다.
     *
     *     5 < 6 < 8 < 9 > 0 < 2 < 3 > 1 < 7 > 4
     *
     *     여러분은 제시된 k개의 부등호 순서를 만족하는 (k+1)자리의 정수 중에서 최댓값과 최솟값을 찾아야 한다.
     *     앞서 설명한 대로 각 부등호의 앞뒤에 들어가는 숫자는 { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }중에서 선택해야 하며 선택된 숫자는 모두 달라야 한다.
     *
     *     <b>입력</b>
     *     첫 줄에 부등호 문자의 개수를 나타내는 정수 k가 주어진다.
     *     그 다음 줄에는 k개의 부등호 기호가 하나의 공백을 두고 한 줄에 모두 제시된다.
     *     k의 범위는 2 ≤ k ≤ 9 이다.
     *
     *     <b>출력</b>
     *     여러분은 제시된 부등호 관계를 만족하는 k+1 자리의 최대, 최소 정수를 첫째 줄과 둘째 줄에 각각 출력해야 한다.
     *     단 아래 예(1)과 같이 첫 자리가 0인 경우도 정수에 포함되어야 한다.
     *     모든 입력에 답은 항상 존재하며 출력 정수는 하나의 문자열이 되도록 해야 한다.
     * </pre>
     *
     * @param args args
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new char[k];

        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        dfs(0, "");
        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }

    /**
     * dfs
     * @param i 0부터 시작, dfs 깊이와 부등호 배열의 인덱스로 활용
     * @param result 부등호 조건에 맞는 숫자 조합
     */
    private static void dfs(int i, String result) {
        // 부등호에 맞는 숫자 조합이 완성된 경우
        if (i == k + 1) {
            // 리스트에 추가
            list.add(result);
            return;
        }
        // 0 ~ 9 까지 순회하면서 숫자 조합에 추가
        for (int j = 0; j < 10; j++) {
            if (visited[j]) continue; // 이미 방문한 숫자면 스킵
            // 깊이가 0(처음 실행)이거나 부등호에 맞는 숫자인 경우
            if (i == 0 || checkedNumber(i, j, result)) {
                visited[j] = true;
                dfs(i + 1, result + j);
                visited[j] = false;
            }
        }
    }

    private static boolean checkedNumber(int i, int j, String result) {
        int current = result.charAt(i - 1) - '0';
        if (arr[i - 1] == '>') {
            return current > j;
        } else {
            return current < j;
        }
    }
}
