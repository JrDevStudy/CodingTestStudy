package 임인혁.boj_basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[] myArr = new int[4];

    private static int[] checkArr = new int[4];

    public static void main(String[] args) throws IOException {
        // 1. stream 변수 정의
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 2. S(문자열 크기), P(부분 문자열의 크기), A(문자열 데이터) , checkArr (‘A’, ‘C’, ‘G’, ‘T’ 의 최소 개수) 저장하기
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        char[] A = br.readLine().toCharArray();

        // checkArr (‘A’, ‘C’, ‘G’, ‘T’ 의 최소 개수) 저장하기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < p; i++) { // 첫 부분문자열 셋팅 (0~p) 까지
            if (A[i]=='A') myArr[0]++;
            if (A[i]=='C') myArr[1]++;
            if (A[i]=='G') myArr[2]++;
            if (A[i]=='T') myArr[3]++;
        }

        // {‘A’, ‘C’, ‘G’, ‘T’} 4개의 문자가 모두 최소개수를 만족했다면 만들 수 있는 비밀번호 개수 증가
        int result = 0;
        if (checkCounting()) result++;

        // sliding window
        for (int j = p; j < s; j++) {
            // j : 부분 문자열의 end_index
            // i : 부분 문자열의 start_index
            // --+
            int i = j - p; // 이전 부분문자열의 시작을 나타내는 위치

            // 이전 부분문자열의 시작 문자 제외
            if (A[i]=='A') myArr[0]--;
            if (A[i]=='C') myArr[1]--;
            if (A[i]=='G') myArr[2]--;
            if (A[i]=='T') myArr[3]--;

            // 이전 부분문자열의 끝에서 1문자 추가
            if (A[j]=='A') myArr[0]++;
            if (A[j]=='C') myArr[1]++;
            if (A[j]=='G') myArr[2]++;
            if (A[j]=='T') myArr[3]++;

            if (checkCounting())  result++;
        }

        bw.write(result + " ");
        bw.flush();
    }
    private static boolean checkCounting() {
        for (int i = 0; i < 4; i++) {
            if (myArr[i] < checkArr[i])
                return false;
        }
        return true;
    }
}