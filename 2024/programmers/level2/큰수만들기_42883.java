package programmers.level2;

import java.util.Stack;

/*
 * 그리디
 * number -> 기준 number
 * k -> 기준 number에서 제거해야할 값의 개수
 * dfs를 탐색하면서 k개의 수를 제거한 수중 가장 큰 수를 리턴한다.
 * dfs -> 시간초과 발생
 * 스택 ..->
 * */
public class 큰수만들기_42883 {
    public static int maxDfsCreteria;
    public static int maxValue = Integer.MIN_VALUE;

    public static void main(String[] args) {
        //String number = "1924";
        String number = "4177252841";
        int k = 4;
        solution(number, k);
    }

    public static String solution(String number, int k) {
        boolean[] visited = new boolean[number.length()];
        //maxDfsCreteria = number.length() - k;
        //dfsSolution(number, new StringBuilder(), 0, visited);
        String result = stackSolution(number, k);
        return result;
    }

    public static void dfsSolution(String number, StringBuilder builderResult, int depth, boolean[] visited) {
        // 현재까지 만들어진 수가 이미 찾은 maxValue보다 작은 경우 가지치기 (Pruning)
        int len = builderResult.length();
        // 시작값이 작으면 볼 필요 없음
        if (len == maxDfsCreteria) {
            maxValue = Math.max(maxValue, Integer.parseInt(builderResult.toString()));
            return;
        }

        for (int i = depth; i < number.length(); i++) {
            // 시작값이 startvalue보다 작거나 builder의 0번째값이 startvalue보다 작으면 continue;
            if (!visited[i]) {
                visited[i] = true;
                builderResult.append(number.charAt(i));
                dfsSolution(number, builderResult, i + 1, visited);
                visited[i] = false;
                builderResult.deleteCharAt(builderResult.length() - 1);
            }
        }
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
