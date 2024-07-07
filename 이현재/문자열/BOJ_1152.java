package 이현재.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1152 {

    /**
     * 1152번: 단어의 개수 - 288ms
     * <pre>
     *     <b>[문제]</b>
     *     영어 대소문자와 공백으로 이루어진 문자열이 주어진다.
     *     이 문자열에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오.
     *     단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.
     *
     *     <b>[입력]</b>
     *     첫 줄에 영어 대소문자와 공백으로 이루어진 문자열이 주어진다.
     *     이 문자열의 길이는 1,000,000을 넘지 않는다.
     *     단어는 공백 한 개로 구분되며, 공백이 연속해서 나오는 경우는 없다.
     *     또한 문자열은 공백으로 시작하거나 끝날 수 있다.
     *
     *     <b>[출력]</b>
     *     첫째 줄에 단어의 개수를 출력한다.
     * </pre>
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/1152">문제 보기</a>
     */
    public static void main00(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 받은 문자의 앞 뒤 공백을 없애고 " " 을 기준으로 잘라낸 배열 생성
        String[] arr = br.readLine().trim().split(" ");
        // 앞 뒤 공백이 아닌 문자열 내에 공백이 2개 이상인 경우(ex.hello  world), 2를 반환해야 하지만 3을 반환
        long result = Arrays.stream(arr).filter(s -> !s.isEmpty()).count();
        System.out.println(result);
    }

    /**
     * split 이 아닌 StringTokenizer 를 활용한 풀이 - 244ms
     * <pre>
     *     split 과 StringTokenizer 의 차이
     *     split 은 빈 문자열도 배열에 포함, String 클래스에 포함된 메서드로 정규표현식으로 구분
     *     StringTokenizer 는 java.util 에 포함된 클래스, 문자 또는 문자열로 구분하고 빈 문자열을 토큰으로 인식하지 않는다.
     *     또한 결과 값이 문자열 배열인 split과 다르게 문자열이다.
     * </pre>
     * @param args args
     * @throws IOException IOException
     */
    public static void main01(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        System.out.println(st.countTokens());
    }

    /**
     * buffer 를 사용하지 않는 원시 입력 형태의 풀이 - 128ms
     * @param args args
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {
        int count = 0;
        int preStr = 32;
        int str;

        while (true) {
            // 입력 스트림에서 다음 바이트의 데이터를 읽고 정수형으로 반환(문자의 ASCII 값)
            str = System.in.read();

            // 입력 받은 문자가 공백일 경우(공백 문자 ASCII 값 : 32)
            if (str == 32) {
                // 이전의 문자가 공백이 아니면
                if (preStr != 32) count++;
            } else if (str == 10) { // 입력 받은 문자가 개행일 때('\n', ASCII 값 : 10)
                if (preStr != 32) count++;
                break;
            }
            preStr = str;
        }

        System.out.println(count);
    }
}
