package stackorqueue;
import java.util.Scanner;
import java.util.Stack;

/*
 * 막대기
 * ) 를 만났지만 이전 char 값이 ( 라면 cutting 
 * ) 를 만났지만 이전 char 값이 ) 라면 그건 이전 (를 닫는것이다
 * 라는걸 생각할 수 있어야했다.
 * */
public class Stick_20230402 {
    static class Main {
        public int solution(String s) {
            int result = 0;

            Stack<Character> myStack = new Stack<>();
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '('){
                    myStack.push(s.charAt(i));
                } else {
                    if(s.charAt(i-1) == '('){
                        myStack.pop();
                        result += myStack.size();
                    } else if(s.charAt(i-1) == ')'){
                        myStack.pop();
                        result += 1;
                    }
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
        String param = kb.nextLine();

        System.out.println(T.solution(param));
    }
}
