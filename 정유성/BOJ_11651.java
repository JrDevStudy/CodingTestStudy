package 정유성;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11651 {
    /*
        2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로,
        y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

        @Input
            * 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다.
              (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
            * Example : 5
                        0 4
                        1 2
                        1 -1
                        2 2
                        3 3
        @OutPut
            * 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
            * Example : 1 -1
                        1  2
                        2  2
                        3  3
                        0  4
     */

    public static void main(String[] args) throws IOException {
        // 입력을 받기 위해 BufferedReader를 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력을 위해 BufferedWriter를 생성
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 첫 번째 줄에서 정수 N을 읽어오기
        int N = Integer.parseInt(br.readLine());
        // N x 2 크기의 2차원 배열을 생성
        int[][] arrays = new int[N][2];

        // N번 반복하여 배열에 값을 채운다
        for (int i = 0; i < N; i++) {
            // 한 줄을 읽어와서 StringTokenizer로 분리
            st = new StringTokenizer(br.readLine());
            // 배열의 첫 번째 값 (x)을 읽어온다
            arrays[i][0] = Integer.parseInt(st.nextToken());
            // 배열의 두 번째 값 (y)을 읽어온다
            arrays[i][1] = Integer.parseInt(st.nextToken());
        }
        // 더 이상 입력을 받지 않으므로 BufferedReader를 닫기
        br.close();

        // 배열을 정렬, 정렬 기준은 y값이 우선이고, y값이 같으면 x값으로 정렬
        Arrays.sort(arrays, (num1, num2) -> {
            // y값이 다르면 y값을 기준으로 정렬하고 y값이 같으면 x값을 기준으로 정렬
            return num1[1] != num2[1] ? num1[1] - num2[1] : num1[0] - num2[0];
        });

        // 정렬된 배열을 출력
        for (int i = 0; i < N; i++) {
            // 각 배열의 값을 한 줄씩 BufferedWriter에 쓰기
            bw.write(arrays[i][0] + " " + arrays[i][1] + "\n");
        }

        // 모든 출력을 버퍼에 입력
        bw.flush();
        // 더 이상 출력을 하지 않으므로 BufferedWriter 닫기
        bw.close();
    }
}