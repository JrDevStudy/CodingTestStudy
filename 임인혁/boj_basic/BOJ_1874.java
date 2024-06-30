package 임인혁.boj_basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1874 {

    /*
        스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다.
        스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.
        1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어 놓음으로써, 하나의 수열을 만들 수 있다.
        이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.
        임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다.
        이를 계산하는 프로그램을 작성하라.
        @Input
            * 첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다.
              둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 물론 같은 정수가 두 번 나오는 일은 없다.
            * Example : 8 \n 4 \n 3 \n 6 \n 8 \n 7 \n 5 \n 2 \n 1
        @OutPut
            * 입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다.
              push 연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.
            * Example : + \n + \n + \n + \n - \n - \n + \n + \n - \n + \n + \n - \n - \n - \n - \n -
        @시간 제한
            * 2s
        @메모리 제한
            * 128 MB
    */
    public static void main(String[] args) {
        try {
            solution_1();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
        @Desc : Stack을 사용한 문제 풀이
            * Memory Usage : 32000 KB
            * Time Usage : 416 ms
        @수도 코드
        1. sudo code
            1-1. N (수열의 길이), M(수열)
            1-2. for (N만큼 반복)
                {
                    수열 저장하기
                }
            1-3. 수열에서 하나씩 꺼낸 후 stack 알고리즘 수행
                {
                    int i = 0;
                    if (M[i] > i) {
                        continue;
                    }
                    if (M[i] > i) {
                        스택에 push , bw.write("+")
                    }
                    if (M[i] < i) {
                        스택에서 pop , bw.write("-")
                    }
                }
    */
    private static void solution_1() throws IOException {
        // 1. stream 변수 정의
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 2. N (수열의 길이), M(수열) 할당하기
        int n = Integer.parseInt(br.readLine());
        int[] m = new int[n];
        for (int i = 0; i < m.length; i++) {
            st = new StringTokenizer(br.readLine());
            m[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        // 3. Stack 알고리즘 수행
        int num = 1;
        boolean isSuccess = true;
        for (int i = 0; i < m.length; i++) {
            int arg = m[i];
            if (arg >= num) {  // 3-1. 수열의 값이 오름차순 증가하는 수 보다 크거나 같으면
                // 3-2. Stack에 오름차순 증가하는 수를 할당
                while (arg >= num) {
                    stack.push(num);
                    num++;
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {    // 3-3. 수열의 값이 오름차순 증가하는 수 보다 작거나 같으면
                // 3-4. stack에서 꺼낸다.
                if (stack.isEmpty() || stack.peek() != arg) {
                    isSuccess = false;
                    sb.append("NO\n");
                    break;
                } else {
                    stack.pop();
                    sb.append("-\n");
                }
            }
        }

        if (isSuccess) {
            bw.write(sb.toString());
        } else {
            bw.write("NO\n");
        }
        bw.flush();
        bw.close();
    }
}
