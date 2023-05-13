package com.pass.algostudy.dfs;

import java.util.Scanner;

/*
 * 최대 점수 구하기
 * 문제의 개수와 제한시간이 주어질때
 * 제한시간안에 얻을 수 있는 가장 높은 점수를 리턴해라.
 *
 * */
public class MaxScore_20230513 {

    // 한 문제가 가지는 소모값
    static int[] value;

    // 한 문제가 가지는 소요시간
    static int[] time;

    // 결과
    static int result = 0;

    // 최대 값 정보
    static int maxTime = Integer.MIN_VALUE;

    static class Main {
        public void DFS(int timeSum, int valueSum, int L) {
            // escape case
            // 1. 소요시간 > maxTime
            if (maxTime < timeSum) {
                return;
            }
            // 시간 합이 끝에 도달했을경우에도 더 이상 재귀 호출 할 필요 없음
            if (L == value.length || timeSum == maxTime) {
                result = Math.max(valueSum, result);
            } else {
                DFS(timeSum + time[L], valueSum + value[L], L + 1);
                DFS(timeSum, valueSum, L + 1);
            }
        }
    }

    /*
     * 값 입력받기
     * */
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int count = kb.nextInt();
        maxTime = kb.nextInt();

        value = new int[count];
        time = new int[count];
        for (int i = 0; i < count; i++) {
            value[i] = kb.nextInt();
            time[i] = kb.nextInt();
        }
        T.DFS(0, 0, 0);
        System.out.println(result);
    }
}
