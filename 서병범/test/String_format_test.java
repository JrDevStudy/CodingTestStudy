package 서병범.test;

import java.util.Date;

/**
 * BOJ_4358 참고
 */
public class String_format_test {

    public static void main(String[] args) {
        String_Format_성능테스트();

        기본적인_문자열_포맷팅();
        소수점_이하_자릿수_지정();
        좌우_정렬_및_최소_너비_지정();
        숫자의_패딩();
        날짜와_시간_포맷팅();
        진수_변환();
        천_단위_구분_기호();
        문자_출력();
        논리값_포맷팅();
        인덱스_기반_포맷팅();

    }

    private static void String_Format_성능테스트() {
        final int ITERATIONS = 100_000;

        // Test using String concatenation with +
        long startTime = System.nanoTime();
        String testStringConcat = "";
        for (int i = 0; i < ITERATIONS; i++) {
            testStringConcat = "Iteration: " + i + ", Value: " + Math.random();
        }
        long endTime = System.nanoTime();
        long durationConcat = (endTime - startTime) / 1_000_000; // convert to milliseconds

        // Memory usage for String concatenation with +
        long memoryConcat = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // Test using String.format
        startTime = System.nanoTime();
        String testStringFormat = "";
        for (int i = 0; i < ITERATIONS; i++) {
            testStringFormat = String.format("Iteration: %d, Value: %.4f", i, Math.random());
        }
        endTime = System.nanoTime();
        long durationFormat = (endTime - startTime) / 1_000_000; // convert to milliseconds

        // Memory usage for String.format
        long memoryFormat = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // Output results
        System.out.println("String concatenation with +:");
        System.out.println("Time taken: " + durationConcat + " ms");
        System.out.println("Memory used: " + (memoryConcat / 1024) + " KB");

        System.out.println("\nString.format:");
        System.out.println("Time taken: " + durationFormat + " ms");
        System.out.println("Memory used: " + (memoryFormat / 1024) + " KB");
    }

    private static void 기본적인_문자열_포맷팅() {
        System.out.println("\n============ 기본적인_문자열_포맷팅 ============");
        String name = "Alice";
        int age = 30;
        String formattedString = String.format("Name: %s, Age: %d", name, age);
        System.out.println(formattedString);
    }

    private static void 소수점_이하_자릿수_지정() {
        System.out.println("\n============ 소수점_이하_자릿수_지정 ============");

        double pi = Math.PI;
        String formattedString = String.format("Pi to 2 decimal places: %.2f", pi);
        System.out.println(formattedString);
    }

    private static void 좌우_정렬_및_최소_너비_지정() {
        System.out.println("\n============ 좌우_정렬_및_최소_너비_지정 ============");

        String leftAligned = String.format("|%-10s|", "Left");
        String rightAligned = String.format("|%10s|", "Right");
        System.out.println(leftAligned);
        System.out.println(rightAligned);
    }

    private static void 숫자의_패딩() {
        System.out.println("\n============ 숫자의_패딩 ============");

        int number = 123;
        String paddedNumber = String.format("%05d", number);
        System.out.println(paddedNumber);
    }

    private static void 날짜와_시간_포맷팅() {
        System.out.println("\n============ 날짜와_시간_포맷팅 ============");

        Date date = new Date();
        String formattedDate = String.format("Current date and time: %tc", date);
        System.out.println(formattedDate);
    }

    private static void 진수_변환() {
        System.out.println("\n============ 진수_변환 ============");

        int number = 255;
        String hexString = String.format("Hex: %x", number);
        String octalString = String.format("Octal: %o", number);
        String binaryString = String.format("Binary: %s", Integer.toBinaryString(number));
        System.out.println(hexString);
        System.out.println(octalString);
        System.out.println(binaryString);
    }

    private static void 천_단위_구분_기호() {
        System.out.println("\n============ 천_단위_구분_기호 ============");

        int largeNumber = 123456789;
        String formattedNumber = String.format("%,d", largeNumber);
        System.out.println(formattedNumber);
    }

    private static void 문자_출력() {
        System.out.println("\n============ 문자_출력 ============");

        char character = 'A';
        String formattedString = String.format("Character: %c", character);
        System.out.println(formattedString);
    }

    private static void 논리값_포맷팅() {
        System.out.println("\n============ 논리값_포맷팅 ============");

        boolean boolValue = true;
        String formattedString = String.format("Boolean: %b", boolValue);
        System.out.println(formattedString);
    }

    private static void 인덱스_기반_포맷팅() {
        System.out.println("\n============ 인덱스_기반_포맷팅 ============");

        String formattedString = String.format("%2$s %1$s %3$s", "first", "second", "third");
        System.out.println(formattedString);
    }

}
