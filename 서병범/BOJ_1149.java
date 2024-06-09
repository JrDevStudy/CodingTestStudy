package 서병범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1149 {
    /*
    RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
    집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
        1번 집의 색은 2번 집의 색과 같지 않아야 한다.
        N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
        i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

    @Input
         * 첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다.
           둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.
         * Example :
            3
            26 40 83
            49 60 57
            13 89 99
    @OutPut
         * 첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
         * Example :
            96

    @link https://www.acmicpc.net/problem/1149
    */

    public static void main(String[] args) throws Exception {
//        solution1();
//        solution2();
        solution3();
    }


    private static void solution1() {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] cost = new int[N][3];

        for (int i = 0; i < N; i++) {
            cost[i][0] = sc.nextInt(); // 빨강 비용
            cost[i][1] = sc.nextInt(); // 초록 비용
            cost[i][2] = sc.nextInt(); // 파랑 비용
        }

        // houses 배열 선언
        int[][] houses = new int[N][3];

        // 초기 비용 설정 (첫 번째 집)
        houses[0][0] = cost[0][0];
        houses[0][1] = cost[0][1];
        houses[0][2] = cost[0][2];

        // houses를 이용해 최소 비용 계산
        for (int i = 1; i < N; i++) {
            houses[i][0] = cost[i][0] + Math.min(houses[i-1][1], houses[i-1][2]);
            houses[i][1] = cost[i][1] + Math.min(houses[i-1][0], houses[i-1][2]);
            houses[i][2] = cost[i][2] + Math.min(houses[i-1][0], houses[i-1][1]);
        }

        // 마지막 집까지의 최소 비용 중 가장 작은 값 찾기
        int result = Math.min(houses[N-1][0], Math.min(houses[N-1][1], houses[N-1][2]));

        System.out.println(result);

        sc.close();
    }




    /* 2번째 방법(로직 자체는 동일)
    * Reader Class 생성
    * StringTokenizer.nextToken()
    * */
    static Reader in = new Reader();

    private static void solution2() throws Exception {
        // 집의 수 입력
        int N = in.nextInt();

        // 각 집을 빨강, 초록, 파랑으로 칠하는 비용을 저장할 DP 배열
        int[][] dp = new int[N][3];

        // 첫 번째 집을 빨강, 초록, 파랑으로 칠하는 비용 입력
        dp[0][0] = in.nextInt();
        dp[0][1] = in.nextInt();
        dp[0][2] = in.nextInt();

        // 두 번째 집부터 N번째 집까지의 비용 계산
        for(int i = 1; i < N; i++) {
            // i번째 집을 빨강으로 칠하는 최소 비용
            dp[i][0] = in.nextInt() + Math.min(dp[i-1][1], dp[i-1][2]);
            // i번째 집을 초록으로 칠하는 최소 비용
            dp[i][1] = in.nextInt() + Math.min(dp[i-1][0], dp[i-1][2]);
            // i번째 집을 파랑으로 칠하는 최소 비용
            dp[i][2] = in.nextInt() + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        // 마지막 집까지의 최소 비용 중 가장 작은 값을 출력
        System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
    }

    // 빠른 입력 처리를 위한 Reader 클래스 정의
    static class Reader {
        // 버퍼 크기 정의 (8KB)

        //ref(buffer의 필요성) : https://enjoydevelop.tistory.com/94
        /*
        이유 1: 효율적인 입력 처리
        - I/O 성능 최적화: 작은 크기의 버퍼를 자주 읽는 것보다 큰 크기의 버퍼를 한 번에 읽는 것이 I/O 성능 측면에서 더 효율적입니다. 8KB는 메모리와 디스크 I/O의 효율성 사이에서 좋은 균형을 유지할 수 있는 크기입니다.
        - 시스템 콜 감소: 큰 버퍼를 사용하면 시스템 콜의 횟수를 줄일 수 있습니다. 시스템 콜은 상대적으로 비용이 많이 들기 때문에, 이를 줄이면 성능이 향상됩니다.
        이유 2: 메모리 사용의 효율성
        - 적절한 메모리 사용: 8KB는 대부분의 현대 시스템에서 메모리 사용 측면에서 적절한 크기입니다. 너무 큰 버퍼는 메모리를 낭비하게 만들고, 너무 작은 버퍼는 I/O 작업을 자주 발생시켜 성능을 저하시킬 수 있습니다.
        이유 3: 캐시 성능
        - CPU 캐시 최적화: 8KB 크기는 많은 시스템에서 CPU 캐시 라인과 잘 맞습니다. 이는 버퍼가 CPU 캐시에서 효율적으로 처리될 수 있도록 합니다. 캐시 효율성을 높이면 메모리 접근 시간을 줄일 수 있습니다.
        이유 4: 일반적인 관례
        - 표준 관례: 8KB는 많은 경우에 표준적으로 사용되는 버퍼 크기입니다. 이는 경험적으로 많은 상황에서 효율적이라는 것이 입증되었기 때문입니다. 많은 라이브러리와 시스템에서 8KB 크기의 버퍼를 사용합니다.
        */
        final int SIZE = 1 << 13; // // 8192 바이트, 2^13 = 8192
        byte[] buffer = new byte[SIZE];
        int index, size;

        //ref(ASCII 코드 표) : https://m.blog.naver.com/seatoskyme/222155172555
        /*
        (1) 공백 무시: while ((c = read()) <= 32); 부분은 공백(ASCII 코드가 32 이하인 모든 공백 문자 포함)을 건너뜁니다.
        (2) 정수 변환: do n = (n << 3) + (n << 1) + (c & 15); 부분은 ASCII 코드로 읽은 문자를 정수로 변환합니다. (c & 15)는 ASCII 코드에서 숫자 값을 얻는 방식입니다. 예를 들어, '0'의 ASCII 코드가 48이고 '0' & 15는 0이 됩니다.
        (3) 다음 문자 읽기: while (isNumber(c = read()));는 숫자가 아닌 문자를 만날 때까지 반복합니다.
        */
        // 다음 정수를 읽어오는 메서드
        int nextInt() throws Exception {
            int n = 0;
            byte c;
            // (1) 공백 문자를 건너뜀
            while ((c = read()) <= 32);
            // (2) 숫자를 읽어 정수로 변환
            do n = (n << 3) + (n << 1) + (c & 15);
            // (3) 다음 문자 읽기
            while (isNumber(c = read()));
            return n;
        }

        // 문자가 숫자인지 확인하는 메서드
        boolean isNumber(byte c) {
            return 47 < c && c < 58;
        }

        // 버퍼에서 다음 문자를 읽어오는 메서드
        byte read() throws Exception {
            // 버퍼가 비어 있으면 다시 채움
            if (index == size) {
                size = System.in.read(buffer, index = 0, SIZE);
                if (size < 0)
                    buffer[0] = -1;
            }
            // 다음 문자 반환
            return buffer[index++];
        }
    }



    /* 3번째 방법(로직 자체는 동일)
    * BufferedReader.readLine()
    * StringTokenizer.nextToken()
    * */
    private static void solution3() throws IOException {
        // BufferedReader를 사용하여 표준 입력(System.in)을 읽음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 집의 수 N을 읽어들임
        int N = Integer.parseInt(br.readLine());

        // 각 집을 칠하는 비용을 저장할 2차원 배열 생성
        int[][] houses = new int[N][3];

        // N개의 줄을 읽어 각 집을 칠하는 비용을 저장
        for (int i = 0; i < N; i++) {
            // 한 줄을 읽고 StringTokenizer로 공백을 기준으로 분리
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                // 각 집의 빨강, 초록, 파랑 비용을 저장
                houses[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 두 번째 집부터 N번째 집까지의 최소 비용 계산
        for (int i = 1; i < N; i++) {
            // i번째 집을 빨강으로 칠할 때의 최소 비용 계산
            houses[i][0] += Math.min(houses[i-1][1], houses[i-1][2]);
            // i번째 집을 초록으로 칠할 때의 최소 비용 계산
            houses[i][1] += Math.min(houses[i-1][0], houses[i-1][2]);
            // i번째 집을 파랑으로 칠할 때의 최소 비용 계산
            houses[i][2] += Math.min(houses[i-1][0], houses[i-1][1]);
        }

        // 마지막 집의 빨강, 초록, 파랑 비용 중 최소 비용을 출력
        System.out.println(Math.min(Math.min(houses[N-1][0], houses[N-1][1]), houses[N-1][2]));
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
