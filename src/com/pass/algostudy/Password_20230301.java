package com.pass.algostudy;

import java.util.Arrays;
import java.util.Scanner;
/*
*  문제 : 암호
*  풀이 :
* 1. 입력 받는다 ( 문자열의 길이, 암호화된 문자)
* 2. 문자열의 길이만큼의 리턴 배열을 생성한다.
* 3. 암호화된 문자를 # -> 이진수의 1, * 이진수의 0으로 변환한다.
* 4. 이진수를 10진수화하여 아스번호의 문자로 치환한다.
* 5. 결과 출력
 */
public class Password_20230301 {
    // Solution
    static class Main {
        public String solution(int cnt,String str) {
            String answer = "";

            str = str.replace("#", String.valueOf(1));
            str = str.replace("*", String.valueOf(0));

            for(int i=0; i< cnt; i++) {
                String forAdd = str.substring(i * 7, (i + 1) * 7);
                // 이진수를 10진수로
                int newStr = Integer.parseInt(forAdd, 2);
                // 10진수를 2진수로 변환후 다시 String.valueOf로 String add
                answer += String.valueOf((char) newStr);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int cnt = kb.nextInt();
        String s = kb.next();
        System.out.println((T.solution(cnt,s)));
    }
}
