package com.pass.algostudy;

import java.util.Arrays;
import java.util.Scanner;

/*
* String Sentence 파라미터로 받아  
* 가장 긴 단어를 출력해야한다.
* indexOf() - 특정 문자나 문자열에서 해당하는 문자의 인덱스 값을 반환하고 찾지 못했을 경우 "-1" return
* lastIndexOf() - 특정 문자나 문자열에서 해당하는 문자를 뒤에서 부터 찾는다. (indexOf와 동일하며 뒤에서 찾는다는 속성이 추가)
*/

public class word_in_sentence_20220211_03 {
    static class Main {
        public String solution(String sentence) {
            /*
            * split: parm 구분으로 단어를 배열에 넣는다.
            * indexOf : param 단어 발견 못할 시 -1 return
            * 초기화 : Integer의 최솟값 (-2147483648)
            * 저장된 단어들을 탐색하며 단어의 길이가 이전에 저장한 단어의 길이보다 커지면 결과 String을 대체한다.
            * */
            String[] s = sentence.split(" ");
            String result = "";
            int m = Integer.MIN_VALUE;

            for(String tmp : s){
                int ren = tmp.length();
                if(ren > m) {
                    m = ren;
                    result = tmp;
                }
            }

            return result;
        }
    }
        public static void main(String[] args) {
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            String str = kb.nextLine();
            System.out.println(T.solution(str));
        }
}
