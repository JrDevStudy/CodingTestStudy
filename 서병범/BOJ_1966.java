package 서병범;


import java.io.*;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1966번: 프린터 큐
 * <pre>
 *     <b>[문제]</b>
 *     여러분도 알다시피 여러분의 프린터 기기는 여러분이 인쇄하고자 하는 문서를 인쇄 명령을 받은 ‘순서대로’, 즉 먼저 요청된 것을 먼저 인쇄한다. 여러 개의 문서가 쌓인다면 Queue 자료구조에 쌓여서 FIFO - First In First Out - 에 따라 인쇄가 되게 된다. 하지만 상근이는 새로운 프린터기 내부 소프트웨어를 개발하였는데, 이 프린터기는 다음과 같은 조건에 따라 인쇄를 하게 된다.
 *
 *     현재 Queue의 가장 앞에 있는 문서의 ‘중요도’를 확인한다.
 *     나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다. 그렇지 않다면 바로 인쇄를 한다.
 *     예를 들어 Queue에 4개의 문서(A B C D)가 있고, 중요도가 2 1 4 3 라면 C를 인쇄하고, 다음으로 D를 인쇄하고 A, B를 인쇄하게 된다.
 *
 *     여러분이 할 일은, 현재 Queue에 있는 문서의 수와 중요도가 주어졌을 때, 어떤 한 문서가 몇 번째로 인쇄되는지 알아내는 것이다. 예를 들어 위의 예에서 C문서는 1번째로, A문서는 3번째로 인쇄되게 된다.
 *
 *     <b>[입력]</b>
 *     첫 줄에 테스트케이스의 수가 주어진다. 각 테스트케이스는 두 줄로 이루어져 있다.
 *
 *     테스트케이스의 첫 번째 줄에는 문서의 개수 N(1 ≤ N ≤ 100)과, 몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 몇 번째에 놓여 있는지를 나타내는 정수 M(0 ≤ M < N)이 주어진다.
 *     이때 맨 왼쪽은 0번째라고 하자. 두 번째 줄에는 N개 문서의 중요도가 차례대로 주어진다.
 *     중요도는 1 이상 9 이하의 정수이고, 중요도가 같은 문서가 여러 개 있을 수도 있다.
 *
 *     Example :
 *     3
 *     1 0
 *     5
 *     4 2
 *     1 2 3 4
 *     6 0
 *     1 1 9 1 1 1
 *
 *     <b>[출력]</b>
 *     각 테스트 케이스에 대해 문서가 몇 번째로 인쇄되는지 출력한다.
 *     Example :
 *     1
 *     2
 *     5
 *
 * </pre>
 * @see <a href="https://www.acmicpc.net/problem/1966">문제 보기</a>
 */
public class BOJ_1966 {

    public static void main(String[] args) throws IOException {
//        solution1();
        solution2();
    }

    /**
     * Queue 사용 : 선입선출(FIFO, First-In-First-Out) 방식으로 요소를 관리하는 자료 구조
     * 큐의 앞쪽 문서를 꺼내어 중요도를 확인하고, 더 높은 중요도의 문서가 있으면 큐의 뒤로 보내고, 그렇지 않으면 인쇄
     *
     * 시간 복잡도: O(n^2) - 매번 큐의 다른 요소들과 중요도를 비교하며 최악의 경우 n^2의 시간이 소요
     * 공간 복잡도: O(n) - 문서의 개수만큼 큐에 저장하여 사용
     *
     * 메모리 : 15156 KB (실행 시 측정되는 메모리 사용량)
     * 시간 : 120 ms (실행 시 측정되는 실행 시간)
     * @throws IOException
     */
    public static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수를 입력받음
        int testCase = Integer.parseInt(br.readLine());

