package 정유성;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {
    /*
        괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다.
        그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다.
        한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다. 만일 x 가 VPS 라면 이것을 하나의 괄호에 넣은
        새로운 문자열 “(x)”도 VPS 가 된다. 그리고 두 VPS x 와 y를 접합(concatenation)시킨 새로운 문자열 xy도 VPS 가 된다.
        예를 들어 “(())()”와 “((()))” 는 VPS 이지만 “(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다.
        여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다.

        @Input
            * 입력 데이터는 표준 입력을 사용한다. 입력은 T개의 테스트 데이터로 주어진다. 입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다.
              각 테스트 데이터의 첫째 줄에는 괄호 문자열이 한 줄에 주어진다. 하나의 괄호 문자열의 길이는 2 이상 50 이하이다.
            * Example : 6
                        (())())
                        (((()())()
                        (()())((()))
                        ((()()(()))(((())))()
                        ()()()()(()()())()
                        (()((())()(
        @OutPut
            * 출력은 표준 출력을 사용한다. 만일 입력 괄호 문자열이 올바른 괄호 문자열(VPS)이면
              “YES”, 아니면 “NO”를 한 줄에 하나씩 차례대로 출력해야 한다.
            * Example : NO
                        NO
                        YES
                        NO
                        YES
                        NO
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader를 사용하여 입력을 받기
        StringBuilder sb = new StringBuilder(); // 문자열로 결합하기 위해 사용
        int n = Integer.parseInt(br.readLine()); // n은 테스트 케이스 수

        for (int i = 0; i < n; i++) { // n만큼 반복문을 실행하여 각 테스트 케이스에 대해 checkVps 함수를 호출
            sb.append(checkVps(br.readLine())).append('\n');
        }

        System.out.println(sb); // 모든 테스트 케이스의 결과를 한 번에 출력
    }

    public static String checkVps(String str) {
        boolean isVps = true;
        Stack<Character> stack = new Stack<>(); // Stack<Character> -> 괄호의 짝을 맞추기 위해 사용

        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c); // '('를 만나면 스택에 push
            } else if (stack.isEmpty()) {
                isVps = false; // 스택이 비어있으면 VPS가 아니므로 isVps를 false로 설정하고 반복문을 종료
                break;
            } else {
                stack.pop(); // ')'를 만나면 스택이 비어있지 않으면 스택에서 pop
            }
        }
        if (isVps && stack.isEmpty()) {
            return "YES"; // 반복문이 끝난 후, isVps가 true이고 스택이 비어있으면 올바른 괄호 문자열이므로 "YES"를 반환
        } else {
            return "NO";
        }
    }
}
