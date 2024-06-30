package 이현재;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int result = 0;
        for (int i = 0; i < 2; i++) {
            String s = st.nextToken();
            String rev = "" + s.charAt(2) + s.charAt(1) + s.charAt(0);
            int j = Integer.parseInt(rev);
            if(result == 0) {
                result = j;
            } else {
                System.out.println(Math.max(result, j));
            }
        }
    }
}
