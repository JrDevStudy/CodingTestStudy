package 이현재.배열1차원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1546 {

    /**
     * 1546번: 평균 - 156ms
     * <pre>
     *     <b>[문제]</b>
     *     세준이는 기말고사를 망쳤다. 세준이는 점수를 조작해서 집에 가져가기로 했다.
     *     일단 세준이는 자기 점수 중에 최댓값을 골랐다.
     *     이 값을 M이라고 한다. 그리고 나서 모든 점수를 점수/M*100으로 고쳤다.
     *     예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면
     *     수학점수는 50/70*100이 되어 71.43점이 된다.
     *     세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.
     *
     *     <b>[입력]</b>
     *     첫째 줄에 시험 본 과목의 개수 N이 주어진다.
     *     이 값은 1000보다 작거나 같다. 둘째 줄에 세준이의 현재 성적이 주어진다.
     *     이 값은 100보다 작거나 같은 음이 아닌 정수이고, 적어도 하나의 값은 0보다 크다.
     *
     *     <b>[출력]</b>
     *     첫째 줄에 새로운 평균을 출력한다. 실제 정답과 출력값의
     *     절대오차 또는 상대오차가 10-2 이하이면 정답이다.
     * </pre>
     *
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/1546">문제 보기</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        double max = Arrays.stream(arr).mapToDouble(Double::parseDouble).max().orElseThrow();
        double sum = Arrays.stream(arr).mapToDouble(s -> Double.parseDouble(s) / max * 100).sum();
        System.out.println(sum / n);
    }

    /**
     * 점수 합산을 먼저 하고 계산하기 - 108ms
     * @param args args
     * @throws IOException IOException
     */
    public static void other(String[] args) throws IOException {
        int n = readInt();
        int maxScore = 0;
        int totalScore = 0;
        for (int i = 0; i < n; ++i) {
            int score = readInt();
            totalScore += score;
            maxScore = Math.max(maxScore, score);
        }
        System.out.println(100.0d * totalScore / maxScore / n);
    }

    static int readInt() throws IOException {
        int retValue = 0;
        boolean negative = false;
        while (true) {
            int i = System.in.read(); // 읽어온 문자의 ASCII 값 저장
            if (i == '\r') continue; // 캐리지 리턴 문자 : windows 시스템에서 발생함
            if (i == ' ' || i == '\n') {
                break;
            } else {
                if (i == '-') negative = true;
                else { // 입력 문자가 숫자라면 문자 '0'의 ASCII 값을 빼서 실제 숫자 값을 얻는다.
                    retValue = retValue * 10 + i - '0'; // 자릿수 추가, 10의 자리
                }
            }
        }
        return negative ? -1 * retValue : retValue;
    }

    /**
     * readInt 메서드 개선
     * @return 읽어온 숫자 값
     * @throws IOException IOException
     */
    public static int readInt00() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int retValue = 0;
        boolean negative = false;
        int i = reader.read();

        // 공백 문자 무시
        while (i == ' ' || i == '\r' || i == '\n') {
            i = reader.read();
        }

        if (i == -1) {
            throw new IOException("No input provided");
        }

        // 음수 처리
        if (i == '-') {
            negative = true;
            i = reader.read();
        }

        // 숫자 읽기 및 처리
        while (i != -1 && i != ' ' && i != '\n') {
            if (i < '0' || i > '9') {
                throw new NumberFormatException("Invalid character in input");
            }
            retValue = retValue * 10 + i - '0';
            i = reader.read();
        }

        return negative ? -retValue : retValue;
    }
}
