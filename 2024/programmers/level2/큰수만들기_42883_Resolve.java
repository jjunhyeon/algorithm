package programmers.level2;


import java.util.Stack;

/*
 * 큰수만들기
 * */
public class 큰수만들기_42883_Resolve {
    public static void main(String[] args) {

        String number = "4321";
        int k = 1;
        solution(number, k);
    }

    private static String solution(String number, int k) {
        StringBuilder result = new StringBuilder();

        Stack<Integer> answer = new Stack<>();

        // 스택을 통해 가장 머리에 있는 값을 다음 number와 비교하면서 만약 다음 number가 크다면 해당 값을 pop한다. 그렇지 않을 경우일때까지 뺀다.
        for (int i = 0; i < number.length(); i++) {
            int targetNumber = Character.getNumericValue(number.charAt(i));
            while (!answer.isEmpty() && (answer.peek() < targetNumber) && (k > 0)) {
                answer.pop();
                k--;
            }
            answer.push(targetNumber);
        }

        // number가 이미 큰 값으로 들어온 케이스에 대해서 k값만 살아있는 경우에 대한 처리(테케 12번)
        while (k > 0) {
            answer.pop();
            k--;
        }

        while (!answer.isEmpty()) {
            result.insert(0, answer.pop());
        }

        return result.toString();
    }
}
