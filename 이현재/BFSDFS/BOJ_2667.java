package 이현재.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2667 {

    static int n;
    static int[][] map; // 지도
    static int[][] dxy = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우

    /**
     * 단지번호붙이기 - 112ms
     *
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/2667">문제 보기</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        List<Integer> complex = new ArrayList<>(); // 단지별 집의 개수
        // 지도 받기
        for (int i = 0; i < n; i++) {
            String[] p = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(p[j]);
            }
        }
        // 지도의 좌표를 하나씩 이동하며 방문하지 않은 집이 있는 경우, 상하좌우 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    complex.add(bfs(i, j));
                }
            }
        }

        sb.append(complex.size()).append("\n");
        complex.stream().sorted().forEach(i -> sb.append(i).append("\n"));
        System.out.println(sb);
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        map[x][y] = 0; // 방문 처리
        int cnt = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int currX = cur[0];
            int currY = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = currX + dxy[i][0]; // x의 상하좌우
                int ny = currY + dxy[i][1]; // y의 상하좌우
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue; // 지도 크기를 벗어나는 경우
                if (map[nx][ny] != 1) continue; // 집이 없거나 이미 방문한 좌표인 경우
                cnt++; // 집의 수 증분
                queue.add(new int[]{nx, ny}); // 큐에 현재 좌표 추가
                map[nx][ny] = 0; // 방문 처리
            }
        }
        return cnt;
    }
}
