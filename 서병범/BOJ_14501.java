package 서병범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501 {


    /*
    상담원으로 일하고 있는 백준이는 퇴사를 하려고 한다.

    오늘부터 N+1일째 되는 날 퇴사를 하기 위해서, 남은 N일 동안 최대한 많은 상담을 하려고 한다.

    백준이는 비서에게 최대한 많은 상담을 잡으라고 부탁을 했고, 비서는 하루에 하나씩 서로 다른 사람의 상담을 잡아놓았다.

    각각의 상담은 상담을 완료하는데 걸리는 기간 Ti와 상담을 했을 때 받을 수 있는 금액 Pi로 이루어져 있다.

    N = 7인 경우에 다음과 같은 상담 일정표를 보자.

        1일	2일	3일	4일	5일	6일	7일
    Ti	3	5	1	1	2	4	2
    Pi	10	20	10	20	15	40	200

    1일에 잡혀있는 상담은 총 3일이 걸리며, 상담했을 때 받을 수 있는 금액은 10이다. 5일에 잡혀있는 상담은 총 2일이 걸리며, 받을 수 있는 금액은 15이다.

    상담을 하는데 필요한 기간은 1일보다 클 수 있기 때문에, 모든 상담을 할 수는 없다. 예를 들어서 1일에 상담을 하게 되면, 2일, 3일에 있는 상담은 할 수 없게 된다. 2일에 있는 상담을 하게 되면, 3, 4, 5, 6일에 잡혀있는 상담은 할 수 없다.

    또한, N+1일째에는 회사에 없기 때문에, 6, 7일에 있는 상담을 할 수 없다.

    퇴사 전에 할 수 있는 상담의 최대 이익은 1일, 4일, 5일에 있는 상담을 하는 것이며, 이때의 이익은 10+20+15=45이다.

    상담을 적절히 했을 때, 백준이가 얻을 수 있는 최대 수익을 구하는 프로그램을 작성하시오.

    @Input
         * 첫째 줄에 N (1 ≤ N ≤ 15)이 주어진다.
           둘째 줄부터 N개의 줄에 Ti와 Pi가 공백으로 구분되어서 주어지며, 1일부터 N일까지 순서대로 주어진다. (1 ≤ Ti ≤ 5, 1 ≤ Pi ≤ 1,000)
         * Example :
                    7
                    3 10
                    5 20
                    1 10
                    1 20
                    2 15
                    4 40
                    2 200
    @OutPut
         * 첫째 줄에 백준이가 얻을 수 있는 최대 이익을 출력한다.
         * Example : 45

    @link https://www.acmicpc.net/problem/14501
    */


    public static void main(String[] args) throws IOException {

//        solution1();
//        solution2();
        solution3();

    }


    /** 1번째 방법
     *
     */
    private static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] dp = new int[N + 2]; // dp 배열을 N+2 크기로 초기화. dp[i]는 i번째 날부터 마지막 날까지의 최대 수익을 저장

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        //역순으로 날짜를 순회하면서 각 날짜의 상담을 고려
        for (int i = N; i > 0; i--) {
            int time = i + T[i];
            if (time <= N + 1) { //날짜 i에서 상담을 할 수 있는 경우
                dp[i] = Math.max(dp[i + 1], P[i] + dp[time]);
                //dp[i+1] (상담을 하지 않은 경우)와 P[i] + dp[i + T[i]] (상담을 한 경우) 중 최대값으로 갱신
            } else { // 상담을 할 수 없는 경우
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);
    }


    /** 2번째 방법
     *
     */
    private static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] days = new int[N + 1]; // 각 상담이 걸리는 시간
        int[] pays = new int[N + 1]; // 각 상담의 수익
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            pays[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0; // 최대 수익
        int[] dp = new int[N + 1]; // i일까지의 최대 수익을 저장하는 배열
        for (int i = 1; i <= N; i++) {
            // 현재 상담이 끝나는 날이 퇴사일을 넘지 않는 경우
            if (days[i] + i <= N + 1) {
                dp[i] = pays[i];
            }

            int maxProfitUntilNow = 0;
            // 이전 날들 중에서 현재 상담을 시작할 수 있는 최대 수익을 찾음(*이중 반복문 : O(N^2)의 시간 복잡도를 가짐. => 개선할 수 있음)
            for (int j = 1; j < i; j++) {
                if (days[j] + j <= i) {
                    maxProfitUntilNow = Math.max(dp[j], maxProfitUntilNow);
                }
            }
            dp[i] += maxProfitUntilNow;
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }


    /** solutuon2 개선
     * dp 배열을 갱신할 때, 각 상담이 끝나는 시점에 그 시점 이후의 최대 수익을 갱신
     * -> 이중 반복문을 단일 반복문으로 개선
     * 14220KB	128ms -> 14196KB  124ms
     * (미미하지만 복잡도 자체는 O(N^2) -> O(N) 으로 개선)
     */
    private static void solution3() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] days = new int[N + 1];
        int[] pays = new int[N + 1];
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            pays[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            if (i + days[i] <= N + 1) {
                dp[i + days[i]] = Math.max(dp[i + days[i]], dp[i] + pays[i]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[N + 1]);

    }


    //설명 추가

    /* BufferedReader, InputStreamReader

    BufferedReader 클래스는 Java에서 입력을 효율적으로 읽기 위해 사용됩니다. 표준 입력(System.in)을 처리할 때 주로 사용됩니다.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    여기서 InputStreamReader는 바이트 스트림을 문자 스트림으로 변환하고, BufferedReader는 이 문자 스트림을 버퍼링하여 효율적으로 처리합니다.

    String line = br.readLine();
    한 줄을 읽어 문자열로 반환합니다. 엔터키를 누를 때까지 입력된 모든 문자를 읽어들입니다.
     */


    /*StringTokenizer

    StringTokenizer 클래스는 문자열을 지정된 구분자(delimiter)로 분리할 때 사용됩니다. 보통 공백을 기준으로 분리할 때 많이 사용됩니다.

    StringTokenizer st = new StringTokenizer(line);
    여기서 line은 BufferedReader로 읽어들인 문자열입니다. 기본 구분자는 공백입니다.

    String token = st.nextToken();
    이 메서드는 다음 구분자까지의 문자열을 반환합니다. 공백을 기준으로 분리된 다음 문자열 토큰을 반환합니다.
     */

}
