package 서병범.test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class BufferedWriter_test {

    public static void main(String[] args) throws IOException {

        // System.out.println() 테스트
        long startTime = System.currentTimeMillis();
        printlnTest();
        long endTime = System.currentTimeMillis();
        System.out.println("System.out.println() execution time: " + (endTime - startTime) + " ms");


        // BufferedWriter 테스트
        startTime = System.currentTimeMillis();
        bufferedWriterTest();
        endTime = System.currentTimeMillis();
        System.out.println("BufferedWriter execution time: " + (endTime - startTime) + " ms");
    }
    /*
    System.out.println() execution time: 2354 ms

    BufferedWriter execution time: 203 ms
     */



    private static void printlnTest() {
        for (int i = 0; i < 1000000; i++) {
            System.out.println(i);  // 매 출력마다 즉시 출력
        }
    }

    private static void bufferedWriterTest() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 1000000; i++) {
            bw.write(i + "\n");  // 데이터를 버퍼에 쌓고, 한꺼번에 출력
        }
        bw.flush();  // 버퍼에 남은 데이터를 강제로 출력
//        bw.close();
        /*
        bw.close():
        BufferedWriter가 내부적으로 OutputStreamWriter와 System.out 스트림까지 닫아버리기 때문에, 이후에 System.out.println을 호출해도 출력이 되지 않음.

        부가 설명 :
        BufferedWriter는 OutputStreamWriter를 감싸고 있으며, System.out은 기본적으로 PrintStream 객체입니다.
        System.out을 BufferedWriter로 감싸고 close()를 호출하면, 이 스트림이 닫히게 됩니다.
        그 결과, System.out.println도 더 이상 사용할 수 없게 됩니다.
         */
    }
}
