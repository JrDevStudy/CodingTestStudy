package 이현재;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] arr = new boolean[20_000_001]; // 크기를 20,000,001로 변경하여 인덱스 문제 해결
        int n = Integer.parseInt(br.readLine());
        String[] cards = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        for (String card : cards) {
            int c = Integer.parseInt(card);
            if (c < 0) c = Math.abs(c) + 10_000_000;
            arr[c] = true;
        }

        for (String number : numbers) {
            int no = Integer.parseInt(number);
            if (no < 0) no = Math.abs(no) + 10_000_000;
            if (arr[no]) sb.append("1").append(" ");
            else sb.append("0").append(" ");
        }

        System.out.println(sb);
    }
}
