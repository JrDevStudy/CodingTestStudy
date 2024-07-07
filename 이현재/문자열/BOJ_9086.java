package 이현재.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9086 {

    /**
     * 1546번: 문자열 - 120ms
     * <pre>
     *     <b>[문제]</b>
     *     문자열을 입력으로 주면 문자열의 첫 글자와 마지막 글자를 출력하는 프로그램을 작성하시오.
     *
     *     <b>[입력]</b>
     *     입력의 첫 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 10)가 주어진다.
     *     각 테스트 케이스는 한 줄에 하나의 문자열이 주어진다.
     *     문자열은 알파벳 A~Z 대문자로 이루어지며 알파벳 사이에 공백은 없으며 문자열의 길이는 1000보다 작다.
     *
     *     <b>[출력]</b>
     *     각 테스트 케이스에 대해서 주어진 문자열의 첫 글자와 마지막 글자를 연속하여 출력한다.
     * </pre>
     *
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/9086">문제 보기</a>
     */
    public static void main00(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char[] str = br.readLine().toCharArray();
            sb.append(str[0]).append(str[str.length - 1]).append('\n');
        }
        System.out.println(sb);
    }

    /**
     * charAt 을 활용한 풀이 - 148ms
     * @param args args
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            String str = br.readLine();
            System.out.println(str.charAt(0) + "" + str.charAt(str.length()-1));
        }
    }
}
