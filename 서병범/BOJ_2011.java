package 서병범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2011 {

    /*
    상근이와 선영이가 다른 사람들이 남매간의 대화를 듣는 것을 방지하기 위해서 대화를 서로 암호화 하기로 했다. 그래서 다음과 같은 대화를 했다.

        상근: 그냥 간단히 암호화 하자. A를 1이라고 하고, B는 2로, 그리고 Z는 26으로 하는거야.
        선영: 그럼 안돼. 만약, "BEAN"을 암호화하면 25114가 나오는데, 이걸 다시 글자로 바꾸는 방법은 여러 가지가 있어.
        상근: 그렇네. 25114를 다시 영어로 바꾸면, "BEAAD", "YAAD", "YAN", "YKD", "BEKD", "BEAN" 총 6가지가 나오는데, BEAN이 맞는 단어라는건 쉽게 알수 있잖아?
        선영: 예가 적절하지 않았네 ㅠㅠ 만약 내가 500자리 글자를 암호화 했다고 해봐. 그 때는 나올 수 있는 해석이 정말 많은데, 그걸 언제 다해봐?
        상근: 얼마나 많은데?
        선영: 구해보자!

    어떤 암호가 주어졌을 때, 그 암호의 해석이 몇 가지가 나올 수 있는지 구하는 프로그램을 작성하시오.

    @Input
         * 첫째 줄에 5000자리 이하의 암호가 주어진다. 암호는 숫자로 이루어져 있다.
         * Example :
                    25114
    @OutPut
         * 나올 수 있는 해석의 가짓수를 구하시오. 정답이 매우 클 수 있으므로, 1000000으로 나눈 나머지를 출력한다.
           암호가 잘못되어 암호를 해석할 수 없는 경우에는 0을 출력한다.
         * Example :
                    6

    @link https://www.acmicpc.net/problem/2011
    */

    public static void main(String[] args) throws IOException {
//        solution1();
//        solution2();
        solution3();
    }



    /**
     * 메모리 : 14944 KB
     * 시간 : 140 ms
     * @throws IOException
     */
    public static void solution1() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine();

        System.out.println(decodeWays(code));
    }

    private static int decodeWays(String code) {
        // 입력이 유효한지 검증: 입력이 null이거나 빈 문자열이거나 '0'으로 시작하면 해석 불가
        if (code == null || code.length() == 0 || code.charAt(0) == '0') {
            return 0;
        }

        int n = code.length();  // 암호화된 문자열의 길이
        int[] dp = new int[n + 1];  // DP 배열 선언, 길이는 n+1
        dp[0] = 1;  // 빈 문자열의 경우의 수는 1
        dp[1] = 1;  // 첫 문자가 '0'이 아님을 이미 확인했으므로 경우의 수는 1

        // DP 배열을 채워나감
        for (int i = 2; i <= n; i++) {
            // 한 자리 숫자를 확인
            int oneDigit = Integer.parseInt(code.substring(i - 1, i));
            // 두 자리 숫자를 확인
            int twoDigits = Integer.parseInt(code.substring(i - 2, i));

            // 한 자리 숫자가 1부터 9 사이인지 확인하여 유효하면 경우의 수를 추가
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            // 두 자리 숫자가 10부터 26 사이인지 확인하여 유효하면 경우의 수를 추가
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }

            // 결과가 매우 클 수 있으므로 1000000으로 나눈 나머지를 저장
            dp[i] %= 1000000;
        }

        // dp[n]이 최종 해석 가능한 경우의 수
        return dp[n];
    }



    /**
     * 백준 상위 등수 풀이
     * 메모리 : 11436 KB
     * 시간 : 64 ms
     *
     *
     * @throws IOException
     */
    private static void solution2() throws IOException {

        // 입력을 받을 버퍼를 선언하고 System.in.read()를 사용하여 입력을 받음
        byte[] buffer = new byte[5001];
        int N = System.in.read(buffer) - 1; // 입력의 길이를 읽고 줄바꿈 문자를 제외한 실제 길이를 계산

        final int MOD = 1000000; // 결과가 매우 클 수 있으므로 1000000으로 나눈 나머지를 저장할 상수 선언
        int[] dp = new int[N]; // dp 배열 선언, 길이는 입력 문자열의 길이

        // dp 배열을 채워나감
        for (int i = 0; i < N; i++) {
            char current = (char) buffer[i]; // 현재 위치의 문자
            char last = i >= 1 ? (char) buffer[i - 1] : 0; // 이전 위치의 문자, 첫 위치에서는 0

            // 한글자 해석 가능 여부를 확인
            if ('1' <= current && current <= '9') {
                dp[i] += i >= 1 ? dp[i - 1] : 1; // 이전 해석 경우의 수를 추가, 첫 위치에서는 1을 추가
                dp[i] %= MOD; // 결과가 클 수 있으므로 1000000으로 나눈 나머지를 저장
            }

            // 두글자 해석 가능 여부를 확인
            if ('1' <= last && last <= '2') { // 두 글자가 10-26 범위에 있는지 확인
                if (last == '1' || '0' <= current && current <= '6') { // 두 글자가 10-19 또는 20-26 범위에 있는지 확인
                    dp[i] += i >= 2 ? dp[i - 2] : 1; // 이전 두 위치의 경우의 수를 추가, 첫 두 위치에서는 1을 추가
                    dp[i] %= MOD; // 결과가 클 수 있으므로 1000000으로 나눈 나머지를 저장
                }
            }
        }

        // 최종 해석 가능한 경우의 수를 출력
        System.out.println(dp[N - 1]);
    }


    /**
     * 또 다른 풀이
     * 메모리 : 14484 KB
     * 시간 : 128 ms
     *
     *
     * @throws IOException
     */
    private static void solution3() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int N = num.length();
        int[] dp = new int[N+1];
        dp[0] = 1;
        if (num.charAt(0) == '0') {
            System.out.println(0);
            return;
        }
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            if (num.charAt(i-1) == '0') {
                if (num.charAt(i-2) > '2' || num.charAt(i-2) == '0') break;
                dp[i] = dp[i-2];
            }

            else {
                int temp = Integer.parseInt(num.substring(i-2, i));
                if (temp >= 10 && temp <= 26) dp[i] += dp[i-2];
                dp[i] += dp[i-1];
            }
            dp[i] %= 1_000_000;
        }
        System.out.println(dp[N]);
    }



}
