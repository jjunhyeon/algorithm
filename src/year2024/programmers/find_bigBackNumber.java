package year2024.programmers;

import java.util.Arrays;

public class find_bigBackNumber {
    public static void main(String[] args) {

        Arrays.toString(Solution(new int[]{9, 1, 5, 3, 6, 2}));
    }

    // 문제 : 담긴 배열의 값 중에서 해당 인덱스의 값보다 크면서 가까이 있는 뒷큰수를 찾아야한다.
    // 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/154539?language=java
    private static int[] Solution(int[] numbers) {
        
        // answer 배열을 파라미터 numbers 크기로 초기화
        int[] answer = new int[numbers.length];

        // 배열의 index를 기준으로 순회하면서 -1로 세팅
        for (int t = 0; t < numbers.length; t++) {
            answer[t] = -1;
            for (int j = t + 1; j < numbers.length; j++) {
                // 뒷큰수가 존재한다면 값 바꾸고 break;
                if (numbers[t] < numbers[j]) {
                    answer[t] = numbers[j];
                    break;
                }
            }
        }
        return answer;
    }
}

