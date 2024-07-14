package 이현재.심화1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10988 {

    /**
     * 팰린드롬인지 확인하기 - 104ms
     *
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/10988">문제 보기</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }

    // boolean 값으로 구분하기 - 104ms
    public static void main00(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean palindrome = true;
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) {
                palindrome = false;
                break;
            }
        }
        System.out.println(palindrome ? 1 : 0);
    }

    // 반복문 없는 풀이(reverse 함수 내부 구현에서 반복문을 사용) - 104ms
    public static void other(String[] args) throws IOException {
        int ans = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int sub = str.length() / 2;
        String str1 = sb.append(str, 0, sub).reverse().toString();

        if(str.length() % 2 == 0) {
            if(str1.equals(str.substring(sub))) {
                ans = 1;
            }
        } else {
            if(str1.equals(str.substring(sub + 1))) {
                ans = 1;
            }
        }

        System.out.print(ans);
    }
}
