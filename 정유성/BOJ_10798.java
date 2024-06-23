package 정유성;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10814 {

    /*
        아직 글을 모르는 영석이가 벽에 걸린 칠판에 자석이 붙어있는 글자들을 붙이는 장난감을 가지고 놀고 있다.
        이 장난감에 있는 글자들은 영어 대문자 ‘A’부터 ‘Z’, 영어 소문자 ‘a’부터 ‘z’, 숫자 ‘0’부터 ‘9’이다.
        영석이는 칠판에 글자들을 수평으로 일렬로 붙여서 단어를 만든다. 다시 그 아래쪽에 글자들을 붙여서 또 다른 단어를 만든다.
        이런 식으로 다섯 개의 단어를 만든다. 아래 그림 1은 영석이가 칠판에 붙여 만든 단어들의 예이다.

        @Input
            * 총 다섯줄의 입력이 주어진다. 각 줄에는 최소 1개, 최대 15개의 글자들이 빈칸 없이 연속으로 주어진다.
              주어지는 글자는 영어 대문자 ‘A’부터 ‘Z’, 영어 소문자 ‘a’부터 ‘z’, 숫자 ‘0’부터 ‘9’ 중 하나이다. 각 줄의 시작과 마지막에 빈칸은 없다.
            * Example : ABCDE
                        abcde
                        01234
                        FGHIJ
                        fghij
        @OutPut
            * Example : Aa0FfBb1GgCc2HhDd3IiEe4Jj
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 5줄 총 15개 2차원 배열 선언
        char[][] str = new char[5][15];

        // 입력받은 문자들 그대로 출력해주기
        String input = "";
        for (int i = 0; i < str.length; i++) {
            input = sc.next();
            // 15개 문자 넣기
            for (int j = 0; j < input.length(); j++) {
                str[i][j] = input.charAt(j);
                // System.out.print(str[i][j]); // 입력받은 문자들 그대로 출력해주기
            }
            // System.out.println();
        }

        // 세로로 출력
        for (int i = 0; i < 15; i++) { //한줄에 최대 15개
            for (int j = 0; j < 5; j++) { //총 5줄
                if (str[j][i] == '\0') //빈문자열이면 출력하지 않기
                    continue;
                System.out.print(str[j][i]);

            }
        }
    }
}
