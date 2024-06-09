package 이현재;

import java.io.IOException;

public class test {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = read();
        int[] lst = new int[n];
        for (int i = 0; i < n; i++) lst[i] = i + 1;
        int m = read();
        for (int j = 0; j < m; j++) {
            int a = read() - 1;
            int b = read() - 1;
            int cnt = (b - a + 1) / 2;
            for (int l = 0; l < cnt; l++) {
                int tmp = lst[a + l];
                lst[a + l] = lst[b - l];
                lst[b - l] = tmp;
            }
        }
        for (int k = 0; k < n; k++) sb.append(lst[k]).append(' ');
        System.out.print(sb);
    }
    static int read() throws IOException{
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
