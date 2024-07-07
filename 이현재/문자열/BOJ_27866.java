package 이현재.문자열;

import java.io.*;

public class BOJ_27866 {

    /**
     * 27866번: 문자와 문자열 - 132ms
     * <pre>
     *     <b>[문제]</b>
     *     단어 S와 정수 i가 주어졌을 때, S의 i번째 글자를 출력하는 프로그램을 작성하시오.
     *
     *     <b>[입력]</b>
     *     첫째 줄에 영어 소문자와 대문자로만 이루어진 단어 S가 주어진다. 단어의 길이는 최대 1,000이다.
     *     둘째 줄에 정수 i가 주어진다. (1 <= i <= S)
     *
     *     <b>[출력]</b>
     *     S의 i번째 글자를 출력한다.
     * </pre>
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/27866">문제 보기</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String[] split = str.split("");
        bw.write(split[Integer.parseInt(br.readLine()) - 1]);
        bw.flush();
    }

    /**
     * charAt을 이용한 풀이 - 120ms
     * @param args args
     * @throws IOException IOException
     */
    public static void other(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        bw.write(str.charAt(Integer.parseInt(br.readLine()) - 1));
        bw.flush();
    }
}
