package 서병범;

import java.io.*;
import java.util.*;

/**
 * 1302번: 베스트셀러
 * <pre>
 *     <b>[문제]</b>
 *     김형택은 탑문고의 직원이다. 김형택은 계산대에서 계산을 하는 직원이다.
 *     김형택은 그날 근무가 끝난 후에, 오늘 판매한 책의 제목을 보면서 가장 많이 팔린 책의 제목을 칠판에 써놓는 일도 같이 하고 있다.
 *
 *     오늘 하루 동안 팔린 책의 제목이 입력으로 들어왔을 때, 가장 많이 팔린 책의 제목을 출력하는 프로그램을 작성하시오.
 *
 *     <b>[입력]</b>
 *     첫째 줄에 오늘 하루 동안 팔린 책의 개수 N이 주어진다.
 *     이 값은 1,000보다 작거나 같은 자연수이다. 둘째부터 N개의 줄에 책의 제목이 입력으로 들어온다.
 *     책의 제목의 길이는 50보다 작거나 같고, 알파벳 소문자로만 이루어져 있다.
 *
 *     Example :
 *     5
 *     top
 *     top
 *     top
 *     top
 *     kimtop
 *
 *     <b>[출력]</b>
 *     첫째 줄에 가장 많이 팔린 책의 제목을 출력한다.
 *     만약 가장 많이 팔린 책이 여러 개일 경우에는 사전 순으로 가장 앞서는 제목을 출력한다.
 *     Example :
 *     top
 *
 * </pre>
 * @see <a href="https://www.acmicpc.net/problem/1302">문제 보기</a>
 */
public class BOJ_1302 {

    public static void main(String[] args) throws IOException {
//        solution1();
        solution2();
    }

    /**
     * HashMap 사용
     *
     * 1. HashMap을 사용하여 책 제목과 그 제목의 판매 횟수를 저장
     * 2. getOrDefault 메서드를 사용하여 기존에 없던 책 제목일 경우 0을 반환하고, 새로 빈도 1을 더해줌
     * 3. 각 책의 빈도를 계산하면서, 그 빈도가 현재 최대 빈도보다 크다면, bestSeller 변수를 갱신
     * 4. 만약 빈도가 같을 경우에는 compareTo 메서드를 사용해 사전순으로 비교하여 더 앞서는 책 제목으로 갱신
     *
     * 시간 복잡도: O(N) - 각 책 제목에 대해 HashMap에 접근하여 빈도/최빈값을 갱신. (N은 주어진 책의 수)
     * 공간 복잡도: O(U) - 책의 제목을 키로 사용하여 HashMap에 저장. (U는 서로 다른 책 제목의 수. 일반적으로 U는 N보다 작거나 같으므로, 최악의 경우 O(N)의 공간이 필요)
     *
     * 메모리 : 14140 KB (실행 시 측정되는 메모리 사용량)
     * 시간 : 100 ms (실행 시 측정되는 실행 시간)
     * @throws IOException
     */
    public static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> bookMap = new HashMap<>();
        String bestSeller = "";
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            bookMap.put(book, bookMap.getOrDefault(book, 0) + 1);

