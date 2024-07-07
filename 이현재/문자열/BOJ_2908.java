package 이현재.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2908 {

    /**
     * 2908번: 상수 - 144ms
     * <pre>
     *     <b>[문제]</b>
     *     상근이의 동생 상수는 수학을 정말 못한다.
     *     상수는 숫자를 읽는데 문제가 있다.
     *     이렇게 수학을 못하는 상수를 위해서 상근이는 수의 크기를 비교하는 문제를 내주었다.
     *     상근이는 세 자리 수 두 개를 칠판에 써주었다. 그 다음에 크기가 큰 수를 말해보라고 했다.
     *     상수는 수를 다른 사람과 다르게 거꾸로 읽는다.
     *     예를 들어, 734와 893을 칠판에 적었다면, 상수는 이 수를 437과 398로 읽는다.
     *     따라서, 상수는 두 수중 큰 수인 437을 큰 수라고 말할 것이다.
     *     두 수가 주어졌을 때, 상수의 대답을 출력하는 프로그램을 작성하시오.
     *
     *     <b>[입력]</b>
     *     첫째 줄에 상근이가 칠판에 적은 두 수 A와 B가 주어진다.
     *     두 수는 같지 않은 세 자리 수이며, 0이 포함되어 있지 않다.
     *
     *     <b>[출력]</b>
     *     첫째 줄에 상수의 대답을 출력한다.
     * </pre>
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/2908">문제 보기</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int result = 0;
        for (int i = 0; i < 2; i++) {
            String s = st.nextToken();
            // 문자열을 먼저 문자 타입에 더해야 한다. 문자 간의 덧셈을 먼저하게 되면 ASCII 코드 값을 더하는 연산이 먼저 일어난다.
            String rev = "" + s.charAt(2) + s.charAt(1) + s.charAt(0);
            int j = Integer.parseInt(rev);
            if(result == 0) {
                result = j;
            } else {
                System.out.println(Math.max(result, j));
            }
        }
    }

    /**
     * buffer 를 사용하지 않는 원시 입력 형태의 풀이 - 104ms
     * @param args args
     * @throws IOException IOException
     */
    public static void other(String[] args) throws IOException {
        int A=0;
        int B=0;

        A+=System.in.read()-48;
        A+=(System.in.read()-48)*10;
        A+=(System.in.read()-48)*100;

        System.in.read();

        B+=System.in.read()-48;
        B+=(System.in.read()-48)*10;
        B+=(System.in.read()-48)*100;

        System.out.println(Math.max(A, B));
    }
}
