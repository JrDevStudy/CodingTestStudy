package 이현재;

import java.io.*;

public class BOJ_5597 {

    /**
     * 5597번: 과제 안 내신 분..? - 136ms
     * <pre>
     *     <b>[문제]</b>
     *     X대학 M교수님은 프로그래밍 수업을 맡고 있다.
     *     교실엔 학생이 30명이 있는데, 학생 명부엔 각 학생별로 1번부터 30번까지 출석번호가 붙어 있다.
     *     교수님이 내준 특별과제를 28명이 제출했는데, 그 중에서 제출 안 한 학생 2명의 출석번호를 구하는 프로그램을 작성하시오.
     *
     *     <b>[입력]</b>
     *     입력은 총 28줄로 각 제출자(학생)의 출석번호 n(1 ≤ n ≤ 30)가 한 줄에 하나씩 주어진다. 출석번호에 중복은 없다.
     *
     *     <b>[출력]</b>
     *     출력은 2줄이다. 1번째 줄엔 제출하지 않은 학생의 출석번호 중 가장 작은 것을 출력하고, 2번째 줄에선 그 다음 출석번호를 출력한다.
     * </pre>
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/5597">문제 보기</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[30];

        for (int i = 0; i < 28; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[n - 1] = n;
        }

        for (int i = 0; i < 30; i++) {
            if (arr[i] == 0) {
                bw.write((i + 1) + " ");
            }
        }

        bw.flush();
    }

    /**
     * System.out.println() 활용 - 140ms
     * @param args args
     * @throws IOException IOException
     */
    public static void other01(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] stu = new int[31];
        for (int i = 0; i < 28; i++) {
            stu[Integer.parseInt(br.readLine())] = 1;
        }
        for (int i = 1; i <= 30; i++) {
            if (stu[i] == 0) System.out.print(i + " ");
        }
    }

    /**
     * boolean 값 활용 - 124ms
     * @param args args
     * @throws IOException IOException
     */
    public static void other02(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] arr = new boolean[31];
        int temp;
        for (int i=0; i<28; i++) {
            temp = Integer.parseInt(br.readLine());
            arr[temp] = true;
        }
        for (int i=1; i<=30; i++) {
            if (!arr[i]) System.out.println(i);
        }
    }
}
