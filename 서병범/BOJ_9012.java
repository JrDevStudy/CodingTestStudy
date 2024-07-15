package 서병범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {

    /*
    괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다.
    그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다.
    한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다.
    만일 x 가 VPS 라면 이것을 하나의 괄호에 넣은 새로운 문자열 “(x)”도 VPS 가 된다.
    그리고 두 VPS x 와 y를 접합(concatenation)시킨 새로운 문자열 xy도 VPS 가 된다.

    예를 들어 “(())()”와 “((()))” 는 VPS 이지만 “(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다.

    여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다.

    @Input
         * 입력 데이터는 표준 입력을 사용한다.
         입력은 T개의 테스트 데이터로 주어진다.
         입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다.
         각 테스트 데이터의 첫째 줄에는 괄호 문자열이 한 줄에 주어진다.
         하나의 괄호 문자열의 길이는 2 이상 50 이하이다.
         * Example :
                    6
                    (())())
                    (((()())()
                    (()())((()))
                    ((()()(()))(((())))()
                    ()()()()(()()())()
                    (()((())()(
    @OutPut
         * 출력은 표준 출력을 사용한다. 만일 입력 괄호 문자열이 올바른 괄호 문자열(VPS)이면 “YES”, 아니면 “NO”를 한 줄에 하나씩 차례대로 출력해야 한다.
         * Example :
                    NO
                    NO
                    YES
                    NO
                    YES
                    NO

    @link https://www.acmicpc.net/problem/9012
    */

    public static void main(String[] args) throws IOException {
//        solution1();
        solution2();
    }


    /**
     * 메모리 : 14232 KB
     * 시간 : 108 ms
     * @throws IOException
     */
    public static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        // 각 테스트 케이스에 대해 올바른 괄호 문자열인지 확인
        for (int i = 0; i < T; i++) {
            String ps = br.readLine(); // 괄호 문자열 입력
            if (isValidParenthesisString(ps)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    /*
    괄호 문자열이 올바른지 확인하는 메서드
     */
    private static boolean isValidParenthesisString(String ps) {
        int balance = 0; // 괄호의 균형을 맞추기 위한 변수

        // 문자열의 각 문자를 순회하며 괄호의 균형을 확인
        for (char ch : ps.toCharArray()) {
            if (ch == '(') {
                balance++; // 여는 괄호일 경우 균형 증가
            } else {
                balance--; // 닫는 괄호일 경우 균형 감소
            }

            // 균형이 음수가 되면 닫는 괄호가 많은 경우이므로 올바르지 않음
            if (balance < 0) {
                return false;
            }
        }

        // 모든 괄호를 확인한 후 균형이 0이면 올바른 괄호 문자열
        return balance == 0;
    }



    /**
     * 백준 상위 등수 풀이
     * 메모리 : 11692 KB
     * 시간 : 68 ms
     *
     * Stack 자료구조를 사용
     * 여는 괄호 (를 쌓고, 닫는 괄호 )가 나왔을 때 스택에서 여는 괄호를 제거하여 균형을 맞추는 방식
     * @throws IOException
     */
    private static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스의 수
        int N = Integer.parseInt(br.readLine());

        // 각 테스트 케이스에 대해 반복
        for(int i = 0; i < N; i++) {
            // 각 테스트 케이스의 괄호 문자열을 입력받음
            String s = br.readLine();
            // 문자열이 VPS인지 확인하고 결과를 StringBuilder에 저장
            sb.append(solution(s)).append("\n");
        }

        // 모든 결과를 출력한다.
        System.out.println(sb);

    }



    // 주어진 문자열이 VPS인지 확인하는 메서드
    private static String solution(String s) {
        // Stack 자료구조를 사용하여 여는 괄호를 저장
        Stack<Character> stack = new Stack<>();

        // 문자열의 각 문자를 순회한다.
        for(int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            // 여는 괄호일 경우 스택에 추가
            if(c == '(') {
                stack.push(c);
            } else { // 닫는 괄호일 경우
                // 스택이 비어있으면 올바르지 않은 괄호 문자열이므로 "NO" 반환
                if(stack.isEmpty()) {
                    return "NO";
                }
                // 스택에서 여는 괄호를 제거하여 균형 맞춤
                stack.pop();
            }
        }

        // 모든 문자를 확인한 후 스택이 비어있으면 올바른 괄호 문자열이므로 "YES"를 반환하고, 그렇지 않으면 "NO"를 반환
        return stack.isEmpty() ? "YES" : "NO";
    }



}
