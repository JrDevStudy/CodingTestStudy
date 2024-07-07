package 이현재.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11654 {

    /**
     * 11654번: 아스키 코드 - 124ms
     * <pre>
     *     <b>[문제]</b>
     *     알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.
     *
     *     <b>[입력]</b>
     *     알파벳 소문자, 대문자, 숫자 0-9 중 하나가 첫째 줄에 주어진다.
     *
     *     <b>[출력]</b>
     *     입력으로 주어진 글자의 아스키 코드 값을 출력한다.
     * </pre>
     *
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/11654">문제 보기</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println((int)br.readLine().charAt(0)); // char type 을 int 형 변환하면 아스키 코드 값을 얻을 수 있다.
    }

    /**
     * 더 간결한 풀이 - 124ms
     * @param args args
     * @throws IOException IOException
     */
    public static void other(String[] args) throws IOException {
        int ch = System.in.read(); // byte 값을 int형으로 반환 받는다. 문자형은 아스키 코드 값을 반환한다.
        System.out.println(ch);
    }
}
