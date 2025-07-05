package src.year2024.string;

import java.util.Scanner;

/*
* 회문 문자열2
* 앞에서 읽을떄나 뒤에서 읽을떄나 같은 문자열을 찾아 회문 문자열이라면 true 그렇지 않으면 false
* + 앞 문제와의 차이는 여기엔 문자열 이외에 특수문자 등 다양한 데이터가 들어오는데 이 중 문자열만 식별 후 비교함
* 방법
* 1. 문자를 입력 받는다.
* 2. 영소문자 만든 후 정규식을 사용한다 [^a-z] 소문자가 아닌 모든 문자열에 대해 replaceAll 사용
* 3. StringBuilder를 사용해 2번으로 만든 문자열을 reverse() 한 tmp 문자열을 생성한다.
* 4. str과 tmp를 비교한 결과를 리턴한다.
* */
public class Palindrome2_20230225 {
    // Solution
    static class Main {
        public String solution(String str) {
            boolean result = true;
            str = str.toLowerCase().replaceAll("[^a-z]","");
            String tmp = new StringBuilder(str).reverse().toString();

            if(!str.equals(tmp)){
                result = false;
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
