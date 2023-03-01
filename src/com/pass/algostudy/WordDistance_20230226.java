package com.pass.algostudy;

import java.util.Scanner;

/* 문제 : 문자거리
 파라미터로 들어온 char c와 String str에 동일한 char 문자와의 거리를 출력하는 문제
 char c와 다른 배열의 값들을 비교해본다.
 첫 시도 해결못함 --
 방법1 : 왼쪽 for문 한번 , 오른쪽 for문 순회 후 비교해서 처리*/
public class WordDistance_20230226 {
    static class Main {
        public int[] solution(String str,char c) {
            int[] answer = new int[str.length()];

            int p = 1000;
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) == c){
                    p = 0;
                    answer[i] = p;
                } else {
                    p++;
                    answer[i] = p;
                }
            }

            p = 1000;
            for(int j=str.length()-1; j>=0; j--){
                if(str.charAt(j) == c){
                    p = 0;
                } else {
                    p++;
                    answer[j]= Math.min(answer[j], p);
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        String str = kb.next();
        char c = kb.next().charAt(0);
        for(int x : T.solution(str,c)){
            System.out.print((x + " "));
        }
    }
}
