package year2024.stackorqueue;
import java.util.Scanner;
import java.util.Stack;


public class CorrectBracket_20230320 {
    // 실제 Solution
    static class Main {
        public String solution(String s) {
            String result = "YES";
            Stack<Character> myStack = new Stack<>();
            for(char tmp :s.toCharArray()){
                if(tmp == '('){
                    myStack.push(tmp);
                } else{
                    if(myStack.isEmpty()) {
                        return "NO";
                    } else{
                        myStack.pop();
                    }
                }
            }

            if(!myStack.isEmpty()){
                return "NO";
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
