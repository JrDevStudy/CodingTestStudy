package 정유성;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_10814 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        String[][] arr = new String[N][2];

        for(int i = 0; i < N; i++) { // N번 반복
            arr[i][0] = in.next();	// 나이를 입력받아 배열의 첫 번째 위치에 저장
            arr[i][1] = in.next();	// 이름을 입력받아 배열의 두 번째 위치에 저장
        }

        // 두 번째 인자로 Comparator를 제공하여 정렬 기준을 정의
        Arrays.sort(arr, new Comparator<String[]>() {
            // 나이순으로 정렬
            @Override
            public int compare(String[] s1, String[] s2) { // Comparator 인터페이스의 compare 메서드를 오버라이드
                return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
            }

        });

        for(int i = 0; i < N; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]); // 정렬된 배열을 출력
        }
    }
}
