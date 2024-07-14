package 이현재.심화1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class BOJ_2941 {

    /**
     * 크로아티아 알파벳 - 140ms
     *
     * @param args args
     * @throws IOException IOException
     * @see <a href="https://www.acmicpc.net/problem/1157">문제 보기</a>
     */
    public static void main(String[] args) throws IOException {
        // 크로아티아 알파벳
        String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 문자에 크로아티아 알파벳이 몇개인지 확인하기
        String s = br.readLine();
        // 크로아티아 알파벳이 포함된 개수
        int cnt = 0;
        for (String c : arr) {
            // 입력 문자에 크로아티아 알파벳이 포함되는지 확인
            while (s.contains(c)) {
                // 입력 문자에 크로아티아 알파벳의 인덱스 값 확인
                int i = s.indexOf(c);
                String sub = "";
                /*
                크로아티아 알파벳이 시작하는 곳까지 자르기
                자른 문자에 띄어쓰기 문자 추가해서 더하기
                띄어쓰기 문자를 더하지 않으면 따로 잘려서 더해진 문자가
                다시 크로아티아 문자로 인식될 수 있음(nljj : lj 삭제되고 nj만 남음)
                 */
                sub += s.substring(0, i) + " ";
                // 입력 문자의 길이가 크로아티아 알파벳 위치 + 크로아티아 알파벳 길이보다 큰 경우
                if (s.length() > i + c.length() - 1) {
                    sub += s.substring(i + c.length());
                }
                /*
                입력 문자에 포함된 크로아티아 알파벳을 제외한 문자열을 입력 문자 변수에 재할당
                입력 문자에서 첫번째로 확인된 크로아티아 문자만 제거됨
                 */
                s = sub;
                cnt++;
            }
        }
        // 크로아티아 알파벳이 포함된 개수 + 그외 알파벳의 개수
        System.out.println(cnt + s.replace(" ", "").length());
    }

    // 크로아티아 알파벳을 삭제하는게 아닌 다른 문자로 대체하여 풀기 - 100ms
    public static void other(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("c=", "0");
        map.put("c-", "1");
        map.put("dz=", "2");
        map.put("d-", "3");
        map.put("lj", "4");
        map.put("nj", "5");
        map.put("s=", "6");
        map.put("z=", "7");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            str = str.replace(entry.getKey(), entry.getValue());
        }

        System.out.println(str.length());
    }
}
