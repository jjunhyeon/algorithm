package com.pass.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 *  find_bigBackNumber 코드 수정
 *  왜  :  효율성문제에서 적합하지 않음
 *  프로그래머스 기준 find_big_backNubmer 제출 시 100점만점 80점
 *  2중 루프 사용으로 효율성 테스트케이스를 통과하지못해 개선했음
 *  결론 : stack 자료구조를 활용해서 단일 루프로 100점 통과
 *  시간복잡도 O (n^2) -> O(n) 으로 개선
 * */
public class update_find_bigBackNumber {
    public static void main(String[] args) {
        Arrays.toString(Solution(new int[]{9, 1, 5, 3, 6, 2}));
    }

    Stack<Integer> testStack = new Stack<Integer>();

    private static int[] Solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        // index의 뒷 큰수를 확인하기 위함
        for (int i = numbers.length - 1; i >= 0; i--) {
            // stack이 비어있지 않고 stack의 현재 마지막 값이 numbers[i]의 값보다 작으면
            // 비교한 stack의 값을 삭제한다.
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }
            // 스택이 비어있다면 while문에 의해 값들을 모두 비교한 뒤 남은 더 큰 값이므로
            // answer[i]에 값이 넣고 그렇지 않으면 -1을 넣는다.
            // 그리고 stack에 현재 numbers[i]값을 넣는다.
            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(numbers[i]);
        }
        return answer;
    }
}
