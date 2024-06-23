package 이현재;

import java.io.*;

public class test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] line = br.readLine().split(" ");
            int r = Integer.parseInt(line[0]);
            char[] s = line[1].toCharArray();
            for (char c : s) {
                for (int o = 0; o < r; o++) {
                    System.out.print(c);
                }
            }
            System.out.println();
        }
    }
}
