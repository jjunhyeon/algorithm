import java.util.*;
class Solution {

    public String solution(String number, int k) {
        
        String result = stackSolution(number, k);
        return result;
    }
    
    public static String stackSolution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int len = number.length();
        for (int i = 0; i < len; i++) {
            char currentDigit = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < currentDigit && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(currentDigit);
        }

        // 남은 자릿수 중 뒤에서부터 k개 제거
        while (k > 0) {
            stack.pop();
            k--;
        }

        // 스택에 남은 숫자를 문자열로 변환
        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            // 스택은 뒤에서부터, builder에는 0번째부터 추가하기 위함
            answer.insert(0, stack.pop());
        }
        return answer.toString();
    }
}