package 임인혁.boj_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] correctCount = {1, 1, 2, 2, 2, 8};

        String[] input = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < correctCount.length; i++) {
            int foundCount = Integer.parseInt(input[i]);
            sb.append(correctCount[i] - foundCount).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}