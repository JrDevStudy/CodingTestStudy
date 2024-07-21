package 정유성;

import java.io.*;
import java.util.Stack;

public class BOJ_3986 {
    /*
        이번 계절학기에 심리학 개론을 수강 중인 평석이는 오늘 자정까지 보고서를 제출해야 한다.
        보고서 작성이 너무 지루했던 평석이는 노트북에 엎드려서 꾸벅꾸벅 졸다가 제출 마감 1시간 전에 깨고 말았다.
        안타깝게도 자는 동안 키보드가 잘못 눌려서 보고서의 모든 글자가 A와 B로 바뀌어 버렸다!
        그래서 평석이는 보고서 작성을 때려치우고 보고서에서 '좋은 단어'나 세보기로 마음 먹었다.
        평석이는 단어 위로 아치형 곡선을 그어 같은 글자끼리(A는 A끼리, B는 B끼리) 쌍을 짓기로 하였다.
        만약 선끼리 교차하지 않으면서 각 글자를 정확히 한 개의 다른 위치에 있는 같은 글자와 짝 지을수 있다면,
        그 단어는 '좋은 단어'이다. 평석이가 '좋은 단어' 개수를 세는 것을 도와주자.

        @Input
            * 첫째 줄에 단어의 수 N이 주어진다. (1 ≤ N ≤ 100)
              다음 N개 줄에는 A와 B로만 이루어진 단어가 한 줄에 하나씩 주어진다.
              단어의 길이는 2와 100,000사이이며, 모든 단어 길이의 합은 1,000,000을 넘지 않는다.
            * Example : 3
                        ABAB
                        AABB
                        ABBA
        @OutPut
            * 첫째 줄에 좋은 단어의 수를 출력한다.
            * Example : 2
     */

    public static void main(String[] args) throws IOException {
        // 표준 입력을 읽기 위해 BufferedReader를 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); // 첫 번째 입력 줄을 읽어 int로 변환하여 문자열의 수 n에 저장

        int cnt=0; // 조건을 만족하는 문자열의 개수를 저장할 변수 cnt를 초기화

        for(int i=0; i<n; i++) {
            String s = br.readLine(); // 각 문자열을 입력받아 s에 저장
            Stack<Character> stack=new Stack<>(); // 각 문자열을 처리하기 위한 스택을 생성
            for (int j = 0; j < s.length(); j++) { // 현재 문자열 s의 각 문자를 순회
                char c = s.charAt(j); // 현재 문자를 c에 저장
                if(stack.isEmpty()){ // 스택이 비어있는지 확인
                    stack.push(s.charAt(j)); // 스택이 비어있으면 현재 문자를 스택에 추가
                }
                else if (stack.peek() == c) { // 스택의 최상위 문자와 현재 문자가 같은지 확인
                    stack.pop(); // 스택의 최상위 문자가 현재 문자와 같으면 스택에서 최상위 문자를 제거
                } else {
                    stack.push(s.charAt(j)); // 현재 문자를 스택에 추가
                }
            }
            // 문자열 처리가 끝난 후 스택이 비어있는지 확인
            // 스택이 비어있다면 모든 문자가 짝을 이루었으므로 cnt를 증가시킴
            if(stack.isEmpty()) cnt++;
        }
        System.out.println(cnt); // 문자열 개수 출력

    }
}