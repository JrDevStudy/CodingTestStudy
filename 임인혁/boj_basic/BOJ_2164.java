package 임인혁.boj_basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2164 {

    /*
        N장의 카드가 있다. 각각의 카드는 차례로 1부터 N까지의 번호가 붙어 있으며, 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.
        이제 다음과 같은 동작을 카드가 한 장 남을 때까지 반복하게 된다. 우선, 제일 위에 있는 카드를 바닥에 버린다.
        그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
        예를 들어 N=4인 경우를 생각해 보자. 카드는 제일 위에서부터 1234 의 순서로 놓여있다. 1을 버리면 234가 남는다.
        여기서 2를 제일 아래로 옮기면 342가 된다. 3을 버리면 42가 되고, 4를 밑으로 옮기면 24가 된다. 마지막으로 2를 버리고 나면, 남는 카드는 4가 된다.
        N이 주어졌을 때, 제일 마지막에 남게 되는 카드를 구하는 프로그램을 작성하시오.
        @Input
            * 첫째 줄에 정수 N(1 ≤ N ≤ 500,000)이 주어진다.
            * Example : 6
        @OutPut
            * 첫째 줄에 남게 되는 카드의 번호를 출력한다.
            * Example : 4
        @시간 제한
            * 2s
        @메모리 제한
            * 128 MB
    */
    public static void main(String[] args) {
        try {
            solution_2();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
        @Desc : Array List를 활용한 문제 풀이
            * Memory Usage : 시간 초과
            * Time Usage : 시간 초과
        @수도 코드
        1. sudo code
            1-1. n만큼의 오름차순 배열 생성
            1-2. while( 배열의 길이가 1이 될 때 까지 )
                1-2. 0번째를 삭제한다.
                1-3. 0번쨰를 배열의 마지막으로 할당한다.
    */
    private static void solution_1() throws IOException {
        // 1. stream 변수 정의
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        // 2. 변수 할당
        int n = Integer.parseInt(br.readLine());
        List<Integer> array = new ArrayList<>();

        // 3. n만큼의 오름차순 배열 생성
        for (int i = 0; i < n; i++) {
            array.add(i + 1);
        }
        int candidateNumber = 0;
        while (array.size() != 1) {
            if (candidateNumber % 2 == 0) {
                array.remove(0);
            }
            if (candidateNumber % 2 != 0) {
                Integer first = array.get(0);
                array.add(first);
                array.remove(0);
            }
            candidateNumber++;
        }
        System.out.println(array.get(0));
    }

    /*
        @Desc : Queue (ArrayDeque) 를 활용한 문제 풀이
            * Memory Usage : 28912
            * Time Usage : 180
    */
    private static void solution_2() throws IOException {
        // 1. stream 변수 정의
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        // 2. 변수 할당
        int n = Integer.parseInt(br.readLine());

        // 3. queue 생성
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }

        while (queue.size() != 1) {
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());
    }

    /*
        @Desc : Queue (LinkedList) 를 활용한 문제 풀이
            * Memory Usage : 45492
            * Time Usage : 196
    */
    private static void solution_3() throws IOException {
        // 1. stream 변수 정의
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        // 2. 변수 할당
        int n = Integer.parseInt(br.readLine());

        // 3. queue 생성
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }

        while (queue.size() != 1) {
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());
    }
}
