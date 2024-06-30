package 서병범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_25542 {

    /*
    포닉스는 친구들과 POSTECH 캠퍼스 근처의 어느 가게에서 만나기로 약속을 했지만 정확한 가게 이름이 기억이 나지 않는다.

    그나마 다행인 점은 가게 이름의 길이가
    'L'이고 알파벳 대문자만으로 구성되었다는 점을 확실하게 기억하고 있고, 희미한 기억을 따라 가게 이름과 비슷한 것 같은 몇 개의 가게 이름 후보를 적어 봤다.

    포닉스는 정확한 가게 이름을 알 수 없으므로 현재 기억나는 가게 이름의 후보들과 최대한 이름이 비슷한 가게를 찾을 것이다.

    'N'개의 가게 이름 후보가 주어질 때, 이 'N'개의 이름 각각과 많아야 한 글자만 다르고 길이가 'L'인 가게 이름을 찾아 보자.
    찾은 가게 이름이 반드시 가게 이름 후보들에 포함될 필요는 없다.

    @Input
         * 첫째 줄에 가게 이름 후보의 수 'N'과 가게 이름의 길이 'L'이 주어진다.
        (1 <= N, L <= 20)

        이후 'N'줄에 걸쳐 가게 이름의 후보가 각 줄에 하나씩 주어진다.
        가게 이름의 후보는 길이가 'L'이고 모두 서로 다르며 알파벳 대문자로만 구성됨이 보장된다.
         * Example :
                    5 5
                    STORR
                    STARE
                    STORE
                    SCORE
                    STONE
    @OutPut
         * 조건을 만족하는 가게 이름을 알파벳 대문자로 출력하여라.
         여러 가지가 가능하다면 그 중 하나만 출력하면 되며, 조건을 만족하는 가게 이름이 존재하지 않는다면 'CALL FRIEND'를 출력하여라.
         * Example : STORE

    @link https://www.acmicpc.net/problem/25542
    */


    public static void main(String[] args) throws IOException {

//        solution1();
        solution2();
    }



    /*
    메모리 : 14128 KB
    시간 : 108 ms
     */
    private static void solution1() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 가게 이름 후보의 수
        int L = Integer.parseInt(st.nextToken()); // 가게 이름의 길이

        String[] candidates = new String[N]; //각 후보 이름을 배열에 저장
        for (int i = 0; i < N; i++) {
            candidates[i] = br.readLine();
        }

        // 첫 번째 후보의 각 자리에 대해 다른 문자를 시도
        for (int i = 0; i < L; i++) {
            for (char c = 'A'; c <= 'Z'; c++) {
                // i번째 자리를 c로 대체한 새로운 후보 이름 생성
                StringBuilder candidateBuilder = new StringBuilder(candidates[0]);
                candidateBuilder.setCharAt(i, c);
                String candidateName = candidateBuilder.toString();

                // 생성된 후보 이름이 다른 모든 후보와 최대 한 글자 차이인지 확인
                boolean isValid = true;
                for (int j = 1; j < N; j++) {
                    int diffCount = 0;
                    for (int k = 0; k < L; k++) {
                        if (candidateName.charAt(k) != candidates[j].charAt(k)) {
                            diffCount++;
                        }
                    }
                    if (diffCount > 1) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    System.out.println(candidateName);
                    return;
                }
            }
        }

        // 조건을 만족하는 가게 이름이 존재하지 않는 경우
        System.out.println("CALL FRIEND");

    }



    /*
    메모리 : 14244 KB
    시간 : 108 ms
     */
    private static void solution2() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 입력 줄을 읽어와서 N과 L을 구함
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        // 후보 가게 이름들을 리스트에 저장
        List<String> candidates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            candidates.add(br.readLine());
        }

        // 첫 번째 후보의 이름을 문자 배열로 변환
        char[] ans = candidates.get(0).toCharArray();

        // 각 위치마다 다른 문자를 시도
        for (int i = 0; i < l; i++) {
            boolean isFound = false;
            for (char c = 'A'; c <= 'Z'; c++) {
                ans[i] = c;
                boolean isValid = true;

                // 모든 후보 이름과 비교
                for (String candidate : candidates) {
                    int cntDiff = 0;
                    for (int j = 0; j < l; j++) {
                        if (candidate.charAt(j) != ans[j]) cntDiff++;
                        if (cntDiff > 1) {
                            isValid = false;
                            break;
                        }
                    }
                    if (!isValid) break;
                }
                if (isValid) {
                    isFound = true;
                    break;
                }
            }
            // 조건에 맞는 문자를 찾지 못했다면 원래 문자를 되돌림
            if (!isFound) ans[i] = candidates.get(0).charAt(i);
        }

        // 최종 이름과 후보들 간의 최대 차이를 계산
        int diffMax = 0;
        for (String candidate : candidates) {
            int diffCur = 0;
            for (int j = 0; j < l; j++) {
                if (candidate.charAt(j) != ans[j]) diffCur++;
            }
            diffMax = Math.max(diffMax, diffCur);
        }

        // 최대 차이가 1을 초과하면 "CALL FRIEND", 그렇지 않으면 최종 이름 출력
        if (diffMax > 1) {
            System.out.println("CALL FRIEND");
        } else {
            System.out.println(new String(ans));
        }

    }




}
