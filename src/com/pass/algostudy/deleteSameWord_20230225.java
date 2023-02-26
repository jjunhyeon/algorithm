package com.pass.algostudy;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;


/*
*  문제 : 중복문자 제거 하기
*  방법 :
* 1. 문자를 입력 받는다
* 2. 입력한 문자의 인덱스를 순회한다.
* 3. Set 자료구조를 활용한다.
* 4. 순회한 값들은 Set에 옮긴다.
* 5. 최총 Set을 다시 순회하며 String으로 리턴한다.
* ++ set은 인터페이스이므로 직접적으로 new Set<String...> 식으로 사용할 수 없음
* ++ 문자열 조작이 적은 경우에는 String을 직접 더하는 방식이 상관없지만 많은 경우에는 성능 문제가 발생할 수 있음.
* 그래서 'StringBuilder'를 사용해 해결 할 수 있음.
* ++ LinkedHashSet : 요소를 저장할 때 추가한 순서대로 유지하면서 중복을 제거한다.
* */
public class deleteSameWord_20230225 {
    // 실제 Solution
    static class Main {
        public String solution(String str) {
            String answer = "";

            // answer += str.charAt(i); 하지 않기 위함
            StringBuilder sb = new StringBuilder();
            Set<Character> noDuplicate = new LinkedHashSet<Character>();

            for(int i =0; i<str.length(); i++){
                noDuplicate.add(str.charAt(i));
            }

            for(Character c : noDuplicate){
                sb.append(c);
            }

            answer = sb.toString();

            return answer;
        }
    }

    /*
    * 값 입력받기
    * */
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String s = kb.nextLine();
        System.out.println(T.solution(s));
    }
}
