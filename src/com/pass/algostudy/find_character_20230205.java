package com.pass.algostudy;

import java.util.Scanner;

public class find_character_20230205 {

    static class Main {
        public int solution(String str, char t) {

            int answer = 0;

            str = str.toUpperCase();
            t = Character.toUpperCase(t);

            char [] strArr = str.toCharArray();

            for(int tmp =0; tmp<strArr.length; tmp++){
                if(t == (strArr[tmp])){
                    answer +=1;
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
