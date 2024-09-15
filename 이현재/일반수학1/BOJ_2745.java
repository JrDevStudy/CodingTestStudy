package 이현재.일반수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2745 {

    /**
     * 진법 변환
     * <pre>
     *     <b>[문제]</b>
     *     B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.
     *     10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다.
     *     이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
     *     A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
     *
     *     <b>[입력]</b>
     *     첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36)
     *     B진법 수 N을 10진법으로 바꾸면, 항상 10억보다 작거나 같다.
     *
     *     <b>[출력]</b>
     *     첫째 줄에 B진법 수 N을 10진법으로 출력한다.
     * </pre>
     *
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/2745">문제 보기</a>
     */
    public static void main(String[] args) throws IOException {
//        solution01();
        solution02();
    }
    // 104ms
    public static void solution01() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        int res = 0;
        int s = 0; // 자리수(자리수만큼 제곱해야 한다.)
        for (int i = n.length() - 1; i >= 0; i--) {
            char c = n.charAt(i);
            int v = 'A' <= c && c <= 'Z' ? c - 'A' + 10 : c - '0';
            res += (int) (v * Math.pow(b, s++));
        }

        System.out.println(res);
    }
    // 100ms
    public static void solution02() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        int res = 0;
        int s = 1; // 진법 * 자리수
        for (int i = n.length() - 1; i >= 0; i--) {
            char c = n.charAt(i);
            int v = 'A' <= c && c <= 'Z' ? c - 'A' + 10 : c - '0';
            res += v * s;
            s *= b;
        }

        System.out.println(res);
    }
}
