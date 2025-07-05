package src.year2024.array;

import java.util.Scanner;

/*
* 가위 바위 보
* 두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작
* 풀이
* 1. 첫 줄에는 게임 횟수, 두번째 줄에는 A가 낸 정보 세번째 줄에는 B가 낸 정보
* 2. 반복문 돌면서 값 비교 후 처리
* 2-1 먼저 비기는 경우를 처리 , A가 이기는 경우만 처리(else-if *3) 나머지 else B 승리
* 3. 결과 정보 리턴
* */
public class RockPaperScissors_20230305 {
    // 실제 Solution
    static class Main {
        public String solution(int s, int[] a,  int[] b) {
            String result ;
            StringBuilder str = new StringBuilder();
            // 1: 가위 2: 바위 3:보
            for(int i=0; i<s; i++){
                if(a[i] == b[i]){
                    // 비길경우 D
                    str.append("D");
                } else if(a[i] == 1 && b[i] == 3){
                    str.append("A");
                } else if(a[i] == 2 && b[i] == 1){
                    str.append("A");
                } else if(a[i] == 3 && b[i] == 2){
                    str.append("A");
                } else {
                    str.append("B");
                }
            }
            result = str.toString();
            return result;
        }
    }

    /*
     * 값 입력받기
     * */
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int cnt = kb.nextInt();
        int[] a = new int[cnt];
        int[] b = new int[cnt];
        for(int i=0; i<cnt; i++){
            a[i] = kb.nextInt();
        }

        for(int i=0; i<cnt; i++){
            b[i] = kb.nextInt();
        }

        for(char c : T.solution(cnt,a,b).toCharArray()){
            System.out.println(c);
        }
    }
}
