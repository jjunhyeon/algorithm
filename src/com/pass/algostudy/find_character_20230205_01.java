package com.pass.algostudy;

import java.util.Scanner;

public class find_character_20230205_01 {

    static class Main {
        public int solution(String str, char t) {

            int answer = 0;

            str = str.toUpperCase();
            t = Character.toUpperCase(t);

            /* 1. 그냥 일반 for문
            char [] strArr = str.toCharArray();
            for(int tmp =0; tmp<strArr.length; tmp++){
                if(t == (strArr[tmp])){
                    answer +=1;
                }
            }*/

            /* 2. 향상 for문 사용
            str.toCharArray() 리턴 방식
            return isLatin1() ? StringLatin1.toChars(value)
                    : StringUTF16.toChars(value);
            isLatin1() 체크를 통해 StringLantin1 / StringUTF16 으로 나누어 처리한다. 
            */

            for(char tmp: str.toCharArray()){
                if(tmp == t){
                    answer += 1;
                }
            }

            return answer;
       }
        public static void main(String[] args) {
            Main T  = new Main();
            Scanner kb = new Scanner(System.in);
            String str = kb.next();
            char c = kb.next().charAt(0);

            System.out.println(T.solution(str,c));
        }
    }
}
