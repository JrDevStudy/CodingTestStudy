package 이현재.심화1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_25206 {

    /**
     * 너의 평점은 - 128ms
     *
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/25206">문제 보기</a>
     */
    public static void main00(String[] args) throws IOException {
        Map<String, Double> gpa = getGPAMap(); // 과목평점
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double totalCredit = 0.0; // 총 학점
        double creditMultiplyGPA = 0.0; // 학점 * 평점(gpa value 값)
        for (int i = 0; i < 20; i++) {
            String[] transcript = br.readLine().split(" ");
            double credit = Double.parseDouble(transcript[1]); // 학점
            String grade = transcript[2]; // 등급
            if (gpa.get(grade) == null) continue; // gpa map 에 없으면 P 학점이므로 계산하지 않는다.
            totalCredit += credit;
            creditMultiplyGPA += credit * gpa.get(grade);
        }
        if (totalCredit == 0) { // 총 학점으로 나눠야 하는데 실수형을 0으로 나누게 되면 NaN 또는 infinity 값이 나온다.
            System.out.println(0.0000);
        } else {
            System.out.println(creditMultiplyGPA / totalCredit);
        }
    }

    // 128ms
    public static void main(String[] args) throws IOException {
        Map<String, Double> gpa = getGPAMap();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double totalCredit = 0.0;
        double creditMultiplyGPA = 0.0;
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            if (gpa.get(grade) == null) continue;
            totalCredit += credit;
            creditMultiplyGPA += credit * gpa.get(grade);
        }
        System.out.println(creditMultiplyGPA / totalCredit);
    }

    private static Map<String, Double> getGPAMap() {
        Map<String, Double> gpa = new HashMap<>();
        gpa.put("A+", 4.5);
        gpa.put("A0", 4.0);
        gpa.put("B+", 3.5);
        gpa.put("B0", 3.0);
        gpa.put("C+", 2.5);
        gpa.put("C0", 2.0);
        gpa.put("D+", 1.5);
        gpa.put("D0", 1.0);
        gpa.put("F", 0.0);
        return gpa;
    }
}
