package 이현재.집합과맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_10816 {

    /**
     * 숫자 카드 2
     *
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/10816">문제 보기</a>
     */

    public static void main(String[] args) throws IOException {
        solution01(); // HashMap 풀이 - 964 ms
        solution02(); // 배열 풀이 - 816 ms
        solution03(); // 이분탐색 풀이 - 1340 ms
    }

    public static void solution01() throws IOException {
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

    public static void solution02() throws IOException {
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

    public static void solution03() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(upperBound(cards, target) - lowerBound(cards, target)).append(" ");
        }
        System.out.println(sb);
    }

    private static int lowerBound(int[] arr, int target) {
        int st = 0;
        int en = arr.length;

        while (st < en) {
            int mid = st + (en - st) / 2;
            if (arr[mid] < target) st = mid + 1;
            else en = mid;
        }

        return st;
    }

    private static int upperBound(int[] arr, int target) {
        int st = 0;
        int en = arr.length;

        while (st < en) {
            int mid = st + (en - st) / 2;
            if (target < arr[mid]) en = mid;
            else st = mid + 1;
        }

        return st;
    }
}
