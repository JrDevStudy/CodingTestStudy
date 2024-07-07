package 정유성;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_10809 {
    /*
        알파벳 소문자로만 이루어진 단어 S가 주어진다.
        각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를,
        포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.

        @Input
            * 첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.
            * Example : baekjoon
        @OutPut
            * 각각의 알파벳에 대해서, a가 처음 등장하는 위치, b가 처음 등장하는 위치, ... z가 처음 등장하는 위치를 공백으로 구분해서 출력한다.
              만약, 어떤 알파벳이 단어에 포함되어 있지 않다면 -1을 출력한다. 단어의 첫 번째 글자는 0번째 위치이고, 두 번째 글자는 1번째 위치이다.
            * Example : 1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 배열의 크기는 26으로, 각 인덱스는 알파벳 소문자 a부터 z까지를 나타냄
        int[] arr = new int[26];
        // 배열을 -1로 초기화
        for (int i = 0; i < 26; i++) {
            arr[i] = -1;
        }
        // 입력 문자열 S를 읽어옴
        String S = br.readLine();
        // 단어의 길이만큼 반복
        for (int i = 0; i < S.length(); i++) {
            // 단어의 문자값에 해당하는 인코딩값을 -97 또는 -'a' 하여 알파벳 소문자 a가 0, z 가 25로 인덱스를 맞춰줌
            int index = S.charAt(i) - 'a';
            // arr[index] == -1인지 확인하여, 해당 문자가 처음 등장하는 경우에만 인덱스를 배열에 기록
            if (arr[index] == -1) {
                // -1이 맞다면 처음 등장한 알파벳이므로 위치값을 저장
                arr[index] = i;
            }
            // -1이 아니라면 이미 등장한 알파벳이므로 넘어감
        }

        // 결과 출력 준비
        // arr 배열의 각 요소를 StringBuilder 객체 sb에 추가, 각 값 뒤에 공백을 추가하여 출력 형식을 맞춤
        for (int i = 0; i < 26; i++) {
            sb.append(arr[i]).append(" ");
        }
        // StringBuilder 객체 sb를 출력
        System.out.println(sb);
    }
}
