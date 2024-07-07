package 이현재.심화1;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3003 {

    /**
     * 킹, 퀸, 룩, 비숍, 나이트, 폰 - 140ms
     *
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/3003">문제 보기</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] chess = {1, 1, 2, 2, 2, 8};
        for (int piece : chess) {
            int wp = Integer.parseInt(st.nextToken());
            bw.write(piece - wp + " ");
        }
        bw.flush();
    }

    // BufferedWriter 미사용 풀이 - 116ms
    public static void other00(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] chess = {1, 1, 2, 2, 2, 8};
        for (int piece : chess) {
            int wp = Integer.parseInt(st.nextToken());
            System.out.print(piece - wp + " ");
        }
    }

    // 반복문 미사용 풀이 - 116ms
    public static void other01(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int king = 1;
        int queen = 1;
        int rook = 2;
        int bishop = 2;
        int knight = 2;
        int pawn = 8;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        king = king - Integer.parseInt(st.nextToken());
        queen = queen - Integer.parseInt(st.nextToken());
        rook = rook - Integer.parseInt(st.nextToken());
        bishop = bishop - Integer.parseInt(st.nextToken());
        knight = knight - Integer.parseInt(st.nextToken());
        pawn = pawn - Integer.parseInt(st.nextToken());

        System.out.print(king + " ");
        System.out.print(queen + " ");
        System.out.print(rook + " ");
        System.out.print(bishop + " ");
        System.out.print(knight + " ");
        System.out.print(pawn);
    }
}
