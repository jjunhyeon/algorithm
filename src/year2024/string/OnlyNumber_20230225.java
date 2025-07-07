package year2024.string;

import java.util.Scanner;

/*
* 숫자만 추출
* 방법
* 1. 문자를 입력 받는다.
* 2. 받은 값을 순회하며 숫자가 있는지 식별한다.
* 3. 식별한 값을 최종 return 하면 안된다.
* 4. return 하기 이전에 첫 글자가 0 인지 확인
* 5. 0이라면 그 while문을 통해 0이 아닌 값을 찾아 그 자리의 값까지 substinrg 처리한 부분을 리턴한다.
* ++ 단순 append 보다 StringBuilder 객체에 담아 최종 문자열로 반환했다.
* 왜 ? :  성능 상의 이슈 문제 발생 가능성 방지
*
* + 추가 : 첫 글자가 0 체크 부분을 int로 치환하면 더 쉽게 할 수 있다.
* +++ Integer.parseInt(sb.toString())
*
* */
public class OnlyNumber_20230225 {
    // Solution
    static class Main {
        public String solution(String str) {

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<str.length(); i++){
                if(Character.isDigit(str.charAt(i))){
                    sb.append(str.charAt(i));
                }
            }

            String result = sb.toString();
            if(result.charAt(0) == '0') {
                int i = 1;
                while(i < result.length() && result.charAt(i) == '0') {
                    i++;
                }
                if(i == result.length()) {
                    return "0";
                } else {
                    return result.substring(i);
                }
            }
            
            return result;
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
