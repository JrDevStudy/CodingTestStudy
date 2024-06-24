package 이현재;

import java.io.*;

public class BOJ_10809 {

    /**
     * 10809번: 알파벳 찾기 - 144ms
     * <pre>
     *     <b>[문제]</b>
     *     알파벳 소문자로만 이루어진 단어 S가 주어진다.
     *     각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.
     *
     *     <b>[입력]</b>
     *     첫째 줄에 단어 S가 주어진다.
     *     단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.
     *
     *     <b>[출력]</b>
     *     각각의 알파벳에 대해서, a가 처음 등장하는 위치, b가 처음 등장하는 위치, ... z가 처음 등장하는 위치를 공백으로 구분해서 출력한다.
     *     만약, 어떤 알파벳이 단어에 포함되어 있지 않다면 -1을 출력한다.
     *     단어의 첫 번째 글자는 0번째 위치이고, 두 번째 글자는 1번째 위치이다.
     * </pre>
     *
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/10809">문제 보기</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[26];
        for (int i = 0; i < 26; i++) arr[i] = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int j = c - 'a';
            if (arr[j] == -1) arr[j] = i;
        }

        for (int a : arr) System.out.print(a + " ");
    }

    /**
     * 반복문 조건을 char 타입으로 할당 - 148ms
     * @param args args
     * @throws IOException IOException
     */
    public static void other(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        for(char c ='a'; c<='z'; c++) bw.write(str.indexOf(c)+" ");
        bw.flush();
    }
}
