package string;

import java.util.Scanner;

/*
*  문제 : 문자열 압축
*  설명 : 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
*  출력 : 첫 줄에 압축된 문자열을 출력한다.
*  풀이 :
*  1. 문자열을 입력받는다.
*  2. 문자열을 순회하면서
*   2-1 만약 같은 문자열일 시 값 임의의 int 값 누적
*   2-2 그렇지 않으면 문자 자체를 더한다. 더할 때 누적된 int의 값이 1보다 클 경우 int 값도 누적시킨 후 int 를 1로 초기화한다.
*  3. 누적 변수 리턴
*
*
* */
public class WordCompression_20230228 {
    // Solution
    static class Main {
        public String solution(String str) {
            String result = "";
            int cnt = 1;

            for (int i = 0; i < str.length(); i++) {
                if (i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1)) {
                    result += str.charAt(i);
                    if (cnt > 1) {
                        result += cnt;
                        cnt = 1;
                    }
                } else {
                    cnt++;
                }
            }

            return result;
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        String s = kb.next();
        System.out.println(T.solution(s));
    }
}
