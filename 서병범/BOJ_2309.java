package 서병범;

import java.io.*;
import java.util.*;

/**
 * 2309번: 일곱 난쟁이
 * <pre>
 *     <b>[문제]</b>
 *     왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다.
 *     일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.
 *
 *     아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다.
 *     뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.
 *
 *     아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.
 *
 *     <b>[입력]</b>
 *     아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다.
 *     주어지는 키는 100을 넘지 않는 자연수이며, 아홉 난쟁이의 키는 모두 다르며, 가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.
 *     Example :
 *     20
 *     7
 *     23
 *     19
 *     10
 *     15
 *     25
 *     8
 *     13
 *
 *     <b>[출력]</b>
 *     일곱 난쟁이의 키를 오름차순으로 출력한다. 일곱 난쟁이를 찾을 수 없는 경우는 없다.
 *     Example :
 *     7
 *     8
 *     10
 *     13
 *     19
 *     20
 *     23
 * </pre>
 * @see <a href="https://www.acmicpc.net/problem/2309">문제 보기</a>
 */
public class BOJ_2309 {

    public static void main(String[] args) throws IOException {
//        solution1();
        solution2();
    }

    /**
     * 브루트포스(brute force. 완전탐색. 가능한 모든 경우의 수 탐색)
     * : 9명의 난쟁이 중 2명을 고르는 조합, 조건에 맞는 값을 찾는 순간 반복 종료
     *
     * 이중 루프를 사용하여 9명의 난쟁이 중에서 2명을 선택하고, 그들의 키 합을 전체 합에서 뺀 값이 100인지 확인
     * 조건을 만족하는 두 난쟁이를 찾으면, 이들을 List에서 제거하고 루프를 종료
     *
     * 메모리 : 14212 KB
     * 시간 : 104 ms
     * @throws IOException
     */
    public static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> dwarfs = new ArrayList<>();

        // 9명의 난쟁이 키 입력
        for (int i = 0; i < 9; i++) {
            dwarfs.add(Integer.parseInt(br.readLine()));
        }

        // 난쟁이들의 전체 키 합
        int total = dwarfs.stream().mapToInt(Integer::intValue).sum();

        // 두 난쟁이 찾기
        boolean found = false;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (total - dwarfs.get(i) - dwarfs.get(j) == 100) {
                    // 두 난쟁이 제거
                    dwarfs.remove(j);  // 큰 인덱스부터 제거
                    dwarfs.remove(i);
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        // 오름차순 정렬
        Collections.sort(dwarfs);

        // 결과 출력
        for (int dwarf : dwarfs) {
            System.out.println(dwarf);
        }
    }



    /**
     * 백준 상위 등수 풀이
     *
     * 재귀적 방식 사용 :
     * 재귀적으로 조합을 탐색하여 모든 경우의 수를 확인 / 재귀를 통해 간단하게 구현
     *
     * 메모리 :  11428 KB
     * 시간 :  64 ms
     *
     * @throws IOException
     */
    // 9명의 난쟁이들의 키를 저장하는 배열
    static int[] nums;

    // 선택된 7명의 난쟁이들의 키를 저장하는 배열
    static int[] seven;

    // 현재 선택된 7명의 난쟁이들의 키의 합을 추적하는 변수 hap
    static int hap;
    public static void solution2() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 난쟁이들의 키를 저장할 배열 초기화
        nums = new int[9];

        // 9명의 난쟁이들의 키를 입력받아 nums 배열에 저장
        for (int i = 0; i < 9; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        // 선택된 7명의 난쟁이들의 키를 저장할 배열 초기화
        seven = new int[7];

        // 조합을 통해 7명의 난쟁이를 선택하는 메서드 호출
        nCr(0, 0);

        // 선택된 7명의 난쟁이들의 키를 오름차순으로 정렬
        Arrays.sort(seven);

        // 결과를 출력
        for (int num : seven) {
            System.out.println(num);
        }
    }

    /**
     * nCr 메서드: 조합을 통해 9명 중 7명을 선택하는 메서드
     * @param cnt: 현재까지 선택한 난쟁이의 수
     * @param start: 탐색을 시작할 인덱스
     */
    private static void nCr(int cnt, int start) {
        // 7명을 모두 선택한 경우
        if (cnt == 7) {
            // 현재 선택된 난쟁이들의 키의 합을 계산
            hap = 0;
            for (int a : seven) {
                hap += a;
            }
            return;
        }

        // 9명의 난쟁이들 중에서 7명을 선택하기 위해 반복
        for (int i = start; i < 9; i++) {
            // 이미 키의 합이 100이면 더 이상 탐색하지 않음
            if (hap == 100) return;

            // 현재 난쟁이를 선택하여 seven 배열에 저장
            seven[cnt] = nums[i];

            // 재귀 호출로 다음 난쟁이를 선택
            nCr(cnt + 1, i + 1);
        }
    }

}
