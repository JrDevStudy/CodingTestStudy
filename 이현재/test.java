package 이현재;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        char[] str = br.readLine().toCharArray();
        int result = 0;
        for (char c : str) {
            result += Integer.parseInt(String.valueOf(c));
        }
        System.out.println(result);
    }
}
