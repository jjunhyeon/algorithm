package com.pass.algostudy.sorting;

import java.util.Scanner;

/*
 * 정렬 후 탐색
 *
 * array로 받은 값을 정렬한 뒤(삽입정렬 사용했음) , 데이터가 대용량일 경우 퀵정렬 등의 알고리즘을 사용할 수 있어야함.
 * target 값이 몇번째 index에 존재하는지 이분 탐색하는 문제
 * */
public class SortAndFind_20230422 {
    // 실제 Solution
    static class Main {
        public int solution(int n, int target, int[] array) {
            int answer = 0;
            for (int i = 1; i < array.length; i++) {
                int tmp = array[i], j;
                for (j = i - 1; j > -1; j--) {
                    if (array[j] > tmp) {
                        array[j + 1] = array[j];
                    } else {
                        break;
                    }
                }
                array[j + 1] = tmp;
            }

            // 이분 검색
            int lt = 0, rt = n - 1;
            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                // 정답을 찾음 -> 0부터 시작 +1 값을 최종 답 리턴
                if (array[mid] == target) {
                    answer = mid + 1;
                    break;
                }
                // array[mid] 값이 target값 보다 큰 경우
                // target값은 array[mid] 값보다 무조건 왼쪽에 있으므로
                // lt는 그대로인 상태에서 rt값은 mid의 값보다 하나 더 작게 줄인다.
                // else는 반대로 적용
                if (array[mid] > target) {
                    rt = mid - 1;
                } else {
                    lt = mid + 1;
                }
            }
            return answer;
        }
    }

    /*
     * 값 입력받기
     * */
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, m, array));
    }
}
