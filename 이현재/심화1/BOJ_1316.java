package 이현재.심화1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1316 {

    /**
     * 그룹 단어 체커 - 132ms
     *
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/1316">문제 보기</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr;
        int cnt = 0; // 그룹 단어 개수
        for (int i = 0; i < n; i++) {
            arr = new int[26]; // 알파벳 개수와 동일한 크기의 배열 선언
            char[] s = br.readLine().toCharArray(); // 입력 문자를 문자 배열로 변환
            char c = s[0]; // 직전 읽은 문자
            boolean isGroupWord = true; // 그룹 단어 유무
            for (char value : s) {
                // 현재 문자가 직전 문자와 다른 문자이면서 처음 나온 문자가 아닌 경우
                if (value != c && arr[value - 'a'] != 0) {
                    isGroupWord = false;
                    break;
                } else { // 현재 문자가 직전 문자와 같거나 처음 나온 문자인 경우
                    c = value;
                    arr[value - 'a']++;
                }
            }
            if (isGroupWord) cnt++;
        }
        System.out.println(cnt);
    }

    // 124ms
    public static void main01(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr;
        int cnt = 0; // 그룹 단어 개수
        for (int i = 0; i < n; i++) {
            arr = new int[26]; // 알파벳 개수와 동일한 크기의 배열 선언
            char[] s = br.readLine().toCharArray(); // 입력 문자를 문자 배열로 변환
            char c = s[0]; // 직전 읽은 문자
            boolean isGroupWord = true; // 그룹 단어 유무
            for (char value : s) {
                // 직전 문자와 현재 문자가 같거나 처음 나온 문자인 경우
                if (value == c || arr[value - 'a'] == 0) {
                    c = value;
                    arr[value - 'a']++;
                    continue;
                }
                isGroupWord = false;
            }
            if (isGroupWord) cnt++;
        }
        System.out.println(cnt);
    }

    // 128ms
    public static void other(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //[1, 100]

        boolean[] visited;
        int res = 0;
        while(N --> 0) {
            String input = br.readLine();
            visited = new boolean[26]; // 알파벳 개수와 같은 boolean 배열 생성
            visited[input.charAt(0) - 'a'] = true; // 첫 문자의 알파벳 순번 자리에 true 할당
            boolean isGroup = true;
            for(int i = 1; i < input.length(); i++) {
                int c = input.charAt(i) - 'a';
                // 직전 문자와 같다면 continue
                if(input.charAt(i-1) == input.charAt(i)) continue;
                // 직전 문자와 다른 문자이면서 이미 나왔던 문자인 경우 그룹문자가 아님
                if(visited[c]) {
                    isGroup = false;
                    break;
                }
                // 직전 문자와 다른 문자이면서 처음 나온 문자인 경우 true 할당
                visited[c] = true;
            }

            if(isGroup) res++;
        }
        System.out.println(res);
    }
}
