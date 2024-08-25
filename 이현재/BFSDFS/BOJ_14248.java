package 이현재.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14248 {

    /**
     * 점프 점프
     * <pre>
     *     <b>[문제]</b>
     *     영우는 개구리다 개굴개굴개굴
     *     영우는 지금 n개의 돌이 일렬로 놓여있는 돌다리에 있다.
     *     그리고 돌다리의 돌에는 숫자가 하나씩 적혀있다.
     *     영우는 이 숫자가 적혀있는 만큼 왼쪽이나 오른쪽으로 점프할 수 있는데, 이때 돌다리 밖으로 나갈 수는 없다.
     *     영우는 이 돌다리에서 자기가 방문 가능한 돌들의 개수를 알고 싶어한다.
     *     방문 가능하다는 것은 현재위치에서 다른 돌을 적절히 밟아 해당하는 위치로 이동이 가능하다는 뜻이다.
     *     현재 위치가 주어졌을 때, 영우가 방문 가능한 돌들의 개수를 출력하시오.
     *
     *     <b>[입력]</b>
     *     첫 번째 줄에는 돌다리의 돌 개수 n이 주어진다.(1≤n≤100,000)
     *     돌의 번호는 왼쪽부터 1번에서 n번이다.
     *     다음 줄에는 그 위치에서 점프할 수 있는 거리 Ai가 주어진다.(1≤Ai≤100,000)
     *     다음 줄에는 출발점 s가 주어진다.(1≤s≤n)
     *
     *     <b>[출력]</b>
     *     영우가 방문 가능한 돌들의 개수를 출력하시오.
     * </pre>
     *
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/14248">문제 보기</a>
     */
    public static void main(String[] args) throws IOException {
        first(); // dfs 풀이 - 240 ms
        second(); // bfs 풀이 - 248 ms
    }

    static int cnt = 0;

    public static void first() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stones = new int[n];
        String[] strings = br.readLine().split(" ");
        for (int i = 0; i < n; i++) stones[i] = Integer.parseInt(strings[i]);
        int s = Integer.parseInt(br.readLine());
        dfs(stones, s - 1);
        System.out.println(cnt);
    }

    private static void dfs(int[] stones, int idx) {
        if (stones[idx] == 0) return;
        int left = idx - stones[idx];
        int right = idx + stones[idx];
        stones[idx] = 0;
        cnt++;
        if (left >= 0) dfs(stones, left);
        if (right <= stones.length - 1) dfs(stones, right);
    }

    public static void second() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stones = new int[n];
        String[] strings = br.readLine().split(" ");
        for (int i = 0; i < n; i++) stones[i] = Integer.parseInt(strings[i]);
        int s = Integer.parseInt(br.readLine());
        int[] bias = {1, -1};
        boolean[] visited = new boolean[n];

        int cnt = 1;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(s - 1);
        visited[s - 1] = true;
        while (!deque.isEmpty()) {
            int q = deque.pop();
            for (int b : bias) {
                int abs = q + stones[q] * b;
                if (0 <= abs && abs < n && !visited[abs]) {
                    visited[abs] = true;
                    cnt++;
                    deque.push(abs);
                }
            }
        }
        System.out.println(cnt);
    }
}
