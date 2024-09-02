package 서병범.test;

import java.util.ArrayDeque;

public class ArrayDeque_test {

    /*
    ArrayDeque는 자바에서 제공하는 Deque(Double-Ended Queue) 인터페이스를 구현한 클래스
    - 큐와 스택의 기능을 모두 지원하며, 양방향에서 요소를 추가하거나 제거할 수 있는 배열 기반의 자료구조

    addFirst(E e): 덱의 앞쪽에 요소를 추가합니다.
    addLast(E e): 덱의 뒤쪽에 요소를 추가합니다.
    removeFirst(): 덱의 앞쪽에서 요소를 제거하고 반환합니다. 덱이 비어있으면 예외를 발생시킵니다.
    removeLast(): 덱의 뒤쪽에서 요소를 제거하고 반환합니다. 덱이 비어있으면 예외를 발생시킵니다.
    getFirst(): 덱의 앞쪽에서 요소를 반환하지만 제거하지는 않습니다.
    getLast(): 덱의 뒤쪽에서 요소를 반환하지만 제거하지는 않습니다.
    offerFirst(E e): 덱의 앞쪽에 요소를 추가하며, 공간이 부족하면 false를 반환합니다.
    offerLast(E e): 덱의 뒤쪽에 요소를 추가하며, 공간이 부족하면 false를 반환합니다.
    pollFirst(): 덱의 앞쪽에서 요소를 제거하고 반환하며, 비어있는 경우 null을 반환합니다.
    pollLast(): 덱의 뒤쪽에서 요소를 제거하고 반환하며, 비어있는 경우 null을 반환합니다.
     */
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // 요소 추가
        deque.addFirst(10); // 앞쪽에 추가
        deque.addLast(20);  // 뒤쪽에 추가

        System.out.println(deque); // [10, 20]

        // 요소 제거
        int first = deque.removeFirst(); // 앞쪽 요소 제거
        System.out.println(first);       // 10

        int last = deque.removeLast();   // 뒤쪽 요소 제거
        System.out.println(last);        // 20
    }
}
