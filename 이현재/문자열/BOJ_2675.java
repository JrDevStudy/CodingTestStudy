package 이현재.문자열;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2675 {

    /**
     * 2675번: 문자열 반복 - 152ms, O(t * (n + m * r))
     * <pre>
     *     <b>[문제]</b>
     *     문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
     *     즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다.
     *     S에는 QR Code "alphanumeric" 문자만 들어있다.
     *     QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.
     *
     *     <b>[입력]</b>
     *     첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다.
     *     각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다.
     *     S의 길이는 적어도 1이며, 20글자를 넘지 않는다.
     *
     *     <b>[출력]</b>
     *     각 테스트 케이스에 대해 P를 출력한다.
     * </pre>
     *
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/2675">문제 보기</a>
     */
    public static void main00(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] line = br.readLine().split(" ");
            int r = Integer.parseInt(line[0]);
            char[] s = line[1].toCharArray();
            for (char c : s) {
                for (int o = 0; o < r; o++) {
                    System.out.print(c);
                }
            }
            System.out.println();
        }
    }

    /**
     * StringTokenizer 사용 - 128ms
     * <pre>
     *     시간 단축
     * </pre>
     * @param args args
     * @throws IOException IOException
     */
    public static void other01(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            for(int j=0; j<s.length(); j++) {
                for(int k=0; k<M; k++) {
                    sb.append(s.charAt(j));
                }
            }
            System.out.println(sb);
        }
    }

    /**
     * StringTokenizer + BufferedWriter 추가 - 116ms
     * <pre>
     *     StringTokenizer 로직에서 -8ms 단축
     * </pre>
     * @param args args
     * @throws IOException IOException
     */
    public static void other02(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            for(int j=0; j<s.length(); j++) {
                for(int k=0; k<M; k++) {
                    bw.write(s.charAt(j));
                }
            }
            bw.write('\n');
            bw.flush();
        }
    }
}
