package 서병범.test;

import java.util.HashMap;
import java.util.Map;

public class HashMap_test {

    /*
    HashMap
    삽입, 조회, 업데이트, 삭제
    테스트
     */
    public static void main(String[] args) {
        // HashMap 생성
        Map<String, Integer> bookMap = new HashMap<>();

        // 데이터 삽입
        bookMap.put("The Catcher in the Rye", 3);
        bookMap.put("To Kill a Mockingbird", 5);
        bookMap.put("1984", 4);
        bookMap.put("Moby Dick", 2);

        // 데이터 출력
        System.out.println("Initial Book Map: " + bookMap);

        // 특정 키에 대한 값 조회
        String bookToSearch = "1984";
        if (bookMap.containsKey(bookToSearch)) {
            System.out.println("The book '" + bookToSearch + "' has been sold " + bookMap.get(bookToSearch) + " times.");
        } else {
            System.out.println("The book '" + bookToSearch + "' is not in the map.");
        }

        // 데이터 업데이트
        String bookToUpdate = "Moby Dick";
        bookMap.put(bookToUpdate, bookMap.get(bookToUpdate) + 1);
        System.out.println("After updating '" + bookToUpdate + "', Book Map: " + bookMap);

        // 키가 없는 경우 기본값 설정
        String newBook = "The Great Gatsby";
        int defaultValue = 0;
        bookMap.put(newBook, bookMap.getOrDefault(newBook, defaultValue) + 1);
        System.out.println("After adding '" + newBook + "', Book Map: " + bookMap);

        // 데이터 삭제
        String bookToRemove = "To Kill a Mockingbird";
        bookMap.remove(bookToRemove);
        System.out.println("After removing '" + bookToRemove + "', Book Map: " + bookMap);

        // 전체 키-값 쌍 순회
        System.out.println("Iterating over the bookMap:");
        for (Map.Entry<String, Integer> entry : bookMap.entrySet()) {
            System.out.println("Book: " + entry.getKey() + ", Sold: " + entry.getValue() + " times");
        }
    }
}
