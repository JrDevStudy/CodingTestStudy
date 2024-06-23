package 이현재;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11720 {

    /**
     * 11720번: 숫자의 합 - 124ms
     * <pre>
     *     <b>[문제]</b>
     *     N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
     *
     *     <b>[입력]</b>
     *     첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.
     *
     *     <b>[출력]</b>
     *     입력으로 주어진 숫자 N개의 합을 출력한다.
     *     고려사항 : long type 범위를 넘어가는 숫자가 들어오는 경우
     * </pre>
     *
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/11720">문제 보기</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine(); // 둘째 줄에 입력되는 숫자 N개를 char 배열로 할당 받기 때문에 첫째 줄에 입력 되는 숫자의 개수는 배열의 길이와 같아서 활용 하지 않는다.
        char[] str = br.readLine().toCharArray();
        int result = 0;
        for (char c : str) {
            result += Integer.parseInt(String.valueOf(c));
        }
        System.out.println(result);
    }

    /**
     * '0' 아스키 코드 값을 빼서 숫자형으로 변환 후 더하기 - 128ms
     * @param args args
     * @throws IOException IOException
     */
    public static void other(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int ans = 0;
        for(int i = 0; i < N; i++) {
            ans += str.charAt(i) - '0'; // 문자 '0'의 아스키 코드 값은 48, '1'(49) - '0'(48) -> 1 숫자형 변환
        }
        System.out.println(ans);
    }
}
