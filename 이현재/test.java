package 이현재;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        Arrays.setAll(arr, i -> i + 1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j = Integer.parseInt(st.nextToken()) - 1;
            int k = Integer.parseInt(st.nextToken()) - 1;
            for (int q = 0; q < (j + k)/2; q++) {
                if (j + q == k - q) break;
                int temp = arr[j + q];
                arr[j + q] = arr[k - q];
                arr[k - q] = temp;
            }
        }

        for (int a : arr) bw.write(a + " ");

        bw.flush();
    }
}
