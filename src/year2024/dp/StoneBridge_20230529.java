package year2024.dp;

import java.util.Scanner;
/*
* 돌다리 건너기(앞에 푼 계단오르기와 같은 유형의 문제)
* 초기값 설정의 차이
* */
public class StoneBridge_20230529 {
    static int[] dy;
    public static class Test {
        public static int solution(int n){
            dy[1] = 2; // 개울을 최종 건너는것에 대한 방법을 채워야한다.
            dy[2] = 3; // 돌이 1,2개 있을때 개울을 건너는 방법에 생각해보면 된다.
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
