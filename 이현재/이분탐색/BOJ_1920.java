package 이현재.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ_1920 {

    /**
     * 수 찾기
     * <pre>
     *     <b>[문제]</b>
     *     숫자 카드는 정수 하나가 적혀져 있는 카드이다.
     *     상근이는 숫자 카드 N개를 가지고 있다.
     *     정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.
     *
     *     <b>[입력]</b>
     *     첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다.
     *     둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다.
     *     숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
     *     셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다.
     *     넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다.
     *     이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
     *
     *     <b>[출력]</b>
     *     첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력한다.
     * </pre>
     *
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/1920">문제 보기</a>
     */
    public static void main(String[] args) throws IOException {
        solution01(); // 624 ms
        solution02(); // 648 ms (Collections.binarySearch 메서드 활용)
    }

    public static void solution01() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        int m = Integer.parseInt(br.readLine());
        String[] str1 = br.readLine().split(" ");
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int t = Integer.parseInt(str1[i]);
            int start = 0;
            int end = arr.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (arr[mid] == t) {
                    sb.append(1).append('\n');
                    break;
                }
                if (arr[mid] < t) start = mid + 1;
                if (arr[mid] > t) end = mid - 1;
            }
            if (start > end) sb.append(0).append('\n');
        }
        System.out.println(sb);
    }

    public static void solution02() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(str[i]));
        }
        Collections.sort(list);
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String[] str1 = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int t = Integer.parseInt(str1[i]);
            if (Collections.binarySearch(list, t) < 0) sb.append(0).append('\n');
            else sb.append(1).append('\n');
        }
        System.out.println(sb);
    }
}
