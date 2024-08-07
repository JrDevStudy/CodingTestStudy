package 이현재;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = 0;
        int row = 1;
        int col = 1;
        for (int i = 0;  i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n > max) {
                    max = n;
                    row = i + 1;
                    col = j + 1;
                }
            }
        }
        System.out.println(max + "\n" + row + " " + col);
    }
}
