package 서병범;

import java.io.*;

public class BOJ_17478 {

    /*
    평소에 질문을 잘 받아주기로 유명한 중앙대학교의 JH 교수님은 학생들로부터 재귀함수가 무엇인지에 대하여 많은 질문을 받아왔다.

    매번 질문을 잘 받아주셨던 JH 교수님이지만 그는 중앙대학교가 자신과 맞는가에 대한 고민을 항상 해왔다.

    중앙대학교와 자신의 길이 맞지 않다고 생각한 JH 교수님은 결국 중앙대학교를 떠나기로 결정하였다.

    떠나기 전까지도 제자들을 생각하셨던 JH 교수님은 재귀함수가 무엇인지 물어보는 학생들을 위한 작은 선물로 자동 응답 챗봇을 준비하기로 했다.

    JH 교수님이 만들 챗봇의 응답을 출력하는 프로그램을 만들어보자.

    @Input
         * 교수님이 출력을 원하는 재귀 횟수 N(1 ≤ N ≤ 50)이 주어진다.
         * Example : 2

    @OutPut
         * 출력 예시를 보고 재귀 횟수에 따른 챗봇의 응답을 출력한다.
         * Example :
        어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.
        "재귀함수가 뭔가요?"
        "잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
        마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
        그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
        ____"재귀함수가 뭔가요?"
        ____"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
        ____마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
        ____그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
        ________"재귀함수가 뭔가요?"
        ________"재귀함수는 자기 자신을 호출하는 함수라네"
        ________라고 답변하였지.
        ____라고 답변하였지.
        라고 답변하였지.

    @link https://www.acmicpc.net/problem/17478
    */



    public static void main(String[] args) throws IOException {
//        solution1();

        solution2();
    }





    // 결과 출력을 위한 StringBuilder
    static StringBuilder sb = new StringBuilder();

    /*
    N을 입력받고 재귀 메서드(recursion())를 호출
    메모리 : 14900 KB
    시간 : 140 ms
     */
    private static void solution1() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 입력된 재귀 횟수 N을 정수로 변환하여 저장
        recursion(N, 0); // 재귀 메서드 호출, 초기 재귀 깊이 count는 0으로 설정

        System.out.println(sb.toString());

    }

    /**
     * 재귀적으로 질문과 답변을 출력하는 메서드
     * @param n : 남은 재귀 호출 횟수
     * @param count : 현재 재귀 깊이
     */
    private static void recursion(int n, int count) {
        if (n < 0) return; // 기저 조건: n이 0보다 작으면 재귀 종료

        // 재귀 깊이가 0일 때만 첫 번째 질문 출력
        if (count == 0) sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");

        // 현재 재귀 깊이에 따라 앞에 언더바(_)를 추가
        for (int i = 0; i < 4 * count; i++) {
            sb.append("_");
        }
        sb.append("\"재귀함수가 뭔가요?\"\n"); // 질문 출력

        if (n != 0) {
            // 재귀 깊이가 0이 아닐 때, 추가적인 이야기 출력
            for (int i = 0; i < 4 * count; i++) {
                sb.append("_");
            }
            sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
            for (int i = 0; i < 4 * count; i++) {
                sb.append("_");
            }
            sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
            for (int i = 0; i < 4 * count; i++) {
                sb.append("_");
            }
            sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
        }

        recursion(n - 1, count + 1); // 재귀 호출, 남은 횟수를 줄이고 깊이를 증가시킴

        if (n == 0) {
            // 기저 조건에 도달했을 때, 재귀함수의 정의 출력
            for (int i = 0; i < 4 * count; i++) {
                sb.append("_");
            }
            sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
        }

        // 각 재귀 깊이에 따른 답변 종료 출력
        for (int i = 0; i < 4 * count; i++) {
            sb.append("_");
        }
        sb.append("라고 답변하였지.\n");
    }


    /**
     * 출력 스트림을 위한 BufferedWriter
     * 할당된 버퍼에 값 넣어주기
     */
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 스트림을 위한 BufferedReader
    static String ub = ""; // 재귀 깊이에 따라 언더바(_)
    static int n; // 재귀 횟수

    /*
    N을 입력받고 재귀 메서드(recursion2())를 호출
    메모리 : 14900 KB
    시간 : 140 ms
     */
    private static void solution2() throws IOException {
        n = Integer.parseInt(br.readLine()); // 입력된 재귀 횟수 N을 정수로 변환하여 저장
        bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n"); // 초기 질문 출력

        recursion2(0); // 재귀 메서드 호출, 초기 재귀 깊이 cnt는 0으로 설정
        bw.close(); // BufferedWriter 스트림을 닫아 출력 내용을 완료

    }

    /**
     * 재귀적으로 질문과 답변을 출력하는 메서드
     * @param cnt: 현재 재귀 깊이
     */
    public static void recursion2(int cnt) throws IOException {
        String tmp = ub; // 현재 재귀 깊이에 따른 언더바 저장
        if (cnt == n) { // 기저 조건: 현재 깊이가 입력된 깊이와 같다면
            bw.write(tmp + "\"재귀함수가 뭔가요?\"\n"); // 질문 -저장
            bw.write(tmp + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n"); // 재귀함수 정의 -저장
            bw.write(tmp + "라고 답변하였지.\n"); // 답변 종료 문구 -저장
            return; // 재귀 종료
        }

        // 재귀 깊이가 기저 조건에 도달하지 않았을 때 이야기 -저장
        bw.write(tmp + "\"재귀함수가 뭔가요?\"\n");
        bw.write(tmp + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
        bw.write(tmp + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
        bw.write(tmp + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");

        ub += "____"; // 재귀 깊이를 나타내는 언더바를 4개 추가
        recursion2(cnt + 1); // 재귀 호출, 깊이를 증가시킴
        bw.write(tmp + "라고 답변하였지.\n"); // 각 재귀 깊이에 따른 답변 종료 -저장
    }

    /*
        BufferedWriter:
         - 출력 성능 향상을 위한 버퍼링된 문자 출력 스트림
         - 데이터를 버퍼에 저장하고, 버퍼가 가득 차거나 스트림이 닫힐 때 한 번에 출력
         - 버퍼를 잡아 놓았기 때문에 반드시 flush() / close() 를 반드시 호출해 주어 뒤처리를 해주어야 한다.
         - bw.write(s+"\n"); : 버퍼에 출력문 저장 (System.out.println();과 같이 자동개행기능이 없기때문에 개행을 해주어야할 경우에는 \n(또는 newLine())를 통해 따로 처리해주어야 한다.)
         - bw.flush(); : 버퍼안에 저장되어 있는 모든 문자열을 출력.(버퍼가 다 찬 경우에는 자동으로 호출)
         - bw.close(); : 스트림을 닫음

        OutputStreamWriter:
         - OutputStreamWriter는 바이트 출력 스트림을 문자 출력 스트림으로 변환하는 어댑터 클래스
         - 이를 통해 바이트 스트림(예: FileOutputStream)을 문자 스트림으로 변환할 수 있다.
         - 주로 UTF-8 등의 문자 인코딩을 지정할 때 사용된다.
    */



}


