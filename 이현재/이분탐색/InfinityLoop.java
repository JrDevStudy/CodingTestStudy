package 이현재.이분탐색;

public class InfinityLoop {

    /**
     * 이분탐색 무한루프 예시
     * <pre>
     *     target 이 16일 때 기대값은 16의 인덱스 -1 인 3
     *     아래 로직을 실행하면 무한루프에 빠진다.
     *     이유는 st = 2, en = 3 인 상태에서 벗어나지 못하기 때문인데
     *     mid 값을 정확히 구할 수 없는게 원인이다.
     *     따라서 mid 값을 구하는 연산에서 +1 을 추가하고 2로 나누면 해결된다.
     *     이분 탐색 문제 풀이 시 주의하자.
     * </pre>
     *
     * @param args args
     */
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 11, 16, 19, 22, 22, 22, 32};
        int target = 16;
        System.out.println(binarySearch(arr, target));
    }

    // lowerBound - 1 인덱스 값 찾기
    private static int binarySearch(int[] arr, int target) {
        int st = -1;
        int en = arr.length - 1;
        System.out.println("st = " + st);
        System.out.println("en = " + en);
        while (st < en) {
            int mid = (st + en) / 2;
            System.out.println("mid = " + mid);
            if (arr[mid] < target) st = mid;
            else en = mid - 1;
            System.out.println("st = " + st);
            System.out.println("en = " + en);
        }
        return st;
    }
}
