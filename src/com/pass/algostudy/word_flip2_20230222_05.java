package com.pass.algostudy;

import java.util.Scanner;

/*
*  문제 : 영어 알파벳과 특수문자로 구성된 문자열을 입력받아 알파벳 문자만 서로 뒤집어야함
*  내가 생각한 풀이 :
*  1. str.toCharArray() -> char 배열에 String 담기
*  2. char 배열 순회하면서 각 char 접근
*  3. if 해당 문자가 특수문자인지 아닌지 check
*  4. true -> while문을 활용해 가장 앞 인덱스의 문자와 가장 뒷 인덱스의 문자의 자리를 바꾼다
*  5. 최종 전환 된 string return

*  문자열 검사 : Character.isAlphabetic
*  3. if 해당 문자가 특수문자인지 아닌지 check에서 먼저 아닌경우를 체크해야 한다.
*  왼쪽 문자가 문자가 아닌경우, 오른쪽 문자가 문자가 아닌 경우를 제외하고 else에 처리르 해야한다.
*  그리고 문자열이 아닌 케이스를 확인했을때 먼저 처리를 해야한다 라는 생각을 할 필요가 있는 문제다.
 * */
public class word_flip2_20230222_05 {
    static class Main {
        public String solution(String str) {
            String answer;

            char[] myChar = str.toCharArray();

            int lt = 0;
            int rt = str.toCharArray().length-1;

            while(lt < rt){
                if (!Character.isAlphabetic(myChar[lt])){
                    lt ++;
                } else if (!Character.isAlphabetic(myChar[rt])){
                    rt --;
                } else {
                    char tmp = myChar[lt];
                    myChar[lt] = myChar[rt];
                    myChar[rt] = tmp;
                    lt++;
                    rt--;
                }
            }
            answer = String.valueOf(myChar);
            return answer;
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        String s = kb.nextLine();
        System.out.println(T.solution(s));
    }
}
