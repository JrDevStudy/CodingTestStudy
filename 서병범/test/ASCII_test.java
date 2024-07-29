package 서병범.test;

import java.util.Scanner;

public class ASCII_test {

    /* 아스키코드
    A : 65 ~  Z : 90
    a : 97 ~  z : 122

     */


    public static void main(String[] args) {
        toASCII();

        fromASCII();

        int_To_char();

    }



    private static void toASCII() {
        // 문자 --> 아스키 코드
        char c = 'A';
        System.out.println((int)c);

        boolean isSame = c==65 ? true : false;
        System.out.println(isSame);

        /*
        65
        true
        */
    }

    private static void fromASCII() {
        // 아스키 코드 --> 문자
        int num = 97;
        char c = (char) num;
        System.out.println(c);

        /*
        a
        */
    }

    private static void int_To_char(){
        Scanner sc = new Scanner(System.in);

        System.out.println("숫자를 입력해주세요.");
        int num = sc.nextInt();
        char ch = (char) num;

        System.out.println(ch);

        /*
        65 입력 -> A
         */
    }


}
