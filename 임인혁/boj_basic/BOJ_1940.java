package 임인혁.boj_basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1940 {

    /*
        주몽은 철기군을 양성하기 위한 프로젝트에 나섰다.
        그래서 야철대장을 통해 철기군이 입을 갑옷을 만들게 하였다.
        야철대장은 주몽의 명에 따르기 위하여 연구에 착수하던 중 아래와 같은 사실을 발견하게 되었다.
        갑옷을 만드는 재료들은 각각 고유한 번호를 가지고 있다.
        갑옷은 두 개의 재료로 만드는데 두 재료의 고유한 번호를 합쳐서 M(1 ≤ M ≤ 10,000,000)이 되면 갑옷이 만들어 지게 된다.
        야철대장은 자신이 만들고 있는 재료를 가지고 갑옷을 몇 개나 만들 수 있는지 궁금해졌다.
        이러한 궁금증을 풀어 주기 위하여 N(1 ≤ N ≤ 15,000) 개의 재료와 M이 주어졌을 때 몇 개의 갑옷을 만들 수 있는지를 구하는 프로그램을 작성하시오.
        @Input
            * 첫째 줄에는 재료의 개수 N(1 ≤ N ≤ 15,000)이 주어진다.
            * 두 번째 줄에는 갑옷을 만드는데 필요한 수 M(1 ≤ M ≤ 10,000,000) 주어진다.
            * 그리고 마지막으로 셋째 줄에는 N개의 재료들이 가진 고유한 번호들이 공백을 사이에 두고 주어진다.
            * 고유한 번호는 100,000보다 작거나 같은 자연수이다.
            * Example : 6 \n 9 \n 2 7 4 1 5 3
        @OutPut
            * 첫째 줄에 갑옷을 만들 수 있는 개수를 출력한다.
            * Example : 2
        @시간 제한
            * 2s
        @메모리 제한
            * 128 MB
    */
    public static void main(String[] args) {
        try {
            solution_1();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
        @Desc : Two Pointer를 사용한 문제 풀이
            * Memory Usage : 21212
            * Time Usage : 236
        @수도 코드
        1. sudo code
            1-1. N(재료의 개수), M(갑옷이 되는 번호) 저장하기
            1-2. for (N만큼 반복)
                {
                    재료 배열 저장하기
                }
            1-3. while (N만큼 반복)
                {
                    if (재료 합 < M) 작은 번호 재료를 한 칸 위로 변경하기
                    else if (재료 합 > M) 큰 번호 재료를 한 칸 아래로 변경하기
                    else 경우의 수 증가, 양쪽 index 각각 변경하기
                }
    */
    private static void solution_1() throws IOException {
        // 1. stream 변수 정의
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N(재료의 개수), M(갑옷이 되는 번호), a(재료의 고유 번호) 저장하기
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 정렬 후 반복하며 two pointer 실행
        Arrays.sort(a);
        // 3-1. 시작 포인터
        int startIndex = 0;
        // 3-2. 마지막 포인터
        int endIndex = n - 1;
        int result = 0;
        while (startIndex < endIndex) {
            int sum = a[startIndex] + a[endIndex];
            if (sum < m) {
                startIndex++;
            } else if (sum > m) {
                endIndex--;
            } else {
                startIndex++;
                endIndex--;
                result++;
            }
        }
        bw.write(result + " ");
        bw.flush();
    }

}
