package 이현재.집합과맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_10816 {

    /**
     * 숫자 카드 2 - 964ms
     *
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/10816">문제 보기</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        String n = br.readLine();
        String[] cards = br.readLine().split(" ");
        for (String card : cards) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }
        String m = br.readLine();
        String[] numbers = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if (map.containsKey(number)) sb.append(map.get(number)).append(" ");
            else sb.append(0).append(" ");
        }

        System.out.println(sb);
    }

    // 배열을 활용한 풀이 - 816ms
    public static void main01(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[20_000_001];
        int n = Integer.parseInt(br.readLine());
        String[] cards = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(cards[i]) + 10_000_000]++;
        }
        int m = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            sb.append(arr[Integer.parseInt(numbers[i]) + 10_000_000]).append(" ");
        }
        System.out.println(sb);
    }
}
