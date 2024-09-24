package 이현재.일반수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_11005 {

    /**
     * 진법 변환 2
     * <pre>
     *     <b>[문제]</b>
     *     10진법 수 N이 주어진다.
     *     이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.
     *     10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다.
     *     이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
     *     A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
     *
     *     <b>[입력]</b>
     *     첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36)
     *     N은 10억보다 작거나 같은 자연수이다.
     *
     *     <b>[출력]</b>
     *     첫째 줄에 10진법 수 N을 B진법으로 출력한다.
     * </pre>
     *
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/11005">문제 보기</a>
     */
    public static void main(String[] args) throws IOException {
//        solution01();
//        solution02();
        solution03();
    }

    // 104ms
    public static void solution01() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken()); // 10진법 수
        int B = Integer.parseInt(st.nextToken()); // B 진법

        Deque<Integer> stack = new ArrayDeque<>();
        int q = N; // 몫
        while (q >= B) {
            int r = q % B; // 나머지
            stack.push(r);
            q /= B;
        }

        if (q > 9) {
            char c = (char) (q - 10 + 'A');
            sb.append(c);
        } else {
            sb.append(q);
        }

        int size = stack.size();
        for (int i = 0; i < size; i++) {
            int s = stack.pop();
            if (s > 9) {
                char c = (char) (s - 10 + 'A');
                sb.append(c);
            } else {
                sb.append(s);
            }
        }

        System.out.println(sb);
    }
    // 104ms
    public static void solution02() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken()); // 10진법 수
        int b = Integer.parseInt(st.nextToken()); // b 진법

        Deque<Integer> stack = new ArrayDeque<>();
        while (n >= b) {
            int r = n % b; // 나머지
            stack.push(r);
            n /= b;
        }
        stack.push(n);

        int size = stack.size();
        for (int i = 0; i < size; i++) {
            int k = stack.pop();
            char c = k > 9 ? (char) (k - 10 + 'A') : (char) (k + '0');
            sb.append(c);
        }

        System.out.println(sb);
    }

    // 100ms
    public static void solution03() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken()); // 10진법 수
        int b = Integer.parseInt(st.nextToken()); // b 진법

        while (n > 0) {
            int r = n % b; // 나머지
            if (r < 10) {
                sb.append(r);
            } else {
                char c = (char) (r + 55);
                sb.append(c);
            }
            n /= b;
        }

        System.out.println(sb.reverse());
    }
}
