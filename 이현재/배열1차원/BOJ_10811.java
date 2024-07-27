package 이현재.배열1차원;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10811 {

    /**
     * 10811번: 바구니 뒤집기 - 152ms
     * <pre>
     *     <b>[문제]</b>
     *     도현이는 바구니를 총 N개 가지고 있고, 각각의 바구니에는 1번부터 N번까지 번호가 순서대로 적혀져 있다.
     *     바구니는 일렬로 놓여져 있고, 가장 왼쪽 바구니를 1번째 바구니, 그 다음 바구니를 2번째 바구니, ..., 가장 오른쪽 바구니를 N번째 바구니라고 부른다.
     *     도현이는 앞으로 M번 바구니의 순서를 역순으로 만들려고 한다.
     *     도현이는 한 번 순서를 역순으로 바꿀 때, 순서를 역순으로 만들 범위를 정하고, 그 범위에 들어있는 바구니의 순서를 역순으로 만든다.
     *     바구니의 순서를 어떻게 바꿀지 주어졌을 때, M번 바구니의 순서를 역순으로 만든 다음, 바구니에 적혀있는 번호를 가장 왼쪽 바구니부터 출력하는 프로그램을 작성하시오.
     *
     *     <b>[입력]</b>
     *     첫째 줄에 N (1 ≤ N ≤ 100)과 M (1 ≤ M ≤ 100)이 주어진다.
     *     둘째 줄부터 M개의 줄에는 바구니의 순서를 역순으로 만드는 방법이 주어진다.
     *     방법은 i j로 나타내고, 왼쪽으로부터 i번째 바구니부터 j번째 바구니의 순서를 역순으로 만든다는 뜻이다. (1 ≤ i ≤ j ≤ N)
     *     도현이는 입력으로 주어진 순서대로 바구니의 순서를 바꾼다.
     *
     *     <b>[출력]</b>
     *     모든 순서를 바꾼 다음에, 가장 왼쪽에 있는 바구니부터 바구니에 적혀있는 순서를 공백으로 구분해 출력한다.
     * </pre>
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/10811">문제 보기</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        Arrays.setAll(arr, i -> i + 1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j = Integer.parseInt(st.nextToken()) - 1;
            int k = Integer.parseInt(st.nextToken()) - 1;
            while (j < k) {
                int temp = arr[j];
                arr[j++] = arr[k];
                arr[k--] = temp;
            }
        }
        for (int a : arr) bw.write(a + " ");
        bw.flush();
    }

    public static void other(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = read();
        int[] lst = new int[n];
        for (int i = 0; i < n; i++) lst[i] = i + 1;
        int m = read();
        for (int j = 0; j < m; j++) {
            int a = read() - 1;
            int b = read() - 1;
            int cnt = (b - a + 1) / 2;
            for (int l = 0; l < cnt; l++) {
                int tmp = lst[a + l];
                lst[a + l] = lst[b - l];
                lst[b - l] = tmp;
            }
        }
        for (int k = 0; k < n; k++) sb.append(lst[k]).append(' ');
        System.out.print(sb);
    }

    /**
     * 비트 연산과 시프트 연산을 통한 입력 받기
     * @return 입력 받은 숫자
     * @throws IOException IOException
     */
    static int read() throws IOException{
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
