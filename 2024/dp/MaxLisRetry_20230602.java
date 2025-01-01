package dp;

import java.util.Scanner;

/*
* 최대 증가 부분수열
* */
public class MaxLisRetry_20230602 {
    static int[] dp;
    public static class Main {
        public static int solution(int[] arr){
            int result  = 0;
            dp[0] = 1;
            for(int i=1; i<arr.length; i++){
                int max = 0;// 아래 조건에 충족하지 않을 경우 기본값으로 1을 넣기 위해
                for(int j=i-1; j>=0; j--){
                    if(arr[j] < arr[i] && dp[j] >max){  //dp[j]
                        max = dp[j];
                    }
                }
                dp[i] = max +1;
                result = Math.max(result, dp[i]);
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int arrCnt =kb.nextInt();
        int arr[] = new int[arrCnt];

        // 정답 dp 배열
        dp = new int[arrCnt];
        for(int i=0; i<arrCnt; i++){
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(arr));
    }
}
