package 정유성;

import java.util.Scanner;

public class BOJ_2675 {
    /*
        문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
        즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. S에는 QR Code "alphanumeric" 문자만 들어있다.
        QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.
        @Input
            * 첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다.
              각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다. S의 길이는 적어도 1이며, 20글자를 넘지 않는다.
            * Example : 2
                        3 ABC
                        5 /HTP
        @OutPut
            * 각 테스트 케이스에 대해 P를 출력한다.
            * Example : AAABBBCCC
                        /////HHHHHTTTTTPPPPP
     */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            //테스트케이스만큼 반복
            int cnt = sc.nextInt();
            String st = sc.next(); // 새로운 문자열을 정리할 String 변수 p 선언
            String p = "";

            for (int j = 0; j < st.length(); j++) { // st문자열의 크기만큼 반복
                for (int k = 0; k < cnt; k++) { // cnt값만큼 문자를 반복
                    p += st.charAt(j); // charAt()함수를 이용해 각 자리에 문자를 추출하여 p에 저장
                }
            }
            System.out.println(p); // for문이 끝나면 새 문자열 p 출력
        }
    }

}
