package 이현재.심화1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1157 {

    /**
     * 단어 공부 - 126ms
     * <pre>
     *     바이트 값으로 입력 값 받아서 풀기
     * </pre>
     *
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/1157">문제 보기</a>
     */
    public static void main(String[] args) throws IOException {
        int[] arr = new int[26];
        int c = System.in.read();
        while (c > 64) {
            if (c < 91) {
                arr[c - 65]++;
            } else {
                arr[c - 97]++;
            }
            c = System.in.read();
        }

        int max = -1;
        int ch = -2; // ? 아스키 코드 값 63
        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                ch = i;
            } else if (arr[i] == max) {
                ch = -2;
            }
        }
        System.out.println((char) (ch + 65));
    }

    // max 값과 같을 경우 출력할 값 '?'로 돌려놓기 - 236ms
    public static void other01(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            // 대문자 범위('A' ~ 'Z')
            if (65 <= s.charAt(i) && s.charAt(i) <= 90) {
                arr[s.charAt(i) - 65]++;
            } else { // 소문자 범위
                arr[s.charAt(i) - 97]++;
            }
        }
        int max = -1;
        char ch = '?';
        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                ch = (char) (i + 65);
            }
            else if (arr[i] == max) ch = '?';
        }
        System.out.println(ch);
    }

    // 가장 많이 사용된 알파벳 구하는 로직 개선 - 248ms
    public static void other00(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase();
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'A']++;
        }
        int maxIndex = 0;
        int sameIndex = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[maxIndex] < arr[i]) maxIndex = i;
            else if (arr[maxIndex] == arr[i]) sameIndex = i;
        }
        if (maxIndex == 0 && sameIndex == 0) System.out.println("A");
        else if (arr[maxIndex] == arr[sameIndex]) System.out.println("?");
        else System.out.println((char)(maxIndex + 'A'));
    }

    // toUpperCase 함수 안쓰기 - 228ms
    public static void main01(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (65 <= s.charAt(i) && s.charAt(i) <= 90) {
                arr[s.charAt(i) - 'A']++;
            } else {
                arr[s.charAt(i) - 'a']++;
            }

        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        int duple = 0;
        for (int i = 0; i < 26; i++) {
            if (max == arr[i]) {
                if (duple == 1) {
                    System.out.println("?");
                    return;
                }
                duple++;
            }
        }
        System.out.println((char)('A' + index));
    }

    // 생각나는대로 풀기 - 244ms
    public static void main00(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase();
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'A']++;
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        int duple = 0;
        for (int i = 0; i < 26; i++) {
            if (max == arr[i]) {
                if (duple == 1) {
                    System.out.println("?");
                    return;
                }
                duple++;
            }
        }
        System.out.println((char)('A' + index));
    }
}
