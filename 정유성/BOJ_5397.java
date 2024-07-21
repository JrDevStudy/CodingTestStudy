package 정유성;

import java.io.InputStreamReader;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;

public class BOJ_5397 {
    /*
        창영이는 강산이의 비밀번호를 훔치기 위해서 강산이가 사용하는 컴퓨터에 키로거를 설치했다.
        며칠을 기다린 끝에 창영이는 강산이가 비밀번호 창에 입력하는 글자를 얻어냈다.
        키로거는 사용자가 키보드를 누른 명령을 모두 기록한다. 따라서, 강산이가 비밀번호를 입력할 때,
        화살표나 백스페이스를 입력해도 정확한 비밀번호를 알아낼 수 있다.
        강산이가 비밀번호 창에서 입력한 키가 주어졌을 때, 강산이의 비밀번호를 알아내는 프로그램을 작성하시오.
        강산이는 키보드로 입력한 키는 알파벳 대문자, 소문자, 숫자, 백스페이스, 화살표이다.

        @Input
            * 첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한줄로 이루어져 있고, 강산이가 입력한 순서대로 길이가 L인 문자열이 주어진다.
            (1 ≤ L ≤ 1,000,000) 강산이가 백스페이스를 입력했다면, '-'가 주어진다. 이때 커서의 바로 앞에 글자가 존재한다면, 그 글자를 지운다.
            화살표의 입력은 '<'와 '>'로 주어진다. 이때는 커서의 위치를 움직일 수 있다면, 왼쪽 또는 오른쪽으로 1만큼 움직인다. 나머지 문자는 비밀번호의 일부이다.
            물론, 나중에 백스페이스를 통해서 지울 수는 있다. 만약 커서의 위치가 줄의 마지막이 아니라면, 커서 및 커서 오른쪽에 있는 모든 문자는 오른쪽으로 한 칸 이동한다.
            * Example : 2
                        <<BP<A>>Cd-
                        ThIsIsS3Cr3t
        @OutPut
            * 각 테스트 케이스에 대해서, 강산이의 비밀번호를 출력한다. 비밀번호의 길이는 항상 0보다 크다.
            * Example : BAPC
                        ThIsIsS3Cr3t
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 첫 번째 입력 줄을 읽어 int로 변환하여 테스트 케이스의 수 T에 저장
        String pwd; // 이후 사용할 문자열 변수 pwd를 선언

        for (int t = 0; t < T; t++) {
            pwd = br.readLine(); // 각 테스트 케이스마다 한 줄을 읽어 pwd에 저장

            String password = getPwd(pwd); // 읽어들인 문자열 pwd를 getPwd 메서드에 전달하여 결과 문자열을 반환받아 password에 저장
            System.out.println(password);
        }
    }

    // 문자열을 입력받아 처리 후 결과 문자열을 반환하는 메서드
    public static String getPwd(String pwd) {
        StringBuilder sb = new StringBuilder(); // 결과 문자열을 효율적으로 생성하기 위해 StringBuilder를 사용
        Stack<Character> pre = new Stack<>(); // 커서 앞의 문자들을 저장하는 스택
        Stack<Character> post = new Stack<>(); // 커서 뒤의 문자들을 저장하는 스택

        for (int i = 0; i < pwd.length(); i++) {
            switch (pwd.charAt(i)) { // 현재 문자를 검사
                case '<': // '<' 문자인 경우, 커서를 왼쪽으로 이동
                    if (!pre.isEmpty()) post.push(pre.pop());
                    break;
                case '>': // '>' 문자인 경우, 커서를 오른쪽으로 이동
                    if (!post.isEmpty()) pre.push(post.pop());
                    break;
                case '-': // '-' 문자인 경우, 커서 왼쪽의 문자를 삭제
                    if (!pre.isEmpty()) pre.pop();
                    break;
                default: // 다른 문자일 경우, 해당 문자를 pre 스택에 추가
                    pre.push(pwd.charAt(i));
                    break;
            }
        }
        // post 스택에 남아 있는 모든 문자를 pre 스택으로 옮김
        while (!post.isEmpty()) {
            pre.push(post.pop());
        }
        // pre 스택의 모든 문자를 StringBuilder에 추가
        for (int i = 0; i < pre.size(); i++) {
            sb.append(pre.elementAt(i));
        }
        return sb.toString(); // 최종적으로 생성된 문자열을 반환
    }
}