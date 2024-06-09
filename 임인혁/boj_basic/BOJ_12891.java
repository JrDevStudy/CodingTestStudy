package 임인혁.boj_basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import javax.xml.transform.Result;

public class BOJ_12891 {

    /*
        평소에 문자열을 가지고 노는 것을 좋아하는 민호는 DNA 문자열을 알게 되었다.
        DNA 문자열은 모든 문자열에 등장하는 문자가 {‘A’, ‘C’, ‘G’, ‘T’} 인 문자열을 말한다.
        예를 들어 “ACKA”는 DNA 문자열이 아니지만 “ACCA”는 DNA 문자열이다.
        이런 신비한 문자열에 완전히 매료된 민호는 임의의 DNA 문자열을 만들고 만들어진 DNA 문자열의 부분 문자열을 비밀번호로 사용하기로 마음먹었다.
        하지만 민호는 이러한 방법에는 큰 문제가 있다는 것을 발견했다.
        임의의 DNA 문자열의 부분 문자열을 뽑았을 때 “AAAA”와 같이 보안에 취약한 비밀번호가 만들어 질 수 있기 때문이다.
        그래서 민호는 부분 문자열에서 등장하는 문자의 개수가 특정 개수 이상이여야 비밀번호로 사용할 수 있다는 규칙을 만들었다.
        임의의 DNA문자열이 “AAACCTGCCAA” 이고 민호가 뽑을 부분 문자열의 길이를 4라고 하자.
        그리고 부분 문자열에 ‘A’ 는 1개 이상, ‘C’는 1개 이상, ‘G’는 1개 이상, ‘T’는 0개 이상이 등장해야 비밀번호로 사용할 수 있다고 하자.
        이때 “ACCT” 는 ‘G’ 가 1 개 이상 등장해야 한다는 조건을 만족하지 못해 비밀번호로 사용하지 못한다. 하지만 “GCCA” 은 모든 조건을 만족하기 때문에 비밀번호로 사용할 수 있다.
        민호가 만든 임의의 DNA 문자열과 비밀번호로 사용할 부분 문자열의 길이, 그리고 {‘A’, ‘C’, ‘G’, ‘T’} 가 각각 몇번 이상 등장해야 비밀번호로 사용할 수 있는지 순서대로 주어졌을 때
        민호가 만들 수 있는 비밀번호의 종류의 수를 구하는 프로그램을 작성하자. 단 부분 문자열이 등장하는 위치가 다르다면 부분 문자열이 같다고 하더라도 다른 문자열로 취급한다.

        @Input
            * 첫 번째 줄에 민호가 임의로 만든 DNA 문자열 길이 |S|와 비밀번호로 사용할 부분 문자열의 길이 |P| 가 주어진다. (1 ≤ |P| ≤ |S| ≤ 1,000,000)
            * 두번 째 줄에는 민호가 임의로 만든 DNA 문자열이 주어진다.
            * 세번 째 줄에는 부분 문자열에 포함되어야 할 {‘A’, ‘C’, ‘G’, ‘T’} 의 최소 개수가 공백을 구분으로 주어진다.
              각각의 수는 |S| 보다 작거나 같은 음이 아닌 정수이며 총 합은 |S| 보다 작거나 같음이 보장된다.
            * Example : 9 8 \n CCTGGATTG \n 2 0 1 1
        @OutPut
            * 첫 번째 줄에 민호가 만들 수 있는 비밀번호의 종류의 수를 출력해라.
            * Example : 0
        @시간 제한
            * 2s
        @메모리 제한
            * 512 MB
    */
    public static void main(String[] args) {
        try {
            solution_1();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
        @Desc :
            * Memory Usage : 22416 KB
            * Time Usage :  344 s
        @수도 코드
        1. sudo code
            1-1. S(문자열 크기), P(부분 문자열의 크기), A(문자열 데이터) , checkArr (‘A’, ‘C’, ‘G’, ‘T’ 의 최소 개수) 저장하기
            1-2. 변 수 선언
                myArr(현재 상태 배열)
                checkSecret(몇 개의 문자와 관련된 개수를 충족했는지 판단하는 변수)
                P 범위(0 ~ P-1)만큼 S 배열에 적용하고, 유효한 비밀번호인지 판단
            1-3. i를 P에서 S까지 반복
                {
                    j 선언 (i-P)
                }
    */

    private static int[] myArr = new int[4];

    private static int[] checkArr = new int[4];

    private static void solution_1() throws IOException {
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
