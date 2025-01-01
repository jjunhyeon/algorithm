package string;

import java.util.Locale;
import java.util.Scanner;

/*
* 회문 문자열
* 앞에서 읽을떄나 뒤에서 읽을떄나 같은 문자열을 찾아 회문 문자열이라면 true 그렇지 않으면 false
* + 영대소문자도 같은값으로 인식해야함
* 방법
* 1. 문자를 입력 받는다.
* 2. 모두 영소문자로 만든다.
* 3. 해당 문자를 n/2 만큼 가장 앞 글자와, 마지막글자가 일치하는지 확인하며 순회한다.
* 4. 해당결과를 return
* ++ ?
* str에 섞여 있는지 판별해서 그렇다면 소문자또는 대문자로 통일해야하는것인지 아니면 그냥 상관없이
* str = str.toLowerCase(Locale.ROOT); 해도 성능상으로 문제가없을지 의문이다.
* */
public class Palindrome_20230225 {
    // Solution
    static class Main {
        public String solution(String str) {
            boolean result = true;

            str = str.toLowerCase(Locale.ROOT);

            for(int i=0; i<str.length()/2; i++){
                if(!(str.charAt(i) == str.charAt(str.length() -1 - i))){
                    result = false;
                    break;
                }
            }
            return result ? "YES" : "NO";
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
