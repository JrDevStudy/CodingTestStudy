package 이현재.배열2차원;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2738 {

    /**
     * 행렬 덧셈 - 152ms
     *
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/2738">문제 보기</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 두 행렬의 덧셈 값을 넣을 StringBuilder 클래스
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 2차원 행렬의 원소는 띄어쓰기로 구분해서 입력됨
        int N = Integer.parseInt(st.nextToken()); // 행
        int M = Integer.parseInt(st.nextToken()); // 열

        int[] arr = new int[N * M]; // 2차원 배열의 값을 1차원 배열에 담기 위해 행 * 열 크기의 1차원 배열 생성
        for (int i = 0; i < N; i++) { // 첫번째 행렬을 저장하기 위해 N 만큼만 반복
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                // 행 크기(M)만큼 인덱스 크기를 키워야 1차원 배열에 할당할 수 있다.
                arr[i * M + j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) { // 두번째 행렬을 저장하기 위해 N 만큼 반복
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                // 첫번째 행렬의 첫 좌표 값과 두번째 행렬 값을 순차적으로 더하고 띄어쓰기로 구분
                int sum = arr[i * M + j] + Integer.parseInt(st.nextToken());
                sb.append(sum).append(" ");
            }
            // 한 행을 다 읽으면 개행 문자 더하기
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // BufferedWriter 를 사용한 풀이 - 196ms
    public static void main01(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N * M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i * M + j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int sum = arr[i * M + j] + Integer.parseInt(st.nextToken());
                bw.write(sum + " ");
            }
            bw.write("\n");
        }

        bw.flush();
    }


}
