package 서병범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class BOJ_1941 {

    /*
    총 25명의 여학생들로 이루어진 여학생반은 5×5의 정사각형 격자 형태로 자리가 배치되었고, 얼마 지나지 않아 이다솜과 임도연이라는 두 학생이 두각을 나타내며 다른 학생들을 휘어잡기 시작했다. 곧 모든 여학생이 ‘이다솜파’와 ‘임도연파’의 두 파로 갈라지게 되었으며, 얼마 지나지 않아 ‘임도연파’가 세력을 확장시키며 ‘이다솜파’를 위협하기 시작했다.

    위기의식을 느낀 ‘이다솜파’의 학생들은 과감히 현재의 체제를 포기하고, ‘소문난 칠공주’를 결성하는 것이 유일한 생존 수단임을 깨달았다. ‘소문난 칠공주’는 다음과 같은 규칙을 만족해야 한다.

    1. 이름이 이름인 만큼, 7명의 여학생들로 구성되어야 한다.
    2. 강한 결속력을 위해, 7명의 자리는 서로 가로나 세로로 반드시 인접해 있어야 한다.
    3. 화합과 번영을 위해, 반드시 ‘이다솜파’의 학생들로만 구성될 필요는 없다.
    4. 그러나 생존을 위해, ‘이다솜파’가 반드시 우위를 점해야 한다. 따라서 7명의 학생 중 ‘이다솜파’의 학생이 적어도 4명 이상은 반드시 포함되어 있어야 한다.
    여학생반의 자리 배치도가 주어졌을 때, ‘소문난 칠공주’를 결성할 수 있는 모든 경우의 수를 구하는 프로그램을 작성하시오.

    @Input
         * 'S'(이다‘솜’파의 학생을 나타냄) 또는 'Y'(임도‘연’파의 학생을 나타냄)을 값으로 갖는 5*5 행렬이 공백 없이 첫째 줄부터 다섯 줄에 걸쳐 주어진다.
         * Example :
                    YYYYY
                    SYSYS
                    YYYYY
                    YSYYS
                    YYYYY
    @OutPut
         * 첫째 줄에 ‘소문난 칠공주’를 결성할 수 있는 모든 경우의 수를 출력한다.
         * Example :
                    2

    @link https://www.acmicpc.net/problem/1941
    */

    public static void main(String[] args) throws IOException {
//        solution1();
        solution2();
    }

    /**
     * 메모리 : 96236 KB
     * 시간 : 372 ms
     * @throws IOException
     */
    public static void solution1() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        classroom = new char[5][5];
        for (int i = 0; i < 5; i++) {
            classroom[i] = br.readLine().toCharArray(); // 교실 자리 입력 받기
        }

        comb(0, 0, 0); // 조합 생성 시작
        System.out.println(ans); // 가능한 경우의 수 출력
    }

    static char[][] classroom; // 5x5 교실 배열
    static int ans; // 가능한 소문난 칠공주의 수
    static boolean[] visited; // 선택된 7개의 자리 배치 여부
    static int[] checked = new int[7]; // 선택된 7개의 자리를 저장
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우 이동을 위한 배열
    static int[] dc = {0, 0, -1, 1}; // 상하좌우 이동을 위한 배열


    // 7명의 자리를 선택하는 조합 생성
    static void comb(int cnt, int start, int dasomCnt) {
        // '이다솜파' 학생이 3명 이하인 경우 더 이상 진행할 필요 없음
        if (cnt - dasomCnt > 3) return;

        // 7명을 선택한 경우
        if (cnt == 7) {
            visited = new boolean[7];
            bfs(checked[0] / 5, checked[0] % 5); // BFS로 인접 확인
            return;
        }

        // 25개의 자리 중에서 7개의 자리를 선택하는 조합 생성
        for (int i = start; i < 25; i++) {
            int row = i / 5, col = i % 5;
            checked[cnt] = i;
            comb(cnt + 1, i + 1, (classroom[row][col] == 'S') ? dasomCnt + 1 : dasomCnt);
        }
    }

    // 선택된 7개의 자리가 인접한지 확인하는 BFS 메서드
    static void bfs(int i, int j) {
        int num = 1; // 인접한 자리 수
        visited[0] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] rowCol = queue.poll();
            int r = rowCol[0], c = rowCol[1];
            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dr[dir], nc = c + dc[dir];
                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
                int nxt = 5 * nr + nc;
                for (int k = 0; k < 7; k++) {
                    if (!visited[k] && checked[k] == nxt) {
                        visited[k] = true;
                        num++;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        // 7개의 자리가 모두 인접한 경우
        if (num == 7) ans++;
    }


    /**
     * 백준 상위 등수 풀이
     * 메모리 : 13132 KB
     * 시간 : 108 ms
     *
     * HashSet 자료구조를 사용
     * @throws IOException
     */
    private static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 교실 자리 입력 받기
        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 25개의 자리 중 하나를 시작점으로 선택
        for (int i = 0; i < 25; i++) {
            arr[0] = i;
            int tmpbit = (1 << i); // 배치 상태 비트마스크
            hs.add(tmpbit);
            is_visit[i / 5][i % 5] = true; // 배치 표시
            // 시작점이 'S'인 경우
            if (map[i / 5][i % 5] == 'S') {
                select_num(1, 1, 0, i, tmpbit);
            }
            // 시작점이 'Y'인 경우
            else {
                select_num(1, 0, 1, i, tmpbit);
            }
            is_visit[i / 5][i % 5] = false; // 배치 표시 해제
        }
        System.out.println(ans2); // 가능한 경우의 수 출력
    }

    // 이동 방향을 나타내는 배열 (상, 우, 하, 좌)
    static final int dx[] = {0, 1, 0, -1};
    static final int dy[] = {-1, 0, 1, 0};
    static char[][] map = new char[5][5]; // 5x5 교실 배열
    static HashSet<Integer> hs = new HashSet<>(); // 배치 상태를 저장하는 해시셋
    static boolean[][] is_visit = new boolean[5][5]; // 배치 여부를 저장하는 배열
    static int ans2 = 0; // 가능한 경우의 수
    static int[] arr = new int[7]; // 선택된 7개의 자리를 저장하는 배열


    // 주어진 좌표가 교실 내에 있는지 확인하는 함수
    static boolean is_map(int x, int y) {
        return x >= 0 && y >= 0 && x < 5 && y < 5;
    }

    // 7명의 자리를 선택하는 백트래킹 함수
    static void select_num(int now, int scnt, int ycnt, int where, int bit) {
        // '임도연파' 학생이 4명 이상인 경우 종료
        if (ycnt >= 4) return;
        // 7명을 선택한 경우
        if (now == 7) {
            ans2++;
            return;
        }
        // 현재까지 선택한 자리에서 인접한 자리 탐색
        for (int i = 0; i < now; i++) {
            int x = arr[i] % 5;
            int y = arr[i] / 5;
            for (int j = 0; j < 4; j++) {
                int xx = x + dx[j];
                int yy = y + dy[j];
                // 인접한 자리가 유효하고, 배치되지 않은 경우
                if (is_map(xx, yy) && !is_visit[yy][xx]) {
                    int tmpbit = bit | (1 << (xx + yy * 5)); // 새로운 배치 상태 비트마스크
                    if (!hs.contains(tmpbit)) {
                        arr[now] = xx + yy * 5;
                        hs.add(tmpbit);
                        is_visit[yy][xx] = true; // 배치 표시
                        // 선택한 자리가 'S'인 경우
                        if (map[yy][xx] == 'S') {
                            select_num(now + 1, scnt + 1, ycnt, yy * 5 + xx, tmpbit);
                        }
                        // 선택한 자리가 'Y'인 경우
                        else {
                            select_num(now + 1, scnt, ycnt + 1, yy * 5 + xx, tmpbit);
                        }
                        is_visit[yy][xx] = false; // 배치 표시 해제
                    }
                }
            }
        }
    }


    /* solution2가 solution1에 비해 메모리 및 실행 시간 면에서 더 효율적인 이유

    1. 탐색 공간의 축소:

    solution2는 비트마스킹과 백트래킹을 사용하여 필요한 경우만 탐색합니다. 각 상태를 비트마스크로 저장하여 중복 상태를 쉽게 확인하고 가지치기합니다.
    solution1은 모든 가능한 조합을 생성하고 BFS로 연결성을 확인합니다. 이는 많은 불필요한 탐색을 포함하여 탐색 공간이 훨씬 넓습니다.

    2. 효율적인 상태 관리:

    solution2는 HashSet을 사용하여 이미 배치한 상태를 저장하고 빠르게 조회할 수 있습니다. 이는 불필요한 중복 탐색을 방지하고 탐색 시간을 줄입니다.
    solution1은 매번 새로운 배열을 생성하여 배치 여부를 확인하는데, 이는 메모리 사용량을 증가시키고 시간이 더 소요됩니다.

    3. 메모리 사용의 최적화:

    solution2는 고정된 크기의 배열과 비트마스크를 사용하여 상태를 관리하므로 메모리 사용이 효율적입니다.
    solution1은 BFS를 사용하면서 큐에 많은 상태를 저장해야 하므로 더 많은 메모리를 소비합니다.

     */

}
