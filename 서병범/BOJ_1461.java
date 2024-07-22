package 서병범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1461 {

    /*
    세준이는 도서관에서 일한다.
    도서관의 개방시간이 끝나서 세준이는 사람들이 마구 놓은 책을 다시 가져다 놓아야 한다.
    세준이는 현재 0에 있고, 사람들이 마구 놓은 책도 전부 0에 있다.
    각 책들의 원래 위치가 주어질 때, 책을 모두 제자리에 놔둘 때 드는 최소 걸음 수를 계산하는 프로그램을 작성하시오.

    세준이는 한 걸음에 좌표 1칸씩 가며, 책의 원래 위치는 정수 좌표이다.
    책을 모두 제자리에 놔둔 후에는 다시 0으로 돌아올 필요는 없다. 그리고 세준이는 한 번에 최대 M권의 책을 들 수 있다.

    @Input
         * 첫째 줄에 책의 개수 N과, 세준이가 한 번에 들 수 있는 책의 개수 M이 주어진다.
         둘째 줄에는 책의 위치가 주어진다.
         N과 M은 50보다 작거나 같은 자연수이다.
         책의 위치는 0이 아니며, 절댓값은 10,000보다 작거나 같은 정수이다.
         * Example :
                    7 2
                    -37 2 -6 -39 -29 11 -28
    @OutPut
         * 첫째 줄에 정답을 출력한다.
         * Example :
                    131

    @link https://www.acmicpc.net/problem/1461
    */

    public static void main(String[] args) throws IOException {
//        solution1();
//        solution2();
    }


    /**
     * 메모리 : 14220 KB
     * 시간 : 124 ms
     */
    public static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur < 0) neg.add(-cur);
            else pos.add(cur);
        }


        // 양수, 음수 각각 절대값이 큰 순서대로 정렬
        Collections.sort(pos, Collections.reverseOrder());
        Collections.sort(neg, Collections.reverseOrder());
        /*
        Collections.sort : 리스트를 정렬. 기본적으로 오름차순으로 정렬
        Collections.reverseOrder 를 사용하면 내림차순으로 정렬 가능.
        참고 : test.Collection_sort.class
         */


        int totalDistance = 0;

        // 가장 먼 책의 위치를 단방향 거리로 계산
        int farthestDistance = 0;
        if (!pos.isEmpty()) farthestDistance = pos.get(0);
        if (!neg.isEmpty()) farthestDistance = Math.max(farthestDistance, neg.get(0));

        // 가장 먼 위치는 단방향으로 이동
        totalDistance += farthestDistance;

        // 나머지 책들은 왕복 거리로 계산
        for (int i = 0; i < pos.size(); i += M) {
            if (i == 0 && pos.get(i) == farthestDistance) continue; // 가장 먼 위치는 단방향으로 이미 계산
            totalDistance += 2 * pos.get(i);
        }
        for (int i = 0; i < neg.size(); i += M) {
            if (i == 0 && neg.get(i) == farthestDistance) continue; // 가장 먼 위치는 단방향으로 이미 계산
            totalDistance += 2 * neg.get(i);
        }

        System.out.println(totalDistance);
    }







    /**
     * 백준 상위 등수 풀이
     * 메모리 : 11788 KB
     * 시간 : 68 ms
     *
     * Queue 자료구조를 사용
     * @throws IOException
     */
    static int N, M;
    static int answer = 0;

    private static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 선언| 양수: 내림차순, 음수: 오름차순
        Queue<Integer> positive = new PriorityQueue<>();
        Queue<Integer> negative = new PriorityQueue<>();


        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken()); // 책의 개수
        M = Integer.parseInt(stk.nextToken()); // 한 번에 들 수 있는 책의 개수

        // 입력| 책 위치
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(stk.nextToken());
            if (number > 0) {
                positive.add(number); // 양수 위치의 책을 큐에 추가
            } else {
                negative.add(Math.abs(number)); // 음수 위치의 책을 절댓값으로 큐에 추가
            }
            // 최대 거리 값을 업데이트 (단방향 거리 계산)
            answer = Math.max(answer, Math.abs(number));
        }

        // 최대 거리를 한번 방문하므로 중복 방지 위해 음수로 설정 (후에 양수로 전환하여 계산)
        answer = -answer;

        // 오른쪽 (양수 위치의 책) 최소 걸음 수 계산
        oneStepTwoStepPollJjacPollJjac(positive);

        // 왼쪽 (음수 위치의 책) 최소 걸음 수 계산
        oneStepTwoStepPollJjacPollJjac(negative);

        // 최종 결과 출력
        System.out.println(answer);

    }

    // 큐에서 최대 M권의 책을 꺼내어 거리를 계산하는 함수
    static void oneStepTwoStepPollJjacPollJjac(Queue<Integer> queue) {
        int mod = queue.size() % M; // 큐의 크기를 M으로 나눈 나머지
        int top = 0;

        // 나머지 개수 만큼 처리 (잔여 책들 처리)
        while (mod-- > 0) {
            top = Math.max(top, queue.poll()); // 최대 값 갱신
        }

        // 잔여 처리 후 거리 계산
        answer += 2 * top;

        // 큐가 비어있지 않으면 계속해서 최대 M권씩 처리
        while (!queue.isEmpty()) {
            int size = Math.min(M, queue.size()); // 남은 책이 M권 이하일 수 있음

            while (size-- > 0) {
                top = Math.max(top, queue.poll()); // 최대 값 갱신
            }

            // 매번 왕복 거리 계산
            answer += 2 * top;
        }
    }


}
