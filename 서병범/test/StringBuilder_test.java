package 서병범.test;

public class StringBuilder_test {



    public static void main(String[] args) {

        StringBuilder_성능테스트();

        String_Reverse_Practice();
    }


    /**
     * 100,000번의 문자열 연결을 수행
     *
     * String 연결 테스트: 빈 문자열에 "a"를 반복적으로 추가합니다.
     * StringBuilder 테스트: StringBuilder를 사용하여 "a"를 반복적으로 추가합니다.
     *
     *
     * 시간 측정:
     * System.nanoTime()을 사용하여 시작 시간과 종료 시간을 측정한 후, 차이를 계산하여 밀리초 단위로 변환
     *
     * 메모리 사용량 측정:
     * Runtime.getRuntime().totalMemory()와 Runtime.getRuntime().freeMemory()를 사용하여 메모리 사용량을 계산
     *
     * 결과 출력: 각 방법에 대해 소요된 시간과 메모리 사용량을 출력합니다.
     */
    private static void StringBuilder_성능테스트() {
        //반복 횟수 100,000번의 문자열 연결을 수행
        final int ITERATIONS = 100_000;

        // Test using String concatenation
        long startTime = System.nanoTime();
        String testString = "";
        for (int i = 0; i < ITERATIONS; i++) {
            testString += "a";
        }
        long endTime = System.nanoTime();
        long durationString = (endTime - startTime) / 1_000_000; // convert to milliseconds

        // Memory usage for String concatenation
        long memoryString = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();


        // Test using StringBuilder
        startTime = System.nanoTime();
        StringBuilder testStringBuilder = new StringBuilder();
        for (int i = 0; i < ITERATIONS; i++) {
            testStringBuilder.append("a");
        }
        endTime = System.nanoTime();
        long durationStringBuilder = (endTime - startTime) / 1_000_000; // convert to milliseconds

        // Memory usage for StringBuilder
        long memoryStringBuilder = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // Output results
        System.out.println("String concatenation:");
        System.out.println("Time taken: " + durationString + " ms");
        System.out.println("Memory used: " + (memoryString / 1024) + " KB");

        System.out.println("\nStringBuilder:");
        System.out.println("Time taken: " + durationStringBuilder + " ms");
        System.out.println("Memory used: " + (memoryStringBuilder / 1024) + " KB");
    }
    /*
    String concatenation:
    Time taken: 500 ms
    Memory used: 450323 KB

    StringBuilder:
    Time taken: 3 ms
    Memory used: 450629 KB
     */


    /*
    BOJ_1254 - solution2() 참고
     */
    public static void String_Reverse_Practice(){
        String str = "abcde";

        // reverse
        StringBuffer sb = new StringBuffer(str);
        String reversedStr = sb.reverse().toString();

        System.out.println(reversedStr); // edcba
    }

}
