import java.util.*;
class Solution {

    public String solution(String number, int k) {
        
        String result = stackSolution(number, k);
        return result;
    }
    
    public static String stackSolution(String number, int k) {
                StringBuilder result = new StringBuilder();

        Stack<Integer> answer = new Stack<>();

        // 스택을 통해 가장 머리에 있는 값을 다음 number와 비교하면서 만약 다음 number가 크다면 해당 값을 pop한다. 그렇지 않을 경우일때까지 뺀다.
        for(int i=0; i<number.length(); i++){
            int targetNumber = Character.getNumericValue(number.charAt(i));
            while(!answer.isEmpty() && answer.peek() < targetNumber && k > 0 ){
                answer.pop();
                k -- ;
            }
            answer.push(targetNumber);
        }
        
        while(k > 0){
            answer.pop();
            k --;
        }
        
        while (!answer.isEmpty()) {
            result.insert(0,answer.pop());
        }
        

        return result.toString();
    }
}