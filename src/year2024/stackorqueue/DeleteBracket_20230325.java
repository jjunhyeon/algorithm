package year2024.stackorqueue;

import java.util.Scanner;
import java.util.Stack;

/*
* 괄호문자 제거
* 입력받은 문자열의 괄호문자를 제거하는 문제
* + Stack의 pop은 제일 상단의 문자열을 뽑을뿐만아니라 해당 문자를 리턴까지한다.
* */
public class DeleteBracket_20230325 {
    // 실제 Solution
    static class Main {
        public String solution(String s) {
            String result = "";
            Stack<Character> myStack = new Stack<>();

            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == ')'){
                    while(myStack.pop() != '('){

                    };
                } else {
                    myStack.push(s.charAt(i));
                }
            }

           for(int i=0; i<myStack.size(); i++){
               result += myStack.get(i);
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

        String param = kb.nextLine();

        System.out.println(T.solution(param));
    }
}
