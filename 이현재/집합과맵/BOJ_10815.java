package 이현재.집합과맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_10815 {

    /**
     * 숫자 카드 - 732ms
     *
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/10815">문제 보기</a>
     */
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

    // HashSet 을 이용한 풀이 - 864ms
    public static void main01(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        String[] cards = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String card : cards) set.add(Integer.parseInt(card));
        for (String number : numbers) {
            if (set.contains(Integer.parseInt(number))) sb.append("1").append(" ");
            else sb.append("0").append(" ");
        }

        System.out.println(sb);
    }
}
