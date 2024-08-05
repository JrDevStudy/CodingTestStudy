package 서병범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.*;

/**
 * 4358번: 생태학
 * <pre>
 *     <b>[문제]</b>
 *     생태학에서 나무의 분포도를 측정하는 것은 중요하다.
 *     그러므로 당신은 미국 전역의 나무들이 주어졌을 때,
 *     각 종이 전체에서 몇 %를 차지하는지 구하는 프로그램을 만들어야 한다.
 *
 *     <b>[입력]</b>
 *     프로그램은 여러 줄로 이루어져 있으며, 한 줄에 하나의 나무 종 이름이 주어진다.
 *
 *     어떤 종 이름도 30글자를 넘지 않으며,
 *     입력에는 최대 10,000개의 종이 주어지고 최대 1,000,000그루의 나무가 주어진다.
 *
 *     입력에는 영문 대소문자와 공백문자, 그리고 숫자, 특수문자만 포함될 수 있다.
 *
 *     <b>[출력]</b>
 *     주어진 각 종의 이름을 사전순으로 출력하고,
 *     그 종이 차지하는 비율을 백분율로 소수점 4째자리까지 반올림해 함께 출력한다.
 * </pre>
 * @see <a href="https://www.acmicpc.net/problem/4358">문제 보기</a>
 */
public class BOJ_4358 {

    public static void main(String[] args) throws IOException {
//        solution1();
        solution2();
    }

    /**
     * TreeMap 사용 :
     * TreeMap에 객체를 저장하면 자동으로 정렬되는데, 키는 저장과 동시에 자동 오름차순으로 정렬된다.
     *
     * 숫자(Integer, Double) 타입일 경우에는 값으로 정렬하고
     * 문자열(String) 타입일 경우에는 유니코드로 정렬한다.
     *
     * 정렬기준 : 숫자 > 알파벳 대문자 > 알파벳 소문자 > 한글
     *
     * 메모리 : 91800 KB
     * 시간 : 912 ms
     * @throws IOException
     */
    public static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> treeCountMap = new TreeMap<>();
        String treeName;
        int totalTrees = 0;

        // 나무 종 이름 입력받기 및 출현 횟수 기록
        while ((treeName = br.readLine()) != null && !treeName.isEmpty()) {
            /*
            getOrDefault : 키가 존재하면 그 값을 반환하고 만약 키가 존재하지 않으면, 기본값(defaultValue)을 반환
             */
            treeCountMap.put(treeName, treeCountMap.getOrDefault(treeName, 0) + 1);
            totalTrees++;
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : treeCountMap.entrySet()) {
            String name = entry.getKey();
            int count = entry.getValue();
            double percentage = (count / (double) totalTrees) * 100;
            sb.append(String.format("%s %.4f%n", name, percentage));
        }
        System.out.print(sb.toString());
    }

    /**
     * 백준 상위 등수 풀이
     * HashMap, ArrayList 활용 성능 최적화
     *
     * (1)
     * HashMap은 TreeMap보다 삽입, 삭제, 조회 작업이 평균적으로 더 빠름.
     * 시간 복잡도 :
     *          HashMap - O(1) 해시 기반 구조
     *          TreeMap O(log n) 트리 기반 구조
     *
     * (2)
     * TreeMap을 사용하면 삽입할 때마다 정렬 작업이 필요
     * 반면, 이 풀이에서는 나무 종의 이름을 ArrayList에 저장한 후, 한 번만 정렬한다.
     *
     * (3) 메모리 효율성
     * TreeMap은 각 노드에 부모, 왼쪽 자식, 오른쪽 자식에 대한 참조를 포함하는 트리 구조를 유지하는 반면,
     * HashMap은 단순히 키와 값 쌍을 저장하는 배열 기반 구조로 더 적은 메모리를 사용한다.
     *
     * 메모리 :  89748 KB
     * 시간 :  472 ms
     *
     * @throws IOException
     */
    public static void solution2() throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        HashMap hashMap = new HashMap<String, Integer>();
        int totalCnt = 0;

        // 나무 종 이름 입력받기 및 출현 횟수 기록
        while (true){
            String str = input.readLine();
            if(str==null || str.length()==0){
                break;
            }
            hashMap.put(str, (int)hashMap.getOrDefault(str, 0)+1);
            totalCnt++;
        }

        // 키셋을 리스트에 저장한 후 정렬
        List<String> treeList = new ArrayList<>(hashMap.keySet());
        Collections.sort(treeList);

        // 결과 출력
        for(String s : treeList){
            int treeCnt = (int) hashMap.get(s);
            double d = (double) treeCnt*100.0/totalCnt;

            output.append(s)
                    .append(" ")
                    .append(String.format("%.4f",d))
                    .append("\n");
        }

        System.out.println(output);

    }




}
