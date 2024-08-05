package 서병범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1316 {

    /*
    그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.

    단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.

    @Input
         * 첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
         * Example :
                    3
                    happy
                    new
                    year
    @OutPut
         * 첫째 줄에 그룹 단어의 개수를 출력한다.
         * Example :
                    3

    @link https://www.acmicpc.net/problem/1316
    */


    public static void main(String[] args) throws IOException {
//        solution1();
        solution2();
    }

    /**
     * 메모리 : 14228 KB
     * 시간 : 128 ms
     * @throws IOException
     */
    public static void solution1() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 단어의 개수를 읽어들임
        int N = Integer.parseInt(br.readLine());
        int count = 0;  // 그룹 단어의 개수를 세기 위한 변수

        // N개의 단어를 순서대로 읽어들임
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            // 현재 단어가 그룹 단어인지 확인하고, 그룹 단어라면 count를 증가시킴
            if (isGroupWord(word)) {
                count++;
            }
        }

        // 최종적으로 그룹 단어의 개수를 출력
        System.out.println(count);
    }

    /**
     * 주어진 단어가 그룹 단어인지 확인하는 함수
     * @param word 입력 단어
     * @return 그룹 단어이면 true, 아니면 false
     */
    private static boolean isGroupWord(String word) {
        // 각 문자가 등장했는지 여부를 저장하는 배열
        boolean[] seen = new boolean[26];
        char prevChar = '\0';  // 이전 문자를 저장하는 변수, 초기값은 null character

        // 단어의 모든 문자를 순회
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);  // 현재 문자를 가져옴

            // 현재 문자와 이전 문자가 다를 때
            if (currentChar != prevChar) {
                // 현재 문자가 이전에 등장한 적이 있는지 확인
                if (seen[currentChar - 'a']) {
                    return false;  // 이미 등장한 적이 있다면 그룹 단어가 아님
                }
                // 현재 문자를 등장한 것으로 표시
                seen[currentChar - 'a'] = true;
                prevChar = currentChar;  // 이전 문자를 현재 문자로 업데이트
            }
        }

        return true;  // 모든 문자를 확인한 후 그룹 단어임을 확인
    }


    /**
     * 백준 상위 등수 풀이
     * 메모리 : 11512 KB
     * 시간 : 68 ms
     *
     * @throws IOException
     */
    public static void solution2() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 단어의 개수를 읽어들임
        int N = Integer.parseInt(br.readLine());

        // 각 알파벳 문자가 이전에 등장했는지 여부를 저장하는 배열
        boolean[] array = new boolean[27]; // a-z까지 26개 +1

        int result = 0; // 그룹 단어의 개수를 저장할 변수

        // 각 단어를 읽어들이며 처리
        L: for (int i = 0; i < N; i++) {
            String str = br.readLine();
            array = new boolean[27]; // 매 단어마다 새로운 배열 초기화

            for (int j = 0; j < str.length() - 1; j++) {
                // 현재 문자와 다음 문자가 같으면 연속된 문자이므로 계속 진행
                if (str.charAt(j) == str.charAt(j + 1)) continue;

                // 현재 문자가 이전에 등장한 적이 없는 경우
                if (!array[str.charAt(j) - 'a']) {
                    array[str.charAt(j) - 'a'] = true; // 현재 문자를 등장한 것으로 표시
                }
                // 현재 문자가 이전에 등장한 적이 있는 경우 (그룹 단어가 아님)
                else continue L; // 해당 단어는 그룹 단어가 아니므로 다음 단어로 넘어감
            }

            // 마지막 문자가 이전에 등장한 적이 있는지 확인
            if (array[str.charAt(str.length() - 1) - 'a']) continue L;

            // 모든 조건을 통과하면 그룹 단어로 인정
            result++;
        }

        // 최종적으로 그룹 단어의 개수를 출력
        System.out.println(result);

    }


}
