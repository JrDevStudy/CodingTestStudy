package 서병범.test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Queue_test {

    public static void main(String[] args) {

        /*
        queue.poll() :
        큐는 선입선출(FIFO, First In First Out) 자료구조입니다.
        큐의 앞에 있는 요소를 제거하고 반환합니다. 만약 큐가 비어있다면 null을 반환합니다.
         */
        Queue<Integer> queue1 = new LinkedList<>();
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);
        int element = queue1.poll(); // element = 1, 큐는 이제 [2, 3]

        System.out.println(element);


        /*
        queue.size() :
        size() 메서드는 큐에 현재 들어있는 요소의 수를 반환합니다.
        이 메서드는 큐가 비어있을 경우 0을 반환합니다.
         */
        Queue<Integer> queue2 = new LinkedList<>();
        queue2.add(1);
        queue2.add(2);
        int size = queue2.size(); // size = 2

        System.out.println(size);


        /* PriorityQueue
        정렬 방식: 기본적으로 오름차순 (최소 힙). 내림차순 정렬을 위해 Comparator 사용 가능.
        시간 복잡도: 삽입, 삭제 O(log n).

        주요 메서드:
            add(E e), offer(E e): 요소 삽입.
            poll(): 우선순위가 가장 높은 요소 제거 및 반환.
            peek(): 우선순위가 가장 높은 요소 반환(제거하지 않음).
            isEmpty(): 큐가 비어 있는지 확인.
         */

        // 기본 오름차순 정렬
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(3);
        minHeap.add(1);
        minHeap.add(2);

        System.out.println("Min Heap:");
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }

        // 내림차순 정렬을 위한 커스텀 Comparator 제공
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.add(3);
        maxHeap.add(1);
        maxHeap.add(2);

        System.out.println("Max Heap:");
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
        /* 실행 결과
        Min Heap:
        1
        2
        3
        Max Heap:
        3
        2
        1
         */

    }
}
