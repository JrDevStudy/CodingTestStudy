package 서병범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16960 {

    /*
    상도는 N개의 스위치와 M개의 램프를 갖고 있다. 스위치는 램프의 전원을 켤 수 있다. 스위치와 연결된 램프의 개수는 0개 이상이다.

    가장 처음에 램프는 모두 꺼져 있다.

    스위치를 누르면 램프의 전원이 켜진다. 스위치를 이용해서 램프의 전원을 끌 수는 없다. 예를 들어, 한 램프에 두 스위치가 연결되어 있는 경우에 한 스위치를 누르거나, 두 스위치를 모두 누르면 램프는 켜져 있는 상태가 된다.

    N개의 스위치를 모두 누르면 모든 램프가 켜진다. 상도는 N-1개의 스위치를 눌러도 모든 램프가 켜지는지 궁금해졌다.

    스위치와 램프의 연결 상태가 입력으로 주어진다. N-1개의 스위치를 눌러서 모든 램프를 켤 수 있는지 알아보자.

    @Input
         * 첫째 줄에 스위치의 수 N, 램프의 수 M이 주어진다. 둘째 줄부터 N개의 줄에는 스위치에 대한 정보가 주어진다. 스위치 정보의 첫 번째 정수는 그 스위치와 연결된 램프의 수이고, 이후 연결된 램프의 번호가 공백으로 구분되어져 있다.
         스위치와 램프의 번호는 1번부터 시작한다.
         N개의 스위치를 모두 누르면 모든 램프가 켜지는 입력만 주어진다.
         (단, 1 ≤ N, M ≤ 2,000)
         * Example :
                    4 5
                    3 1 3 5
                    1 2
                    3 3 4 5
                    1 1
    @OutPut
         * N-1개의 스위치를 눌러서 모든 램프를 켤 수 있으면 1을, 없으면 0을 출력한다.
         * Example : 1

    @link https://www.acmicpc.net/problem/16960
    */


    public static void main(String[] args) throws IOException {
//        solution1();
        solution2();
    }

    /*
    solution1 : 배열로 정보 관리
    메모리 : 17232 KB
    시간 : 176 ms
     */
    private static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄에 스위치의 수 N과 램프의 수 M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 각 램프가 켜지는 횟수를 기록할 배열
        int[] lampCount = new int[M + 1];

        // 스위치 배열
        int[][] switches = new int[N + 1][];

        // 스위치 정보 입력 받기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            switches[i] = new int[k];
            for (int j = 0; j < k; j++) {
                int lamp = Integer.parseInt(st.nextToken());
                switches[i][j] = lamp;
                lampCount[lamp]++;
            }
        }

        boolean allCanBeOn = true;
        // N-1개의 스위치로 모든 램프를 켤 수 있는지 확인
        for (int i = 1; i <= N; i++) {
            boolean canBeOn = true;
            for (int j = 1; j <= M; j++) {
                if (lampCount[j] == 1 && isConnectedToLamp(switches[i], j)) {
                    canBeOn = false;
                    break;
                }
            }
            if (canBeOn) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }

    // 특정 스위치가 특정 램프에 연결되어 있는지 확인하는 함수
    private static boolean isConnectedToLamp(int[] switchLamps, int lamp) {
        for (int lampNum : switchLamps) {
            if (lampNum == lamp) {
                return true;
            }
        }
        return false;
    }



    /*
    solution2 : List로 스위치 정보 관리
    메모리 : 17956 KB
    시간 : 164 ms
     */
    private static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력을 읽어와서 스위치의 수 N과 램프의 수 M을 설정
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 스위치 정보를 저장할 리스트 생성
        List<List<Integer>> switches = new ArrayList<>();
        switches.add(new ArrayList<>()); // 인덱스 0은 사용하지 않음

        // 각 램프가 몇 개의 스위치에 연결되어 있는지를 저장할 배열
        int[] lamps = new int[M + 1];

        // 스위치 정보를 입력받아 처리
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()); // 현재 스위치가 연결된 램프의 수
            switches.add(new ArrayList<>());
            for (int j = 0; j < num; j++) {
                int temp = Integer.parseInt(st.nextToken());
                switches.get(i).add(temp); // 스위치가 켤 수 있는 램프 번호 추가
                lamps[temp]++; // 해당 램프가 몇 개의 스위치에 연결되어 있는지 카운트
            }
        }

        // N개의 스위치 중 하나씩 제외하면서 모든 램프를 켤 수 있는지 확인
        for (int i = 1; i <= N; i++) {
            // 현재 스위치가 켜는 모든 램프에 대해 카운트 감소
            for (int lamp : switches.get(i)) {
                lamps[lamp]--;
            }

            // 모든 램프가 켜져 있는지 확인
            boolean isAll = true;
            for (int j = 1; j <= M; j++) {
                if (lamps[j] < 1) { // 한 개의 램프라도 켜져 있지 않다면
                    isAll = false;
                    break;
                }
            }

            // 모든 램프가 켜져 있다면 1을 출력하고 종료
            if (isAll) {
                System.out.println(1);
                return;
            }

            // 현재 스위치가 켜는 모든 램프에 대해 카운트 원복
            for (int lamp : switches.get(i)) {
                lamps[lamp]++;
            }
        }

        // 모든 경우를 확인한 후에도 모든 램프를 켤 수 없다면 0을 출력
        System.out.println(0);
    }




}
