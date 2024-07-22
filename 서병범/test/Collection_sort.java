package 서병범.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Collection_sort {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(1);
        numbers.add(4);
        numbers.add(2);

        System.out.println("Before sorting: " + numbers);
        Collections.sort(numbers);
        System.out.println("After sorting: " + numbers);

        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("After reverseOrder() sorting: " + numbers);
    }

    /*
    Before sorting: [3, 1, 4, 2]
    After sorting: [1, 2, 3, 4]
    After reverseOrder() sorting: [4, 3, 2, 1]
     */
}
