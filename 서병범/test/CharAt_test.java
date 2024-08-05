package 서병범.test;

/**
 * BOJ_1254 참고
 */
public class CharAt_test {

    /**
     * <pre>
     *
     * <b>[설명]</b>
     * charAt 메서드는 문자열 str에서 특정 인덱스에 있는 문자를 추출합니다.
     * charAt 메서드는 문자열 내의 특정 위치의 문자를 접근할 때 매우 유용하며, 특히 문자열을 탐색하거나 개별 문자를 처리해야 할 때 자주 사용됩니다.
     *
     * <b>[주의사항]</b>
     * 인덱스는 0부터 시작하며, 문자열의 길이보다 작은 값을 사용해야 합니다.
     * 예를 들어, 길이가 5인 문자열에서는 유효한 인덱스가 0부터 4까지입니다.
     * 그렇지 않으면 StringIndexOutOfBoundsException 이 발생합니다.
     *
     * </pre>
     */
    public static void main(String[] args) {
        String str = "hello";

        // 문자열의 각 문자를 출력
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            System.out.println("Character at index " + i + " is: " + ch);
        }

        // 특정 인덱스의 문자 확인
        char ch = str.charAt(1); // 'e'
        System.out.println("Character at index 1 is: " + ch);
    }

}
