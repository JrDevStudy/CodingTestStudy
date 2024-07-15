package 서병범;

import java.io.*;
import java.util.*;

public class BOJ_25328 {

    /*
    알파벳 소문자로 구성된 문자열 X, Y, Z가 주어진다.
    각각의 문자열에는 중복된 문자가 존재하지 않는다.
    문자열 S에 있는 문자 중 임의로 k개를 선택하여 문자열 S에서의 순서를 유지하여 만든 모든 부분 문자열을 모아 놓은 집합을 문자열 S에 대한 조합 C(S, k)라고 하자.
    예를 들어, 문자열 S = 'abc'에 대한 조합 C(S, 2) = {'ab', 'ac', 'bc'}이다.

    입력으로 문자열 X, Y, Z와 정수 k가 주어질 때 C(X, k), C(Y, k), C(Z, k)에 두 번 이상 나타나는 부분 문자열을 오름차순으로 출력하자.

    제한 :
    1 ≤ 문자열 X, Y, Z의 길이 ≤ 17
    1 ≤ k ≤ 문자열 X, Y, Z 길이의 최솟값
    문자열 X에는 중복된 문자가 존재하지 않는다.
    문자열 Y에는 중복된 문자가 존재하지 않는다.
    문자열 Z에는 중복된 문자가 존재하지 않는다.

    @Input
         * 첫 번째 줄에 문자열 X가 주어진다.
           두 번째 줄에 문자열 Y가 주어진다.
           세 번째 줄에 문자열 Z가 주어진다.
           네 번째 줄에 정수 k가 주어진다.
         * Example :
                    a
                    a
                    a
                    1
    @OutPut
         * C(X, k), C(Y, k), C(Z, k)에 두 번 이상 나타나는 부분 문자열을 오름차순으로 출력한다.
           한 줄에 하나의 부분 문자열을 출력한다.
           두 번 이상 나타나는 부분 문자열이 없으면 -1을 출력한다.
         * Example : a

    @link https://www.acmicpc.net/problem/25328
    */

    public static void main(String[] args) throws IOException {
//        solution1();
        solution2();
    }

    /**
     * 메모리 : 49112 KB
     * 시간 : 744 ms
     * @throws IOException
     */
    public static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String X = br.readLine();
        String Y = br.readLine();
        String Z = br.readLine();
        int k = Integer.parseInt(br.readLine());

        // 부분 문자열을 저장할 Set과 각 부분 문자열의 출현 횟수를 저장할 Map 선언
        Set<String> combinations = new HashSet<>();
        Map<String, Integer> combinationCount = new HashMap<>();

        // 각 문자열에서 길이가 k인 모든 부분 문자열을 생성하고 출현 횟수를 기록한다.
        generateCombinations(X, k, combinations, combinationCount);
        generateCombinations(Y, k, combinations, combinationCount);
        generateCombinations(Z, k, combinations, combinationCount);

        // 두 번 이상 나타나는 부분 문자열을 저장할 리스트 선언
        List<String> result = new ArrayList<>();

        // combinationCount에서 출현 횟수가 2번 이상인 부분 문자열을 찾아 result 리스트에 추가
        for (String combination : combinationCount.keySet()) {
            if (combinationCount.get(combination) > 1) {
                result.add(combination);
            }
        }

        // result 리스트가 비어있으면 -1을 출력하고, 그렇지 않으면 오름차순으로 정렬하여 출력
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            for (String s : result) {
                System.out.println(s);
            }
        }
    }

    /*
    문자열에서 길이가 k인 모든 부분 문자열을 생성하는 메서드
     */
    private static void generateCombinations(String str, int k, Set<String> combinations, Map<String, Integer> combinationCount) {
        int n = str.length();
        generateCombinationsRecursive(str, "", 0, k, combinations, combinationCount);
    }

    /*
    재귀적으로 부분 문자열을 생성하는 메서드
     */
    private static void generateCombinationsRecursive(String str, String current, int index, int k, Set<String> combinations, Map<String, Integer> combinationCount) {
        // 현재 부분 문자열의 길이가 k에 도달하면, Set과 Map에 추가한다.
        if (current.length() == k) {
            combinations.add(current);
            combinationCount.put(current, combinationCount.getOrDefault(current, 0) + 1);
            return;
        }

        // 문자열의 각 문자에 대해 재귀적으로 부분 문자열을 생성한다.
        for (int i = index; i < str.length(); i++) {
            generateCombinationsRecursive(str, current + str.charAt(i), i + 1, k, combinations, combinationCount);
        }
    }


    /**
     * 백준 상위 등수 풀이
     * 메모리 : 25648 KB
     * 시간 : 312 ms
     * @throws IOException
     */
    private static void solution2() throws IOException {

        int k; // 부분 문자열의 길이
        String X, Y, Z; // 입력 문자열
        HashMap<String, Integer> hashmap; // 부분 문자열의 출현 횟수를 저장할 해시맵

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        // 문자열 X, Y, Z와 정수 k 입력 받기
        X = br.readLine();
        Y = br.readLine();
        Z = br.readLine();
        k = Integer.parseInt(br.readLine());

        // 해시맵 초기화
        hashmap = new HashMap<>();

        // 각 문자열에 대해 길이가 k인 모든 부분 문자열 생성 및 출현 횟수 기록
        combination(X, X.length(), 0, 0, new char[k], k, hashmap);
        combination(Y, Y.length(), 0, 0, new char[k], k, hashmap);
        combination(Z, Z.length(), 0, 0, new char[k], k, hashmap);

        // 두 번 이상 나타나는 부분 문자열을 저장할 리스트 초기화
        ArrayList<String> result = new ArrayList<>();
        for(String key : hashmap.keySet()) {
            if(hashmap.get(key) > 1) { // 출현 횟수가 2번 이상인 부분 문자열
                result.add(key);
            }
        }

        // 결과 리스트를 오름차순으로 정렬
        Collections.sort(result);
        if(result.size() == 0) { // 두 번 이상 나타나는 부분 문자열이 없는 경우
            sb.append(-1);
        } else { // 두 번 이상 나타나는 부분 문자열이 있는 경우
            for(int i = 0; i < result.size(); i++) {
                sb.append(result.get(i)).append("\n");
            }
        }

        // 결과 출력
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }


    // 조합을 생성하는 메서드
    public static void combination(String str, int N, int cnt, int index, char[] path, int k, HashMap<String, Integer> hashmap) {
        // 부분 문자열의 길이가 k에 도달하면 해시맵에 추가
        if (cnt == k) {
            String key = new String(path); // 부분 문자열 생성
            if(hashmap.containsKey(key)) { // 이미 존재하는 부분 문자열이면
                int val = hashmap.get(key);
                hashmap.put(key, val + 1); // 출현 횟수를 1 증가
            } else {
                hashmap.put(key, 1); // 처음 등장하는 부분 문자열이면 출현 횟수를 1로 설정
            }
            return;
        }

        // 재귀적으로 부분 문자열을 생성
        for (int i = index; i < N; i++) {
            path[cnt] = str.charAt(i); // 현재 문자를 path에 추가
            combination(str, N, cnt + 1, i + 1, path, k, hashmap); // 다음 문자로 이동
        }
    }



}