            // 최빈값과 사전순으로 가장 앞선 책 제목 갱신
            int count = bookMap.get(book);
            if (count > maxCount || (count == maxCount && book.compareTo(bestSeller) < 0)) {
                maxCount = count;
                bestSeller = book;
            }
        }

        System.out.println(bestSeller);
    }

    /*
    HashMap의 장점

    1. 빠른 데이터 접근
    시간 복잡도 O(1): HashMap은 키-값 쌍을 기반으로 데이터를 저장하고 관리하는 자료구조입니다. 내부적으로 배열과 해싱 기법을 사용해 키를 기반으로 데이터를 저장하고, 이를 통해 상수 시간에 원하는 데이터에 접근할 수 있습니다.
    책 제목을 키로, 해당 책 제목의 판매 횟수를 값으로 저장할 때, 특정 책의 판매 횟수를 조회하거나 갱신하는 작업이 **O(1)**에 이루어지므로 매우 효율적입니다.

    2. 유연한 데이터 관리
    자동 키 관리: HashMap은 입력된 키가 이미 존재하는지 여부를 자동으로 관리해줍니다. 이 기능을 통해 HashMap은 새로운 책 제목이 추가될 때, 해당 책이 처음 등장하는 것인지, 아니면 이미 등장해서 판매 횟수를 증가시켜야 하는지 자동으로 처리할 수 있습니다.
    기본값 설정 (getOrDefault): HashMap의 getOrDefault 메서드를 사용하면, 특정 키에 해당하는 값이 없을 때 기본값을 반환하게 할 수 있습니다. 이 기능을 사용하면 코드를 간결하게 유지할 수 있습니다.

    3. 효율적인 메모리 사용
    공간 복잡도 O(N): HashMap은 적절한 메모리를 사용하면서 필요한 데이터를 효율적으로 저장할 수 있습니다. 책 제목의 수에 비례하는 메모리를 사용하며, 큰 데이터를 처리할 때도 안정적인 성능을 유지합니다.
     */



    /**
     * 백준 상위 등수 풀이
     *
     * TreeMap 사용
     * - TreeMap은 자연스럽게 키(책 제목)를 정렬하여 관리하기 때문에, 이후에 사전순으로 가장 앞서는 제목을 출력할 때 유용
     * - keySet을 사용해 순회하며 최대값을 찾는 방식이 직관적
     *
     * 메모리 :  12016 KB
     * 시간 :  72 ms
     *
     * @throws IOException
     */
    public static void solution2() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int max = -1;
        TreeMap<String, Integer> map = new TreeMap<>();

        for(int i=0; i<N; i++){
            String book = br.readLine();

            if(!map.containsKey(book)){
                map.put(book, 0);
            }
            map.put(book, map.get(book)+1);
            if(max < map.get(book)){
                max = map.get(book);
            }
        }

        /*
        TreeMap.keySet() : TreeMap에 있는 모든 키가 정렬된 순서로 반환
         */
        for(String t : map.keySet()){
            if(map.get(t) == max){
                System.out.println(t);
                break;
            }
        }
    }

    /*
    HashMap vs TreeMap

    1. 기본 구조
        HashMap: 내부적으로 해시 테이블을 사용하여 데이터를 저장합니다. 키와 값은 해시 함수를 통해 빠르게 접근할 수 있습니다.
        TreeMap: 레드-블랙 트리(Red-Black Tree)라는 이진 검색 트리 자료 구조를 사용하여 데이터를 저장합니다. 키가 항상 정렬된 상태로 유지됩니다.

    2. 정렬
        HashMap: 키는 정렬되지 않음. 입력된 순서와 출력된 순서는 다를 수 있습니다.
        TreeMap: 키가 자연스럽게 정렬됩니다. 기본적으로 키의 자연 순서(예: 숫자는 오름차순, 문자열은 알파벳 순)로 정렬되며, 커스텀 정렬 기준을 제공할 수도 있습니다.

    3. 성능
    HashMap:
        시간 복잡도: 평균적으로 O(1)의 시간 복잡도로 데이터를 검색, 삽입, 삭제할 수 있습니다.
        공간 복잡도: 키를 해싱하고 관리하는데 추가 메모리를 사용합니다.
    TreeMap:
        시간 복잡도: 검색, 삽입, 삭제에 모두 O(log n)의 시간 복잡도가 소요됩니다. 이는 레드-블랙 트리의 특성 때문입니다.
        공간 복잡도: 키와 값을 트리 구조로 관리하기 때문에 HashMap에 비해 약간 더 많은 메모리를 사용합니다.

    4. 순서 유지
        HashMap: 순서가 유지되지 않습니다.
        TreeMap: 키의 순서가 유지되므로 순차적인 순회가 가능하고, 항상 정렬된 순서로 데이터를 반환합니다.

    5. null 키 허용
        HashMap: null 키를 허용합니다. 여러 개의 null 값을 가질 수는 있지만, null 키는 오직 하나만 존재할 수 있습니다.
        TreeMap: null 키를 허용하지 않습니다. null 키를 삽입하면 NullPointerException이 발생합니다.

    6. 사용 사례
        HashMap: 빠른 조회가 필요하지만 키의 순서가 중요하지 않은 경우에 사용됩니다. 예를 들어, 데이터베이스의 인덱스 맵핑이나 캐시 등에 적합합니다.
        TreeMap: 키가 항상 정렬된 상태로 유지되어야 하는 경우에 사용됩니다. 예를 들어, 범위 검색이나 자연 순서에 따라 데이터를 순회할 때 유용합니다.

    요약
    **HashMap**은 속도가 중요하고 키의 순서가 중요하지 않은 상황에서 사용됩니다.
    **TreeMap**은 키의 정렬이 필요하거나 특정 순서에 따라 데이터가 관리되어야 할 때 사용됩니다.
     */
}
