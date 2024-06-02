package 서병범;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_2504 {

    /*
    4개의 기호 ‘(’, ‘)’, ‘[’, ‘]’를 이용해서 만들어지는 괄호열 중에서 올바른 괄호열이란 다음과 같이 정의된다.

    한 쌍의 괄호로만 이루어진 ‘()’와 ‘[]’는 올바른 괄호열이다.
    만일 X가 올바른 괄호열이면 ‘(X)’이나 ‘[X]’도 모두 올바른 괄호열이 된다.
    X와 Y 모두 올바른 괄호열이라면 이들을 결합한 XY도 올바른 괄호열이 된다.
    예를 들어 ‘(()[[]])’나 ‘(())[][]’ 는 올바른 괄호열이지만 ‘([)]’ 나 ‘(()()[]’ 은 모두 올바른 괄호열이 아니다. 우리는 어떤 올바른 괄호열 X에 대하여 그 괄호열의 값(괄호값)을 아래와 같이 정의하고 값(X)로 표시한다.

    ‘()’ 인 괄호열의 값은 2이다.
    ‘[]’ 인 괄호열의 값은 3이다.
    ‘(X)’ 의 괄호값은 2×값(X) 으로 계산된다.
    ‘[X]’ 의 괄호값은 3×값(X) 으로 계산된다.
    올바른 괄호열 X와 Y가 결합된 XY의 괄호값은 값(XY)= 값(X)+값(Y) 로 계산된다.
    예를 들어 ‘(()[[]])([])’ 의 괄호값을 구해보자. ‘()[[]]’ 의 괄호값이 2 + 3×3=11 이므로 ‘(()[[]])’의 괄호값은 2×11=22 이다. 그리고 ‘([])’의 값은 2×3=6 이므로 전체 괄호열의 값은 22 + 6 = 28 이다.

    여러분이 풀어야 할 문제는 주어진 괄호열을 읽고 그 괄호값을 앞에서 정의한대로 계산하여 출력하는 것이다.

    @Input
         * 첫째 줄에 괄호열을 나타내는 문자열(스트링)이 주어진다. 단 그 길이는 1 이상, 30 이하이다.
         * Example : (()[[]])([])
    @OutPut
         * 첫째 줄에 그 괄호열의 값을 나타내는 정수를 출력한다. 만일 입력이 올바르지 못한 괄호열이면 반드시 0을 출력해야 한다.
         * Example : 28

    @link https://www.acmicpc.net/problem/2504
    */

    public static void main(String[] args) throws IOException {
        //solution1
//        System.out.println(solution1());


        //solution2

        // 입력을 받기 위한 BufferedReader 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 문자열을 읽어 char 배열로 변환
        input = br.readLine().toCharArray();
        // 문제 해결 메서드 호출
        solve();
    }


    /*
    push(E item): 스택에 요소를 추가합니다.
    peek(): 스택의 맨 위에 있는 요소를 가져옵니다.
    pop(): 스택에서 맨 위에 있는 요소를 제거하고 그 값을 반환합니다.
    스택은 후입선출(LIFO, Last In First Out) 구조로 요소를 관리합니다.
     */
    public static int solution1() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Stack<Character> stack = new Stack<>(); // 괄호의 유효성을 검사할 스택
        int result = 0; // 최종 결과값
        int temp = 1; // 중간 계산값

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '(': // 여는 소괄호
                    stack.push(ch);
                    temp *= 2; // 값을 2로 곱함
                    break;
                case '[': // 여는 대괄호
                    stack.push(ch);
                    temp *= 3; // 값을 3으로 곱함
                    break;
                case ')': // 닫는 소괄호
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return 0; // 잘못된 괄호열이면 0 반환
                    }
                    if (input.charAt(i - 1) == '(') {
                        result += temp; // 올바른 괄호쌍이면 중간 값을 결과에 더함
                    }
                    stack.pop(); // 스택에서 여는 괄호 제거
                    temp /= 2; // 값을 2로 나눔
                    break;
                case ']': // 닫는 대괄호
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return 0; // 잘못된 괄호열이면 0 반환
                    }
                    if (input.charAt(i - 1) == '[') {
                        result += temp; // 올바른 괄호쌍이면 중간 값을 결과에 더함
                    }
                    stack.pop(); // 스택에서 여는 괄호 제거
                    temp /= 3; // 값을 3으로 나눔
                    break;
                default:
                    return 0; // 예상치 못한 문자가 있으면 0 반환
            }
        }

        if (!stack.isEmpty()) {
            return 0; // 스택이 비어있지 않으면 잘못된 괄호열
        }

        return result; // 최종 결과 반환
    }




    //solution2


    // 입력 문자열을 저장할 배열과 현재 인덱스를 나타내는 변수
    static char[] input;
    static int curIdx;

    // 메인 로직을 수행하는 메서드
    static void solve() {
        System.out.println(recursiveFunc(0)); // 결과 출력
    }

    // 재귀적으로 괄호 값을 계산하는 메서드
    static int recursiveFunc(int num) {
        int plusNum = 0; // 중간 계산 값을 저장할 변수
        int getRecNum = 0; // 재귀 호출 결과를 저장할 변수
        for (; curIdx < input.length; ) {
            char curChar = input[curIdx++]; // 현재 문자를 읽고 인덱스 증가
            if (curChar == '(') { // 여는 소괄호
                getRecNum = recursiveFunc(1); // 재귀 호출
                if (getRecNum == 0) return 0; // 잘못된 괄호열이면 0 반환
            } else if (curChar == ')') { // 닫는 소괄호
                if (num != 1) return 0; // 대응하는 여는 괄호가 없으면 0 반환
                else return plusNum == 0 ? 2 : 2 * plusNum; // 값 계산
            } else if (curChar == '[') { // 여는 대괄호
                getRecNum = recursiveFunc(2); // 재귀 호출
                if (getRecNum == 0) return 0; // 잘못된 괄호열이면 0 반환
            } else if (curChar == ']') { // 닫는 대괄호
                if (num != 2) return 0; // 대응하는 여는 괄호가 없으면 0 반환
                else return plusNum == 0 ? 3 : 3 * plusNum; // 값 계산
            }
            plusNum += getRecNum; // 중간 계산 값 더하기
        }
        if (num != 0) return 0; // 잘못된 괄호열이면 0 반환
        else return plusNum; // 최종 계산 값 반환
    }


    // 파일 입력을 테스트하기 위한 메서드 (사용되지 않음)
    private static BufferedReader getBufferedReader() throws IOException {
        System.out.println("===== input =====");
        String fileName = "input/input1.txt";
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        BufferedReader br2 = new BufferedReader(new FileReader(fileName));
        String s;
        while ((s = br2.readLine()) != null) {
            System.out.println(s);
        }
        System.out.println("===== output =====");
        return br;
    }


}
