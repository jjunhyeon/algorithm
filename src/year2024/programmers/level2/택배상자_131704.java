package src.year2024.programmers.level2;

import java.util.Stack;

public class 택배상자_131704 {
    public static void main(String[] args) {
        int[] order = {4, 3, 1, 2, 5};
        solution(order);
    }

    private static int solution(int[] order) {

        int[] priority = new int[order.length];
        // order로부터 실제 박스가 놓인 priority 배열 구현
        // order 배열의 숫자는 우선순위 박스의 위치
        for (int i = 0; i < order.length; i++) {
            priority[order[i] - 1] = i;
        }

        Stack<Integer> answer = new Stack<>();
        int target = 0;
        int idx = 0;
        while (idx < order.length) {
            // 우선순위가 맞는 박스가 순서에 있다면 그대로 처리
            if (priority[idx] == target) {
                target++;
            } else {
                // 그렇지 않으면 stack에 우선 담아둠
                answer.push(priority[idx]);
            }

            // 스택에 담긴 값이 현재 순서의 박스와 일치하다면 차에 실음
            while (!answer.isEmpty() && answer.peek() == target) {
                answer.pop();
                target++;
            }
            idx++;
        }
        return target;
    }
}
