package 정유성;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ_7785 {
    /*
        상근이는 세계적인 소프트웨어 회사 기글에서 일한다. 이 회사의 가장 큰 특징은 자유로운 출퇴근 시간이다.
        따라서, 직원들은 반드시 9시부터 6시까지 회사에 있지 않아도 된다.
        각 직원은 자기가 원할 때 출근할 수 있고, 아무때나 퇴근할 수 있다.
        상근이는 모든 사람의 출입카드 시스템의 로그를 가지고 있다. 이 로그는 어떤 사람이 회사에 들어왔는지, 나갔는지가 기록되어져 있다.
        로그가 주어졌을 때, 현재 회사에 있는 모든 사람을 구하는 프로그램을 작성하시오.

        @Input
            * 첫째 줄에 로그에 기록된 출입 기록의 수 n이 주어진다. (2 ≤ n ≤ 106) 다음 n개의 줄에는 출입 기록이 순서대로 주어지며,
              각 사람의 이름이 주어지고 "enter"나 "leave"가 주어진다. "enter"인 경우는 출근, "leave"인 경우는 퇴근이다.
              회사에는 동명이인이 없으며, 대소문자가 다른 경우에는 다른 이름이다. 사람들의 이름은 알파벳 대소문자로 구성된 5글자 이하의 문자열이다.
            * Example : 4
                        Baha enter
                        Askar enter
                        Baha leave
                        Artem enter
        @OutPut
            * 현재 회사에 있는 사람의 이름을 사전 순의 역순으로 한 줄에 한 명씩 출력한다.
            * Example : Askar
                        Artem
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // HashMap을 사용한 이름과 상태 저장
        // 입력된 이름이 이미 맵에 존재하는 경우 해당 키와 값 쌍을 삭제하고 존재하지 않으면 추가하는 로직
        HashMap<String, String> map = new HashMap<String, String>();

        // n개의 이름과 상태를 입력 받아 HashMap에 추가하거나 제거
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String state = sc.next();

            // HashMap에 이미 해당 이름이 존재하는지 확인
            if (map.containsKey(name)) {
                map.remove(name); // 이미 존재하면 해당 이름을 HashMap에서 제거
            } else {
                map.put(name, state); // 존재하지 않으면 해당 이름과 상태를 HashMap에 추가
            }
        }

        // HashMap의 모든 키(이름)를 ArrayList에 담기
        ArrayList<String> list = new ArrayList<String>(map.keySet());
        // 이름을 역순으로 정렬
        Collections.sort(list, Collections.reverseOrder());

        // 정렬된 이름을 출력
        for(var li : list) {
            // 각 이름을 출력하고 한 칸씩 띄우기
            System.out.print(li + " ");
        }
    }
}