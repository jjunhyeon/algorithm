package com.pass.algostudy.dp;

import java.util.Scanner;

/*
* 계단오르기
* 직관적인 방법으로 처리해버린다.
* 계단이 1개다 -> 방법은 1개다
* 계단이 2개다 -> 방법은 2개다.
* 문제를 소형화시키는 개념이다.
* 앞에 구해놓은 답을 메모이제이션해서 그 다음문제에 이를 활용해 처리하는 방식
* 순차적으로 처리하는 방식 Bottom up 방식
*
* */
public class StairClimb_20230528 {
    static int[] dy;
    public static class Test {
        public static int solution(int n){
            dy[1] = 1;
            dy[2] = 2;
            if(n > 2) {
                for (int i = 3; i <= n; i++) {
                    dy[i] = dy[i - 1] + dy[i - 2];
                }
            }
            return dy[n];
        }
    }

    public static void main(String[] args) {
        Test T = new Test();
        Scanner kb = new Scanner(System.in);
        int k = kb.nextInt();
        dy = new int[k+1];
        System.out.println(T.solution(k));
    }
}
