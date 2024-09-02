package 이현재.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {

    static int n;
    static int m;
    static char[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    /**
     * N과 M (1)
     *
     * <pre>
     *     <b>문제</b>
     *     자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
     *     1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
     *
     *     <b>입력</b>
     *     첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
     *
     *     <b>출력</b>
     *     한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
     *     중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
     *     수열은 사전 순으로 증가하는 순서로 출력해야 한다.
     * </pre>
     *
     * @param args args
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        // result 배열 하나가 중복 없이 m개를 고른 수열이며
        // 공백 문자와 줄바꿈 문자를 넣기 위해 * 2를 한다.
        result = new char[m * 2];
        // n 까지의 자연수가 곧 인덱스 값이 되어야 하기 때문에 +1 을 한다.
        visited = new boolean[n + 1];
        // 홀수 자리 수에 공백 문자를 추가
        for (int i = 0; i < m; i++) {
            result[i * 2 + 1] = ' ';
        }
        // 마지막은 줄바꿈 문자 추가
        result[m * 2 - 1] = '\n';

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        // 깊이가 골라야 하는 수열의 크기 m 과 동일한 경우 반환
        if (depth == m) {
            sb.append(result);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                // 짝수번째에 고른 숫자 추가
                result[depth * 2] = (char) (i + '0');
                // 다음 깊이로 가기 전 현재 숫자는 사용했다고 체크
                visited[i] = true;
                dfs(depth + 1);
                // 다음 숫자로 넘어가기 전 현재 숫자에 대한 사용 유무 복원
                visited[i] = false;
            }
        }
    }
}
