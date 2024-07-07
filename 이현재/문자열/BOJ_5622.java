package 이현재.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5622 {

    /**
     * 다이얼 - 100ms
     * @see <a href="https://www.acmicpc.net/problem/5622">문제 보기</a>
     * @param args args
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        String[] arr = {"", "", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        int result = 0;
        for (String s : input) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].contains(s)) {
                    result += i;
                }
            }
        }
        System.out.println(result);
    }

    // 정수 배열을 이용한 풀이 - 124ms
    public static void other00(String[] args) throws IOException {
        int[] dial = {3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int time = 0;
        for (char c : chars) {
            time += dial[c - 65];
        }
        System.out.println(time);
    }

    // 버퍼없이 입력 받는 풀이 - 124ms
    public static void other01(String[] args) throws IOException {
        int cnt = 0;
        int value;

        while (true) {
            value = System.in.read();
            if (value == '\n') break;

            if (value < 68) cnt += 3;
            else if (value < 71) cnt += 4;
            else if (value < 74) cnt += 5;
            else if (value < 77) cnt += 6;
            else if (value < 80) cnt += 7;
            else if (value < 84) cnt += 8;
            else if (value < 87) cnt += 9;
            else cnt += 10;
        }

        System.out.println(cnt);
    }
}
