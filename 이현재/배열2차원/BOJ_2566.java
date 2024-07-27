package 이현재.배열2차원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2566 {

    /**
     * 최댓값 - 156ms
     *
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/2566">문제 보기</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0; // 최댓값 할당
        int row = 1; // 최댓값의 행
        int col = 1; // 최댓값의 열
        for (int i = 0;  i < 9; i++) {
            String[] strings = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                int n = Integer.parseInt(strings[j]);
                if (n > max) {
                    max = n;
                    row = i + 1;
                    col = j + 1;
                }
            }
        }
        System.out.println(max + "\n" + row + " " + col);
    }
}
