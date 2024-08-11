package 이현재.배열2차원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10798 {

    /**
     * 세로 읽기 - 104ms
     *
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/10798">문제 보기</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] words = new String[5][15]; // 최대 15개이기 때문에 열의 최대 길이를 15로 설정

        for (int i = 0; i < 5; i++) {
            String[] word = br.readLine().split(""); // 문자 단위로 쪼갠다.
            System.arraycopy(word, 0, words[i], 0, word.length); // 이차원 배열에 쪼갠 문자를 할당한다.
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                String word = words[j][i];
                if (word != null) sb.append(word);
            }
        }

        System.out.println(sb);
    }

    // 2차원 배열 사용하지 않고 단어 길이만큼만 읽어서 처리하기 - 128ms
    public static void other(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inputs = new String[5];
        int maxLen = 0;

        for (int i = 0; i < 5; i++) {
            inputs[i] = br.readLine();
            maxLen = Math.max(inputs[i].length(), maxLen); // 단어 길이의 최댓값 구하기
        }

        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < 5; j++) {
                if (inputs[j].length() > i) { // 읽으려는 단어가 단어 길이의 최댓값보다 작으면 읽지 않는다.
                    sb.append(inputs[j].charAt(i));
                }
            }
        }

        System.out.print(sb);
    }
}
