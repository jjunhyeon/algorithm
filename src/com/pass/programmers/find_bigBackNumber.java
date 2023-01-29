package com.pass.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class find_bigBackNumber {
    public static void main(String[] args) {

        Arrays.toString(Solution(new int[]{9, 1, 5, 3, 6, 2}));
    }

    // 문제 : 담긴 배열의 값 중에서 해당 인덱스의 값보다 크면서 가까이 있는 뒷큰수를 찾아야한다.
    // 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/154539?language=java
    private static int[] Solution(int[] numbers) {
        
        // 최종 정답 배열 변수
        int[] answer;
        // 배열에 값을 추가하기 위한 리스트
        List<Integer> tmpArrayList = new ArrayList<>();

        // 배열의 index를 기준으로 순회하면서 큰 수가 존재하는지 확인한다.
        for (int t = 0; t <= numbers.length; t++) {
            if (t == numbers.length) {
                tmpArrayList.add(-1);
                break;
            }
            for (int j = t + 1; j < numbers.length; j++) {
                // 뒷큰수가 존재한다면 리스트에 갑을 넣고 break
                if (numbers[t] < numbers[j]) {
                    tmpArrayList.add(numbers[j]);
                    break;
                    // 마지막 순회할때까지 큰 값이 없다면 리스트 -1 추가
                } else if (j == numbers.length - 1 && numbers[t] >= numbers[j]) {
                    tmpArrayList.add(-1);
                }
            }
        }
        // list to Array 리턴
        return tmpArrayList.stream().mapToInt(Integer::intValue).toArray();
    }
}

