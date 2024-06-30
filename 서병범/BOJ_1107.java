package 서병범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1107 {
    /*
    수빈이는 TV를 보고 있다. 수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼이 고장났다.

    리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다. +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다.
    채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.

    수빈이가 지금 이동하려고 하는 채널은 N이다.
    어떤 버튼이 고장났는지 주어졌을 때, 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오.

    수빈이가 지금 보고 있는 채널은 100번이다.

    @Input
         * 첫째 줄에 수빈이가 이동하려고 하는 채널 N (0 ≤ N ≤ 500,000)이 주어진다.
           둘째 줄에는 고장난 버튼의 개수 M (0 ≤ M ≤ 10)이 주어진다.
           고장난 버튼이 있는 경우에는 셋째 줄에는 고장난 버튼이 주어지며, 같은 버튼이 여러 번 주어지는 경우는 없다.
         * Example :
                    5457
                    3
                    6 7 8
    @OutPut
         * 첫째 줄에 채널 N으로 이동하기 위해 버튼을 최소 몇 번 눌러야 하는지를 출력한다.
         * Example : 6

    @link https://www.acmicpc.net/problem/1107
    */


    /*
    브루트 포스, 즉 완전 탐색 문제 (0~ 999,999까지 전부다 탐색하며 맞는 조건을 찾는다. : 모든 가능한 경우 대입)
     */
    public static void main(String[] args) throws IOException {

//        solution1();
//        solution2();
        solution3();
    }


    // solution1 : 최소 클릭 횟수를 저장하는 변수, 큰 값으로 초기화
    static int ans = 1000000;
    // solution1 : 사용 가능한 숫자 버튼을 표시하는 배열
    static boolean[] nums;


    /* 못풀겠어서 참고
    https://bleron.tistory.com/220
    메모리 : 14280 KB
    시간 : 144 ms
     */
    private static void solution1() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 목표 채널 N을 입력받음
        int N = Integer.parseInt(br.readLine());

        // 고장난 버튼의 개수 M을 입력받음
        int M = Integer.parseInt(br.readLine());

        // 모든 숫자 버튼을 사용 가능으로 초기화
        nums = new boolean[10];
        Arrays.fill(nums, true);

        // 고장난 버튼을 입력받아 nums 배열에서 사용 불가능으로 설정
        StringTokenizer st = null ;
        if (M > 0) st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            nums[Integer.parseInt(st.nextToken())] = false;
        }

        // 초기 최소 클릭 횟수는 100에서 목표 채널까지 +나 -로만 이동한 횟수
        ans = Math.abs(N - 100);

        // 사용 가능한 숫자 버튼으로 DFS 탐색 시작
        for (int i = 0; i <= 9; i++) {
            if (!nums[i]) continue; // 버튼이 고장난 경우 건너뜀
            dfs(i, N, 1); // DFS 호출, 현재 숫자 i, 목표 채널 N, 숫자 길이 1
        }

        // 최소 클릭 횟수를 출력
        System.out.println(ans);
    }



    // solution1 : DFS 메서드
    static void dfs(int cur, int N, int len) {
        // 숫자가 너무 길어지는 것을 방지
        if (len >= 7) return;

        // 현재까지 만든 숫자로 목표 채널까지 이동한 클릭 수와 최소 클릭 횟수를 갱신
        ans = Math.min(ans, Math.abs(N - cur) + len);

        // 다음 자리수 숫자를 추가하여 재귀 호출
        for (int i = 0; i <= 9; i++) {
            if (!nums[i]) continue; // 버튼이 고장난 경우 건너뜀
            dfs(10 * cur + i, N, len + 1); // 다음 자리수 숫자를 추가하여 DFS 호출
        }
    }





    /* 백준 1등 풀이
    메모리 : 11532 KB
    시간 : 72 ms
     */
    private static void solution2() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 수빈이가 이동하려는 채널 N
        int m = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수 M
        int ret = (n > 100)? n - 100 : 100 - n; // 초기값 설정: 현재 채널에서 100번 채널까지의 거리
        boolean[] isBrokenButton;
        StringTokenizer st;

        // 고장난 버튼을 입력받고 처리
        if(m == 0) {
            // 고장난 버튼이 없는 경우, 현재 채널에서 100번 채널까지의 거리와 현재 채널의 길이 중 작은 값을 출력
            System.out.print((String.valueOf(n).length() < ret)? String.valueOf(n).length() : ret);
            return;
        }

        st = new StringTokenizer(br.readLine());
        isBrokenButton = new boolean[10];

        // 고장난 버튼을 배열에 표시
        while(st.hasMoreTokens())
            isBrokenButton[Integer.parseInt(st.nextToken())] = true;

        // 특별한 경우 처리: 현재 채널이 이미 100번 채널인 경우
        if(n == 100) {
            System.out.print(0);
            return;
        } else if(m == 10) {
            // 고장난 버튼이 모든 숫자 버튼인 경우, 현재 채널에서 100번 채널까지의 거리만 출력
            System.out.print(ret);
            return;
        }

        // 이동할 채널 n과 고장난 버튼 배열을 인자로 해서 최소 버튼 누름 수를 계산하여 출력
        System.out.print(getPushCountOfButtonsToMoveChannel(n, isBrokenButton));
    }



    // solution2 : 채널 n으로 이동하기 위해 눌러야 하는 최소 버튼 수 계산하는 함수
    private static int getPushCountOfButtonsToMoveChannel(int destChannel, boolean[] isBrokenButton) {
        int ret = (destChannel > 100)? destChannel - 100 : 100 - destChannel; // 초기값 설정: 현재 채널에서 100번 채널까지의 거리
        int lowChannel = -1, highChannel = -1, maxChannel = 100;
        int divider = (destChannel > 0)? ((int) Math.pow(10, (int) Math.log10(destChannel))) : 1;
        boolean isBrokenDestChannel = false;

        // 목표 채널 destChannel이 고장난 버튼을 포함하는지 확인
        for(int i = divider; i > 0; i /= 10) {
            if(isBrokenButton[destChannel / i % 10]) {
                isBrokenDestChannel = true;
                break;
            }
        }

        // 목표 채널이 고장난 버튼을 포함하지 않는 경우
        if(!isBrokenDestChannel) {
            int retOfDestChannel = String.valueOf(destChannel).length(); // 목표 채널의 버튼 누름 수 계산
            return (retOfDestChannel < ret)? retOfDestChannel : ret; // 최소 버튼 누름 수 반환
        }

        // 최대 채널 계산: destChannel의 자릿수에 따라 설정
        for(int i = 0; i < (int) Math.log10(destChannel); i++)
            maxChannel *= 10;

        // 낮은 채널부터 시작하여 고장난 버튼을 포함하지 않는 최저 채널 계산
        for(int i = destChannel - 1; i >= 0; i--) {
            boolean isBrokenLowChannel = false;
            int brokenDivider = 0;

            divider = (i > 0)? ((int) Math.pow(10, (int) Math.log10(i))) : 1;

            for(int j = divider; j > 0; j /= 10) {
                if(isBrokenButton[i / j % 10]) {
                    isBrokenLowChannel = true;
                    brokenDivider = j;
                    break;
                }
            }

            // 고장난 버튼을 포함하지 않는 최저 채널 계산
            if(isBrokenLowChannel) {
                i -= i % brokenDivider;
            } else {
                lowChannel = i;
                break;
            }
        }

        // 높은 채널부터 시작하여 고장난 버튼을 포함하지 않는 최고 채널 계산
        for(int i = destChannel + 1; i < maxChannel; i++) {
            boolean isBrokenHighChannel = false;
            int brokenDivider = 0;

            divider = (i > 0)? ((int) Math.pow(10, (int) Math.log10(i))) : 1;

            for(int j = divider; j > 0; j /= 10) {
                if(isBrokenButton[i / j % 10]) {
                    isBrokenHighChannel = true;
                    brokenDivider = j;
                    break;
                }
            }

            // 고장난 버튼을 포함하지 않는 최고 채널 계산
            if(isBrokenHighChannel) {
                i -= i % brokenDivider;
                i += brokenDivider - 1;
            } else {
                highChannel = i;
                break;
            }
        }

        // 낮은 채널에서 목표 채널로 이동하는 최소 버튼 누름 수 계산
        if(lowChannel > -1) {
            int retOfLowChannel = String.valueOf(lowChannel).length();

            retOfLowChannel += destChannel - lowChannel;
            ret = (retOfLowChannel < ret)? retOfLowChannel : ret;
        }

        // 높은 채널에서 목표 채널로 이동하는 최소 버튼 누름 수 계산
        if(highChannel > -1) {
            int retOfHighChannel = String.valueOf(highChannel).length();

            retOfHighChannel += highChannel - destChannel;
            ret = (retOfHighChannel < ret)? retOfHighChannel : ret;
        }

        return ret; // 최소 버튼 누름 수 반환
    }



    /*
    가독성 생각하면서 만들어봄
    메모리 : 45124 KB
    시간 : 212 ms
     */
    private static void solution3() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int targetChannel = Integer.parseInt(br.readLine()); // 목표 채널 N
        int m = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수 M
        boolean[] broken = new boolean[10]; // 고장난 버튼 배열

        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int brokenButton = Integer.parseInt(st.nextToken());
                broken[brokenButton] = true;
            }
        }

        int minPressCount = Math.abs(targetChannel - 100); // 초기값: 현재 채널이 100번일 때의 버튼 누름 수

        for (int i = 0; i <= 1000000; i++) { // 채널 범위는 0부터 100만까지로 가정
            if (isPossible(i, broken)) {
                int pressCount = Math.abs(targetChannel - i) + String.valueOf(i).length();
                minPressCount = Math.min(minPressCount, pressCount);
            }
        }

        System.out.println(minPressCount);
    }


    // 해당 채널을 누를 수 있는지 확인하는 메서드
    private static boolean isPossible(int channel, boolean[] broken) {
        if (channel == 0) {
            return !broken[0];
        }
        while (channel > 0) {
            if (broken[channel % 10]) {
                return false;
            }
            channel /= 10;
        }
        return true;
    }

}
