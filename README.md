# CodingTestStudy

---
## 1. 스터디 진행 방식

### 1-1. 플랫폼
   > Backjoon Online Judge

### 1-2. 커리큘럼
   > 1. 커리큘럼은 스터디 참여 인원의 각자 개인 선호를 따른다.  
   > 2. 책 , 영상 등 자유로운 미디어를 선택하여 진행한다.

### 1-3. 풀이 방식
   > 1. 단순히 문제를 푸는 것이 아닌 자신의 문제 풀이와 더불어 자신이 생각하는 Best Solution을 하나 이상 첨부하도록 한다.
   > 2. 자신이 아닌 다른 참여 인원이 문제와 해답을 보았을 때에 이해가 가능하도록 주석을 친절히 달도록 한다.
   > 3. 전원 Java 11 로 언어를 통일한다.
---

## 2. Git Project 관리 정책
### 2-1. Pkg
* 각자 Pkg의 하위 pkg 구조는 자율
    ```
       com
         ㄴ 임인혁 
         ㄴ 서병범
         ㄴ 이현재
         ㄴ 정유성
    ```

### 2-2. Class
1. BackJoon 문제 풀이 클래스의 경우  
   BOJ_${문제 번호}.java

### 2-3. Commit
1. 주의 사항
   * Build 후 산출되는 .out direcotory 삭제 후 commit

2. Message
   * 임인혁 n월 n주차 코딩테스트 스터디  
     1.baekjoon_${문제 번호}  
     2.baekjoon_${문제 번호}  
   * 이 외 추가 공부사항이 있다면

3. Merge
   * 개인 Study Branch -> Main PR
   * 매 주 일요일 Feature To Main
   
---