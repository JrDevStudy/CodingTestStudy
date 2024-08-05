package 서병범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1254번: 팰린드롬 만들기
 * <pre>
 *     <b>[문제]</b>
 *     동호와 규완이는 212호에서 문자열에 대해 공부하고 있다. 규완이는 팰린드롬을 엄청나게 좋아한다.
 *     팰린드롬이란 앞에서부터 읽으나 뒤에서부터 읽으나 같게 읽히는 문자열을 말한다.
 *
 *     동호는 규완이를 위한 깜짝 선물을 준비했다. 동호는 규완이가 적어놓고 간 문자열 S에 0개 이상의 문자를 문자열 뒤에 추가해서 팰린드롬을 만들려고 한다.
 *     동호는 가능하면 가장 짧은 문자열을 만들려고 한다.
 *
 *     동호가 만들 수 있는 가장 짧은 팰린드롬의 길이를 출력하는 프로그램을 작성하시오.
 *
 *     <b>[입력]</b>
 *     첫째 줄에 문자열 S가 주어진다. S는 알파벳 소문자로만 이루어져 있고, 길이는 최대 50이다.
 *     Example : abab
 *
 *     <b>[출력]</b>
 *     첫째 줄에 동호가 만들 수 있는 가장 짧은 팰린드롬의 길이를 출력한다.
 *     Example : 5
 * </pre>
 * @see <a href="https://www.acmicpc.net/problem/1254">문제 보기</a>
 */
public class BOJ_1254 {

    public static void main(String[] args) throws IOException {
//        solution1();
        solution2();
    }

    /**
     * 메모리 : 14212 KB
     * 시간 : 104 ms
     * @throws IOException
     */
    public static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine(); // 문자열 입력받기
        int n = s.length(); // 문자열의 길이

        int minLength = n; // 최소 팰린드롬 길이 초기화
        for (int i = 0; i < n; i++) {
            // 현재 부분 문자열이 팰린드롬인지 확인
            if (isPalindrome(s, i, n - 1)) {
                minLength = n + i; // 최소 팰린드롬 길이 갱신
                break; // 가장 짧은 팰린드롬을 찾았으므로 종료
            }
        }

        System.out.println(minLength); // 결과 출력
    }

    /**
     * 주어진 범위 내의 문자열이 팰린드롬인지 확인하는 함수
     * @param s 입력 문자열
     * @param start 시작 인덱스
     * @param end 끝 인덱스
     * @return 팰린드롬이면 true, 아니면 false
     */
    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * 백준 상위 등수 풀이
     * StringBuilder/StringBuffer 클래스의 reverse() 활용.
     * (예시 : "abcde" -> "edcba")
     *
     * (1) 부분 문자열을 다루기:
     * 전체 문자열 대신 substring을 사용하여 문자열을 반으로 나누고, 필요한 부분만 처리함으로써 메모리를 절약
     *
     * (2) 부분적인 문자열 연산:
     * 모든 가능한 팰린드롬을 생성하는 대신, 입력 문자열 N의 반만 처리하고, 그 뒤에 반대 방향으로 같은 문자열을 추가하는 방식으로 연산 최소화
     *
     * 메모리 :  11564 KB
     * 시간 :  68 ms
     *
     * @throws IOException
     */
    public static void solution2() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        // a : 입력 받은 문자열을 반으로 나눈 것의 앞부분, b : 입력 받은 문자열을 반으로 나눈 것의 뒷부분
        String a = N.substring(0, N.length()/2), b = N.substring(N.length()/2, N.length()), c, d;
        for(int i=0; i<b.length(); i++) {
            // t : 입력 받은 문자열을 반으로 나눈 것의 앞부분을 반대로 뒤집은 문자열
            String t = new StringBuffer(a).reverse().toString();
            c=a+t;
            a+=b.charAt(i);
            d=a+t;
            if(c.contains(N)) {
                System.out.println(c.length());
                break;
            }
            if(d.contains(N)) {
                System.out.println(d.length());
                break;
            }

        }

    }




}
