package 정유성;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ_10816 {
    /*
        숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다.
        정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.

        @Input
            * 첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다.
              숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
              셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며,
              이 수는 공백으로 구분되어져 있다. 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
            * Example : 10
                        6 3 2 10 10 10 -10 -10 7 3
                        8
                        10 9 -5 2 3 4 5 -10
        @OutPut
            * 첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력한다.
            * Example : 3 0 0 1 2 0 0 2
     */

    public static void main(String[] args) throws IOException {
        // BufferedWriter와 BufferedReader를 사용하여 입출력 처리
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(); // StringBuilder를 사용하여 결과 문자열 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 배열의 크기와 요소들을 입력받아 sgList 배열에 저장
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int[] sgList = new int[n];
        for (int i = 0; i < n; i++) {
            sgList[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(sgList); // 배열 정렬

        // 두 번째 배열의 크기를 입력받고, 요소들을 cdList 리스트에 저장
        int m = Integer.parseInt(br.readLine());
        List<Integer> cdList = Arrays.asList(br.readLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());

        // cdList의 각 요소에 대해 lowerBound와 upperBound를 사용하여 sgList에서의 빈도수를 계산
        cdList.stream().forEach(i -> sb.append(upperBound(sgList, i) - lowerBound(sgList, i)).append(" "));

        // 결과 출력
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();

    }

    // target 값 이상이 처음 나타나는 위치를 이진 탐색을 사용하여 찾는다
    private static int lowerBound(int[] arr, int target) {
        // low를 0으로, high를 배열의 길이로 초기화
        int low = 0;
        int high = arr.length;

        while (low < high) { // low가 high보다 작을 때까지 반복
            int mid = (low + high) / 2; // mid를 low와 high의 중간 값으로 계산
            if (target <= arr[mid]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    // target 값보다 큰 값이 처음 나타나는 위치를 이진 탐색을 사용하여 찾는다
    private static int upperBound(int[] arr, int target) {
        // low를 0으로, high를 배열의 길이로 초기화
        int low = 0;
        int high = arr.length;

        while (low < high) { // low가 high보다 작을 때까지 반복
            int mid = (low + high) / 2; // mid를 low와 high의 중간 값으로 계산
            if (target < arr[mid]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

}

 /* 추가 설명
    - 입력: 두 개의 배열을 입력
    - 정렬: 첫 번째 배열을 정렬하여 이진 탐색을 사용할 수 있도록 함
    - 빈도수 계산: lowerBound와 upperBound를 사용하여 특정 값의 범위를 찾음
                 두 함수의 결과 차이를 계산하여 빈도수를 구함
    - 출력: 계산된 빈도수를 출력
 */