        // 각 테스트 케이스를 처리
        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken()); // 우리가 확인하고자 하는 문서의 인덱스

            // 문서의 중요도를 큐에 저장
            Queue<int[]> queue = new LinkedList<>();
            /*
            Queue<int[]>: int[] 타입의 배열을 요소로 하는 큐를 선언
            new LinkedList<>(): LinkedList의 인스턴스를 생성하고, 이를 큐로 사용하겠다는 의미
             */
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                queue.offer(new int[] {i, Integer.parseInt(st.nextToken())});
            }

            int printOrder = 0; // 몇 번째로 인쇄되는지 기록하는 변수

            // 큐가 빌 때까지 반복
            while (!queue.isEmpty()) {
                // 큐의 첫 번째 문서를 확인
                int[] front = queue.poll();
                boolean hasHigherPriority = false;

                // 큐의 나머지 문서들과 중요도를 비교하여 더 높은 중요도가 있는지 확인
                for (int[] q : queue) {
                    if (q[1] > front[1]) {
                        hasHigherPriority = true;
                        break;
                    }
                }

                // 더 높은 중요도를 가진 문서가 있을 경우, 현재 문서를 큐의 뒤로 보냄
                if (hasHigherPriority) {
                    queue.offer(front);
                } else {
                    // 그렇지 않으면 현재 문서를 인쇄함
                    printOrder++;

                    // 만약 현재 문서가 우리가 찾는 문서라면 그 순서를 출력
                    if (front[0] == M) {
                        System.out.println(printOrder);
                        break;
                    }
                }
            }
        }
    }

    /*
    1. Queue 인터페이스
    Queue는 자바의 java.util 패키지에 포함된 인터페이스로, 선입선출(FIFO, First-In-First-Out) 방식으로 요소를 관리하는 자료 구조입니다. 즉, 큐에 먼저 들어간 요소가 가장 먼저 나옵니다.
    큐의 주요 메서드로는 다음과 같은 것들이 있습니다:
        - offer(E e): 요소를 큐의 뒤에 삽입합니다. 큐가 꽉 차있다면 false를 반환합니다.
        - poll(): 큐의 앞에 있는 요소를 제거하고 반환합니다. 큐가 비어 있으면 null을 반환합니다.
        - peek(): 큐의 앞에 있는 요소를 제거하지 않고 반환합니다. 큐가 비어 있으면 null을 반환합니다.

    2. LinkedList 클래스
    - LinkedList는 Java에서 List, Deque, Queue 등의 인터페이스를 구현하는 클래스입니다.
    - 내부적으로 이중 연결 리스트(doubly linked list)로 구성되어 있어 요소를 삽입하거나 삭제하는 데 유리합니다.
    - LinkedList는 Queue 인터페이스의 모든 메서드를 구현하고 있어 큐로 사용할 수 있습니다.
     */



    /**
     * 백준 상위 등수 풀이
     *
     * ArrayDeque 사용
     * : ArrayDeque는 자바에서 제공하는 Deque(Double-Ended Queue) 인터페이스를 구현한 클래스
     * - 큐와 스택의 기능을 모두 지원하며, 양방향에서 요소를 추가하거나 제거할 수 있는 배열 기반의 자료구조
     * - 빠른 성능: ArrayDeque는 LinkedList보다 메모리 사용량이 적고 성능이 뛰어납니다.
     * - 다양한 용도: 스택, 큐, 덱으로 모두 사용할 수 있어 유연성이 높습니다.
     * - 비추천된 Stack의 대체: 현대 자바 코드에서는 Stack 대신 ArrayDeque를 사용하는 것이 권장됩니다.
     *
     * 메모리 :  12252 KB
     * 시간 :  72 ms
     *
     * @throws IOException
     */
    public static void solution2() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(); // 결과를 저장할 StringBuilder

        int[] idx;  // 각 중요도에 해당하는 문서의 수를 기록하는 배열
        int n = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        // 각 테스트 케이스 처리
        for (int i = 0; i < n; i++) {
            idx  = new int[10];  // 중요도는 1~9, 인덱스 0은 사용하지 않음
            int a, b;  // a: 문서의 수, b: 목표 문서의 위치

            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayDeque<int[]> q = new ArrayDeque<>(); // 문서를 저장할 큐. 각 요소는 [문서의 위치, 중요도]

            a = Integer.parseInt(st.nextToken()); // 문서의 수
            b = Integer.parseInt(st.nextToken()); // 목표 문서의 위치

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < a; j++) {
                int num =  Integer.parseInt(st.nextToken()); // 문서의 중요도
                q.addLast(new int[]{j, num}); // 큐에 [문서의 위치, 중요도] 저장
                idx[num]++; // 해당 중요도의 문서 개수 증가
            }

            int order = 9; // 가장 높은 중요도를 추적하기 위한 변수
            while(order != 0) { // 모든 중요도를 처리할 때까지 반복
                // 현재 큐에서 가장 높은 중요도를 찾기
                for (int j = 9; j > 0; j--) {
                    if (idx[j] != 0) { // 현재 중요도에 문서가 있다면
                        order = j; // 그 중요도를 order로 설정
                        break;
                    }
                }

                // 현재 가장 앞에 있는 문서의 중요도가 최고 중요도인지 확인
                if (q.getFirst()[1] == order) {
                    int[] tmp = q.removeFirst(); // 문서를 큐에서 꺼냄
                    idx[tmp[1]]--; // 해당 중요도의 문서 개수 감소
                    if (tmp[0] == b) { // 꺼낸 문서가 목표 문서라면
                        sb.append(a - q.size()).append("\n"); // 출력 순서 기록
                        break; // 반복 종료
                    }
                } else {
                    q.addLast(q.removeFirst()); // 중요도가 높지 않다면 큐의 뒤로 보냄
                }
            }
        }

        bw.append(sb.toString()); // 모든 결과 출력
        bw.flush();
        bw.close();
        br.close();
    }

    /*
    BufferedWriter vs System.out.println

    * System.out.println:

    - 출력 방식: System.out.println은 자바의 표준 출력 스트림(System.out)을 통해 텍스트를 출력합니다. 이 메서드는 출력 후 자동으로 줄바꿈을 수행합니다.
    - 버퍼링: System.out은 내부적으로 버퍼링을 하지만, 기본적으로 버퍼 크기가 작고, 출력을 호출할 때마다 즉시 처리하려고 합니다. 따라서 매 출력마다 시스템 호출(I/O 작업)이 발생할 가능성이 큽니다.
    - 사용 편의성: 코드가 간결하고 이해하기 쉽기 때문에 빠르게 출력을 확인하고자 할 때 많이 사용됩니다.


    * BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)):

    - 출력 방식: BufferedWriter는 버퍼링된 출력 스트림을 사용하여 출력합니다. BufferedWriter는 데이터를 메모리에 모았다가 일정 크기 이상의 데이터가 쌓이면 한꺼번에 출력합니다.
    - 버퍼링: BufferedWriter는 기본적으로 8KB 정도의 버퍼를 사용합니다. 출력 작업이 버퍼에 쌓일 때까지 시스템 호출을 지연시키며, 이는 I/O 작업 횟수를 줄여줍니다.
    - 사용 편의성: BufferedWriter를 사용하면 버퍼에 쌓인 데이터를 출력할 때 flush()를 호출해 명시적으로 내보내야 합니다. 이로 인해 코드가 조금 더 복잡해질 수 있습니다.

     */

}
